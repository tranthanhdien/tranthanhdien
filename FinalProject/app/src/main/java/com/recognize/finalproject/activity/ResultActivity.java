package com.recognize.finalproject.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;
import com.googlecode.tesseract.android.TessBaseAPI;
import com.recognize.finalproject.R;
import com.recognize.finalproject.dao.DatabaseHelper;

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static android.provider.MediaStore.Images.Media.getBitmap;

public class ResultActivity extends AppCompatActivity {
    public static final String TESS_DATA = "/tessdata";
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String DATA_PATH = Environment.getExternalStorageDirectory().toString() + "/Tess";
    private TessBaseAPI tessBaseAPI;
    // Tạo, xóa liên quan đến SQLite
    DatabaseHelper databaseHelper;
    // Đọc kết quả
    TextToSpeech textToSpeech;
    // Image đã crops
    ImageView imgViewShow, imgEditOriginal;
    EditText edtOriginal, edtResult;
    Toolbar toolBarResult;
    Button btnGraph, btnSolveDetail;
    Bitmap grayBitmap, imageBitmap, newBitmap;
    // Biến Uri hình ảnh đã crop
    Uri imageCroppedURI;
    // Biến để lưu kết quả
    double result = 0;
    // Bài toán ban đầu (bao gồm hình ảnh đã crop và giọng nói) gửi qua
    String originalData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        if (OpenCVLoader.initDebug()) {
            Log.d("", "OpenCV 3.4.3 loaded");
            //Toast.makeText(ResultActivity.this, "OpenCV 3.4.7 loaded", Toast.LENGTH_LONG).show();
        } else {
            Log.d("", "OpenCV 3.4.3 is not loaded");
            //Toast.makeText(ResultActivity.this, "OpenCV 3.4.7 not loaded", Toast.LENGTH_LONG).show();
        }

        getSupportActionBar().hide(); // ẩn thanh ActionBar đi
        // Phải để databaseHelper lên trước, không sẽ bị lỗi ngay
        databaseHelper = new DatabaseHelper(this);
        addControls(); // ánh xạ
        getDataIntent(); // lấy dữ liệu intent gửi qua
        addEvents(); // xử lý sự kiện

    }

    // Hàm lấy ngày giờ hiện tại
    public String getDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = sdf.format(new Date());
        return date;
    }

    // hàm này để kiểm tra có dữ liệu có đc gửi qua hay không
    private void getDataIntent() {
        Intent intent = getIntent();

        // Phần hình ảnh crop: nếu có dữ liệu hình ảnh đã crop gửi qua
        if (intent != null) {
            if (intent.hasExtra("imageCropped")) {
                imageCroppedURI = Uri.parse(intent.getStringExtra("imageCropped"));
                imgViewShow.setImageURI(imageCroppedURI);
                // get drawable bitmap for text recognition
                BitmapDrawable bitmapDrawable = (BitmapDrawable) imgViewShow.getDrawable();
                imageBitmap = bitmapDrawable.getBitmap(); // lấy ra bitmap của hình ảnh đã crop

                // Gọi hàm xử lý ảnh trước khi nhận dạng, truyền vào 1 bức ảnh là bitmap
                newBitmap = toGrayscale(imageBitmap);
                //imgViewShow.setImageBitmap(newBitmap);
                // tempOpenCV();
                TextRecognizer recognizer = new TextRecognizer.Builder(getApplicationContext()).build();
                if (!recognizer.isOperational()) {
                    Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();

                } else {
                    Frame frame = new Frame.Builder().setBitmap(newBitmap).build();
                    SparseArray<TextBlock> items = recognizer.detect(frame);
                    StringBuilder sb = new StringBuilder();
                    // lấy text cho đến khi không còn
                    for (int i = 0; i < items.size(); i++) {
                        TextBlock myItem = items.valueAt(i);
                        sb.append(myItem.getValue());
                        sb.append("\n");
                    }
                    // set text to edit text
                    edtOriginal.setText(sb.toString());
                    originalData = sb.toString().trim(); // Phải có trim(), nếu ko chắc chắn báo lỗi
                    try {
                        result = eval(originalData);
                        edtResult.setText("Kết quả: " + result);
                        edtResult.setEnabled(false);
                        edtResult.setTextColor(Color.RED);
                        // Lưu vào lịch sử
                        addData(originalData, getDateTime());
                        // đọc kết quả lên
                        textToSpeech = new TextToSpeech(ResultActivity.this, new TextToSpeech.OnInitListener() {
                            @Override
                            public void onInit(int status) {
                                // kiểm tra trạng thái
                                if (status != TextToSpeech.ERROR) {
                                    textToSpeech.setLanguage(Locale.ENGLISH);
                                    textToSpeech.setSpeechRate(0.70f);
                                    // textToSpeech.speak("Result is: " + result, TextToSpeech.QUEUE_FLUSH, null);
                                }
                            }
                        });
                        // Show success dialog
                        AlertDialog.Builder builder = new AlertDialog.Builder(ResultActivity.this, R.style.AlertDialogTheme);
                        View view = LayoutInflater.from(ResultActivity.this).inflate(R.layout.layout_success_dialog,
                                (ConstraintLayout) findViewById(R.id.layoutDialogContainer));
                        builder.setView(view);
                        ((TextView) view.findViewById(R.id.textTitle)).setText(getResources().getString(R.string.success_title));
                        ((TextView) view.findViewById(R.id.textMesage)).setText(getResources().getString(R.string.dummy_text_success));
                        ((Button) view.findViewById(R.id.buttonAction)).setText(getResources().getString(R.string.okay));
                        ((ImageView) view.findViewById(R.id.imageIcon)).setImageResource(R.drawable.ic_success);
                        final AlertDialog alertDialog = builder.create();
                        view.findViewById(R.id.buttonAction).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                alertDialog.dismiss();
                            }
                        });
                        if (alertDialog.getWindow() != null) {
                            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                        }
                        alertDialog.show();
                    } catch (Exception e) {
                        edtResult.setText("Kết quả: " + result);
                        edtResult.setEnabled(false);
                        edtResult.setTextColor(Color.RED);
                        // sai thì đọc câu thông báo
                        textToSpeech = new TextToSpeech(ResultActivity.this, new TextToSpeech.OnInitListener() {
                            @Override
                            public void onInit(int status) {
                                // kiểm tra trạng thái
                                if (status != TextToSpeech.ERROR) {
                                    textToSpeech.setLanguage(Locale.ENGLISH);
                                    textToSpeech.setSpeechRate(1.5f);
                                    textToSpeech.speak("Please try again", TextToSpeech.QUEUE_FLUSH, null);
                                }
                            }
                        });
                        // Show error dialog
                        AlertDialog.Builder builder = new AlertDialog.Builder(ResultActivity.this, R.style.AlertDialogTheme);
                        View view = LayoutInflater.from(ResultActivity.this).inflate(R.layout.layout_error_dialog,
                                (ConstraintLayout) findViewById(R.id.layoutDialogContainer));
                        builder.setView(view);
                        ((TextView) view.findViewById(R.id.textTitle)).setText(getResources().getString(R.string.error_title));
                        ((TextView) view.findViewById(R.id.textMesage)).setText(getResources().getString(R.string.dummy_text_error));
                        ((Button) view.findViewById(R.id.buttonAction)).setText(getResources().getString(R.string.okay));
                        ((ImageView) view.findViewById(R.id.imageIcon)).setImageResource(R.drawable.ic_error);
                        final AlertDialog alertDialog = builder.create();
                        view.findViewById(R.id.buttonAction).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                alertDialog.dismiss();
                            }
                        });
                        if (alertDialog.getWindow() != null) {
                            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                        }
                        alertDialog.show();
                    }
                }
            }
        }
        // Phần giọng nói: nếu có dữ liệu Voice gửi qua
        if (intent != null) {
            if (intent.hasExtra("listVoice")) {
                final ArrayList<String> resultVoice = intent.getStringArrayListExtra("listVoice");
                imgViewShow.setImageResource(R.drawable.reg_voice);
                edtOriginal.setText(resultVoice.get(0));
                // Test thử cho pt bậc 1: A x + b = 0
                int length = resultVoice.get(0).length();
                Toast.makeText(ResultActivity.this, "Length: " + length, Toast.LENGTH_LONG).show();
                if (length == 10 || length == 11 || length == 12) {
                    originalData = resultVoice.get(0);
                    // nếu là pt: y = ax + b thì không giải, chỉ vẽ đồ thị
                    if (originalData.charAt(0) == 'y') {

                        return;
                    } else {
                        // ngược lại là pt: ax + b = 0 thì giải
                        double x = 0;
                        char a = originalData.charAt(0);
                        char b = originalData.charAt(6);
                        int heSoA = Integer.parseInt(String.valueOf(a));
                        int heSoB = Integer.parseInt(String.valueOf(b));
                        //Toast.makeText(ResultActivity.this, b, Toast.LENGTH_LONG).show();
                        x = (-b / a);
                        edtResult.setText("Kết quả: x = " + x);
                        edtResult.setEnabled(false);
                        edtResult.setTextColor(Color.RED);
                        // Lưu vào lịch sử
                        addData(resultVoice.get(0), getDateTime());
                        // Show success dialog
                        AlertDialog.Builder builder = new AlertDialog.Builder(ResultActivity.this, R.style.AlertDialogTheme);
                        View view = LayoutInflater.from(ResultActivity.this).inflate(R.layout.layout_success_dialog,
                                (ConstraintLayout) findViewById(R.id.layoutDialogContainer));
                        builder.setView(view);
                        ((TextView) view.findViewById(R.id.textTitle)).setText(getResources().getString(R.string.success_title));
                        ((TextView) view.findViewById(R.id.textMesage)).setText(getResources().getString(R.string.dummy_text_success));
                        ((Button) view.findViewById(R.id.buttonAction)).setText(getResources().getString(R.string.okay));
                        ((ImageView) view.findViewById(R.id.imageIcon)).setImageResource(R.drawable.ic_success);
                        final AlertDialog alertDialog = builder.create();
                        view.findViewById(R.id.buttonAction).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                alertDialog.dismiss();
                            }
                        });
                        if (alertDialog.getWindow() != null) {
                            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                        }
                        alertDialog.show();
                    }
                }
                // ngược lại không phải pt: y = ax +- b
                else {
                    try {
                        originalData = resultVoice.get(0);
                        result = eval(originalData);
                        edtResult.setText("Kết quả: " + result);
                        //edtResult.setEnabled(false);
                        edtResult.setTextColor(Color.RED);
                        // Lưu vào lịch sử
                        addData(resultVoice.get(0), getDateTime());
                        // đọc kết quả lên
                        textToSpeech = new TextToSpeech(ResultActivity.this, new TextToSpeech.OnInitListener() {
                            @Override
                            public void onInit(int status) {
                                // kiểm tra trạng thái
                                if (status != TextToSpeech.ERROR) {
                                    textToSpeech.setLanguage(Locale.ENGLISH);
                                    // textToSpeech.speak("Result is" + result, TextToSpeech.QUEUE_FLUSH, null);
                                }
                            }
                        });
                        // Show success dialog
                        AlertDialog.Builder builder = new AlertDialog.Builder(ResultActivity.this, R.style.AlertDialogTheme);
                        View view = LayoutInflater.from(ResultActivity.this).inflate(R.layout.layout_success_dialog,
                                (ConstraintLayout) findViewById(R.id.layoutDialogContainer));
                        builder.setView(view);
                        ((TextView) view.findViewById(R.id.textTitle)).setText(getResources().getString(R.string.success_title));
                        ((TextView) view.findViewById(R.id.textMesage)).setText(getResources().getString(R.string.dummy_text_success));
                        ((Button) view.findViewById(R.id.buttonAction)).setText(getResources().getString(R.string.okay));
                        ((ImageView) view.findViewById(R.id.imageIcon)).setImageResource(R.drawable.ic_success);
                        final AlertDialog alertDialog = builder.create();
                        view.findViewById(R.id.buttonAction).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                alertDialog.dismiss();
                            }
                        });
                        if (alertDialog.getWindow() != null) {
                            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                        }
                        alertDialog.show();
                    } catch (Exception e) {
                        // Ngược lại, không nhận dạng được
                        edtResult.setText("Kết quả: " + result);
                        edtResult.setEnabled(false);
                        edtResult.setTextColor(Color.RED);
                        // sai thì đọc câu thông báo
                        textToSpeech = new TextToSpeech(ResultActivity.this, new TextToSpeech.OnInitListener() {
                            @Override
                            public void onInit(int status) {
                                // kiểm tra trạng thái
                                if (status != TextToSpeech.ERROR) {
                                    textToSpeech.setLanguage(Locale.ENGLISH);
                                    textToSpeech.setSpeechRate(1.5f);
                                    textToSpeech.speak("Please try again", TextToSpeech.QUEUE_FLUSH, null);
                                }
                            }
                        });
                        // Show error dialog
                        AlertDialog.Builder builder = new AlertDialog.Builder(ResultActivity.this, R.style.AlertDialogTheme);
                        View view = LayoutInflater.from(ResultActivity.this).inflate(R.layout.layout_error_dialog,
                                (ConstraintLayout) findViewById(R.id.layoutDialogContainer));
                        builder.setView(view);
                        ((TextView) view.findViewById(R.id.textTitle)).setText(getResources().getString(R.string.error_title));
                        ((TextView) view.findViewById(R.id.textMesage)).setText(getResources().getString(R.string.dummy_text_error));
                        ((Button) view.findViewById(R.id.buttonAction)).setText(getResources().getString(R.string.okay));
                        ((ImageView) view.findViewById(R.id.imageIcon)).setImageResource(R.drawable.ic_error);
                        final AlertDialog alertDialog = builder.create();
                        view.findViewById(R.id.buttonAction).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                alertDialog.dismiss();
                            }
                        });
                        if (alertDialog.getWindow() != null) {
                            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                        }
                        alertDialog.show();
                    }
                }
            }
        }
        // Phần History: lấy data bên HistoryActivity gửi qua
        if (intent != null) {
            if (intent.hasExtra("dataHistory")) {
                originalData = intent.getStringExtra("dataHistory");
                imgViewShow.setImageResource(R.drawable.reg_voice);
                edtOriginal.setText(originalData);
                try {
                    result = eval(originalData);
                    edtResult.setText("Kết quả: " + result);
                    edtResult.setEnabled(false);
                    edtResult.setTextColor(Color.RED);
                } catch (Exception e) {
                    Toast.makeText(ResultActivity.this, "Lỗi", Toast.LENGTH_LONG).show();
                }
            }
        }

    }

    // Xử lý ảnh trước khi đưa vào nhận dạng
    public void detectEdges() {
        Mat rgba = new Mat();
        Mat grayMat = new Mat();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = false;
        options.inSampleSize = 4;

        int width = imageBitmap.getWidth();
        int height = imageBitmap.getHeight();

        grayBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        Utils.bitmapToMat(imageBitmap, rgba);
        Imgproc.cvtColor(rgba, grayMat, Imgproc.COLOR_RGB2GRAY);
        Utils.matToBitmap(grayMat, grayBitmap);
        imgViewShow.setImageBitmap(grayBitmap);
//        Mat rgba = new Mat();
//        Utils.bitmapToMat(bitmap, rgba);
//
//        Mat edges = new Mat(rgba.size(), CvType.CV_8UC1);
//        Imgproc.cvtColor(rgba, edges, Imgproc.COLOR_RGB2GRAY, 4);
//        Imgproc.Canny(edges, edges, 80, 100);

        // Don't do that at home or work it's for visualization purpose.
//        BitmapHelper.showBitmap(this, bitmap, imageView);
//        Bitmap resultBitmap = Bitmap.createBitmap(edges.cols(), edges.rows(), Bitmap.Config.ARGB_8888);
//        Utils.matToBitmap(edges, resultBitmap);
//        BitmapHelper.showBitmap(this, resultBitmap, detectEdgesImageView);
    }


    private void addEvents() {
        toolBarResult.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // cho phép sửa lại biểu thức nếu chưa chính xác
        imgEditOriginal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                originalData = edtOriginal.getText().toString();
                try {
                    result = eval(originalData);
                    edtResult.setText("Kết quả: " + result);
                    edtResult.setTextColor(Color.RED);
                    edtResult.setEnabled(false);
                } catch (Exception e) {
                    Log.d("Lỗi", e.getMessage());
                }
                Toast.makeText(ResultActivity.this, "Sửa thành công", Toast.LENGTH_LONG).show();
            }
        });
        imgViewShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        // sự kiện khi nhấn nút xem chi tiết
        btnSolveDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ResultActivity.this, "Đang cập nhật...", Toast.LENGTH_LONG).show();
            }
        });

        // sự kiện khi nhấn nút xem đồ thị
        btnGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // nếu là phương trình bậc 1 có dạng: y = ax + b thì mới hỗ trợ đồ thị
                if (originalData.charAt(0) == 'y') {
                    Intent intent = new Intent(ResultActivity.this, GraphViewActivity.class);
                    // gửi dữ liệu bài toán qua GraphActivity
                    intent.putExtra("graph", originalData);
                    startActivity(intent);
                } else {
                    Toast.makeText(ResultActivity.this, "Không hỗ trợ đồ thị", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void addControls() {
        // Khai báo
        toolBarResult = (Toolbar) findViewById(R.id.toolBarResult);
        toolBarResult.setTitle("Kết quả + Hướng dẫn");

        imgViewShow = (ImageView) findViewById(R.id.imgViewShow);
        imgEditOriginal = (ImageView) findViewById(R.id.imgEditOriginal);
        edtOriginal = (EditText) findViewById(R.id.edtOriginal);
        edtResult = (EditText) findViewById(R.id.edtResult);
        btnGraph = (Button) findViewById(R.id.btnGraph);
        btnSolveDetail = (Button) findViewById(R.id.btnSolveDetail);
    }

    private void prepareTessData() {
        try {
            File dir = getExternalFilesDir(TESS_DATA);
            if (!dir.exists()) {
                if (!dir.mkdir()) {
                    Toast.makeText(getApplicationContext(), "The folder " + dir.getPath() + "was not created", Toast.LENGTH_SHORT).show();
                }
            }
            String fileList[] = getAssets().list("");
            for (String fileName : fileList) {
                String pathToDataFile = dir + "/" + fileName;
                if (!(new File(pathToDataFile)).exists()) {
                    InputStream in = getAssets().open(fileName);
                    OutputStream out = new FileOutputStream(pathToDataFile);
                    byte[] buff = new byte[1024];
                    int len;
                    while ((len = in.read(buff)) > 0) {
                        out.write(buff, 0, len);
                    }
                    in.close();
                    out.close();
                }
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    private void startOCR(Bitmap bitmap) {
        try {
//            BitmapFactory.Options options = new BitmapFactory.Options();
//            options.inJustDecodeBounds = false;
//            options.inSampleSize = 6;
//            Bitmap bitmap = BitmapFactory.decodeFile(imageUri.getPath(), options);
            String result = this.getText(bitmap);
            edtOriginal.setText(result);
            Log.d("Kết quả: ", result);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    private String getText(Bitmap bitmap) {
        try {
            tessBaseAPI = new TessBaseAPI();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        String dataPath = getExternalFilesDir("/").getPath() + "/";
        tessBaseAPI.init(dataPath, "eng");
        tessBaseAPI.setImage(bitmap);
        String retStr = "No result";
        try {
            retStr = tessBaseAPI.getUTF8Text();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        tessBaseAPI.end();
        return retStr;
    }

    // Phương thức để giải
    public double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (; ; ) {
                    if (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (; ; ) {
                    if (eat('x') || eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equalsIgnoreCase("sqrt") || (func.equalsIgnoreCase("can") || (func.equalsIgnoreCase("cang"))))
                        x = Math.sqrt(x);
                    else if (func.equalsIgnoreCase("sin") || (func.equalsIgnoreCase("sinh") || (func.equalsIgnoreCase("sing"))))
                        x = Math.sin(Math.toRadians(x));
                    else if (func.equalsIgnoreCase("cos") || (func.equalsIgnoreCase("coi") || (func.equalsIgnoreCase("cost"))))
                        x = Math.cos(Math.toRadians(x));
                    else if (func.equalsIgnoreCase("tan") || (func.equalsIgnoreCase("tang") || func.equalsIgnoreCase("tang")))
                        x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    // Toast.makeText(ResultActivity.this, "Không thể nhận dạng", Toast.LENGTH_LONG).show();
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }

    // Phương thức để thêm data vào lịch sử (HistoryActivity)
    public void addData(String name, String date) {
        // Nó sẽ gọi phương thức bên databaseHelper để xử lý
        boolean insertData = databaseHelper.insertData(name, date);

        if (insertData) {
            // toastMessage("Data Successfully Inserted!");
        } else {
            toastMessage("Something went wrong");
        }
    }

    /**
     * customizable toast
     *
     * @param message
     */
    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    // chuyển hình ảnh sang GrayScale
    public Bitmap toGrayscale(Bitmap bitmapOriginal) {
        //"CHUYỂN BITMAP SANG MAT, THAO TÁC, RỒI CHUYỂN LẠI"
        Mat mat_origin = new Mat();

        Utils.bitmapToMat(bitmapOriginal, mat_origin);


        //Blur:
        Mat matBlur = new Mat();    //có thể nhận vào tham số (rows, cols, CvType.CV_8UC4) tương đương với (bitmap.getHeigh(), bitmap.getWidth(), CvType.CV_8UC4)
        //Origin -> Blur
        Imgproc.blur(mat_origin, matBlur, new Size(10, 10)); //thao tác
        Bitmap bmBlur = Bitmap.createBitmap(mat_origin.cols(), mat_origin.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(matBlur, bmBlur);
        imgViewShow.setImageBitmap(bmBlur);
        //Ảnh xám:
        Mat matGray = new Mat();
        //Blur -> Gray
        Imgproc.cvtColor(matBlur, matGray, Imgproc.COLOR_BGR2GRAY); //thao tác
        Bitmap bmGray = Bitmap.createBitmap(mat_origin.cols(), mat_origin.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(matGray, bmGray);
        imgViewShow.setImageBitmap(bmGray);


//        //Threshold:
//        Mat matThreshold = new Mat();
//        //Gray -> Threshold
//        Imgproc.threshold(matGray, matThreshold, 127, 255, Imgproc.THRESH_BINARY_INV); //pixel nào lớn hơn ngưỡng (127) thì gán giá trị "sáng nhất" của màu đó (255)
////        Imgproc.adaptiveThreshold(matGray, matThreshold, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY_INV, 11, 12);
//        Bitmap bmThreshold = Bitmap.createBitmap(mat_origin.cols(), mat_origin.rows(), Bitmap.Config.ARGB_8888);
//        Utils.matToBitmap(matThreshold, bmThreshold);
//        imgViewShow.setImageBitmap(bmThreshold);
        return bmGray;
    }

    private void tempOpenCV() {

//        ImageView imgGray = findViewById(R.id.imgGray);
//        ImageView imgBlur = findViewById(R.id.imgBlur);
//        ImageView imgThreshold = findViewById(R.id.imgThreshold);
//        ImageView imgContour = findViewById(R.id.imgContour);
//        ImageView imgBounding = findViewById(R.id.imgBounding);

        //"CHUYỂN BITMAP SANG MAT, THAO TÁC, RỒI CHUYỂN LẠI"
        Bitmap bitmap_origin = null;
        Mat mat_origin = new Mat();
        try {
            // imageBitmap: bitmap gốc
            bitmap_origin = getBitmap(getContentResolver(), imageCroppedURI);
            Utils.bitmapToMat(bitmap_origin, mat_origin);  //chuyển dữ liệu tự bitmap đến mat
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Blur:
        Mat matBlur = new Mat();    //có thể nhận vào tham số (rows, cols, CvType.CV_8UC4) tương đương với (bitmap.getHeigh(), bitmap.getWidth(), CvType.CV_8UC4)
        //Origin -> Blur
        Imgproc.blur(mat_origin, matBlur, new Size(10, 10)); //thao tác
        Bitmap bmBlur = Bitmap.createBitmap(mat_origin.cols(), mat_origin.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(matBlur, bmBlur);
        imgViewShow.setImageBitmap(bmBlur);


        //Ảnh xám:
        Mat matGray = new Mat();
        //Blur -> Gray
        Imgproc.cvtColor(matBlur, matGray, Imgproc.COLOR_BGR2GRAY); //thao tác
        Bitmap bmGray = Bitmap.createBitmap(mat_origin.cols(), mat_origin.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(matGray, bmGray);
        imgViewShow.setImageBitmap(bmGray);


        //Threshold:
        Mat matThreshold = new Mat();
        //Gray -> Threshold
        Imgproc.threshold(matGray, matThreshold, 127, 255, Imgproc.THRESH_BINARY_INV); //pixel nào lớn hơn ngưỡng (127) thì gán giá trị "sáng nhất" của màu đó (255)
//        Imgproc.adaptiveThreshold(matGray, matThreshold, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY_INV, 11, 12);
        Bitmap bmThreshold = Bitmap.createBitmap(mat_origin.cols(), mat_origin.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(matThreshold, bmThreshold);
        imgViewShow.setImageBitmap(bmThreshold);


        //Find Contours:
        List<MatOfPoint> lstMatOfPoint = new ArrayList<>(); //danh sách các contour
        Mat matHierarchy = new Mat();
        //RETR_EXTERNAL nghĩa là lấy contour bên ngoài, không tính contour bên trong, ví dụ: 6, 8, 9
        Imgproc.findContours(matThreshold, lstMatOfPoint, matHierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE); //SIMPLE chỉ lưu những điểm cần thiết, NONE lưu hết
        //chuyển về kênh BGR để hiển thị được màu của Scalar
        // tham số -1 là vẽ tất cả contour
        //thickness quan trọng, nhờ nó lớn mà mình mới thấy được contour đã vẽ :), nếu thickness = -1 thì nó sẽ fill luôn lỗ của số 6, 8, 9,...
        Mat matContour = matThreshold.clone();  //clone để bảo toàn matThreshold
        Imgproc.cvtColor(matContour, matContour, Imgproc.COLOR_GRAY2BGR);
        Imgproc.drawContours(matContour, lstMatOfPoint, -1, new Scalar(0, 255, 0), 10);   //vẽ các contour lên matContour
        Bitmap bmContour = Bitmap.createBitmap(mat_origin.cols(), mat_origin.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(matContour, bmContour);
        imgViewShow.setImageBitmap(bmContour);


        //Bounding Box Rectangle:
        Mat matBounding = matContour.clone();
        for (int i = 0; i < lstMatOfPoint.size(); i++) {
            Rect rect = Imgproc.boundingRect(lstMatOfPoint.get(i));
            Imgproc.rectangle(matBounding, rect.tl(), rect.br(), new Scalar(255, 0, 0), 10); //vẽ
        }
        Bitmap bmBounding = Bitmap.createBitmap(mat_origin.cols(), mat_origin.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(matBounding, bmBounding);
        imgViewShow.setImageBitmap(bmBounding);
    }
}
