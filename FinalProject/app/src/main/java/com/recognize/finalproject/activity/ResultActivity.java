package com.recognize.finalproject.activity;

import android.content.Intent;
import android.graphics.Bitmap;
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
import com.recognize.finalproject.R;
import com.recognize.finalproject.dao.DatabaseHelper;
import com.recognize.finalproject.model.TKomplex;
import com.shashank.sony.fancytoastlib.FancyToast;

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.tensorflow.lite.Interpreter;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;

import io.github.kexanie.library.MathView;

import static android.provider.MediaStore.Images.Media.getBitmap;

public class ResultActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String DATA_PATH = Environment.getExternalStorageDirectory().toString() + "/Tess";
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

    MathView formula_one;

    // Phần này cho phương trình bậc 3
    TKomplex x1, x2, x3; // nghiệm của pt
    double a1, a, b, c, d; // hệ số của pt

    //////////////////////////////////////////////////////////////////////

    private static final int RESULTS_TO_SHOW = 3;
    // options for model interpreter
    private final Interpreter.Options tfliteOptions = new Interpreter.Options();
    // tflite graph
    private Interpreter tflite;
    // holds all the possible labels for model
    private List<String> labelList;
    // holds the selected image data as bytes
    private ByteBuffer imgData = null;
    // holds the probabilities of each label for non-quantized graphs
    private float[][] labelProbArray = null;
    // holds the probabilities of each label for quantized graphs
    private byte[][] labelProbArrayB = null;
    // array that holds the labels with the highest probabilities
    private String[] topLables = null;
    // array that holds the highest probabilities
    private String[] topConfidence = null;

    // priority queue that will hold the top results from the CNN
    private PriorityQueue<Map.Entry<String, Float>> sortedLabels =
            new PriorityQueue<>(
                    RESULTS_TO_SHOW,
                    new Comparator<Map.Entry<String, Float>>() {
                        @Override
                        public int compare(Map.Entry<String, Float> o1, Map.Entry<String, Float> o2) {
                            return (o1.getValue()).compareTo(o2.getValue());
                        }
                    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        if (OpenCVLoader.initDebug()) {
            Log.d("", "OpenCV 3.4.7 loaded");
            //Toast.makeText(ResultActivity.this, "OpenCV 3.4.7 loaded", Toast.LENGTH_LONG).show();
        } else {
            Log.d("", "OpenCV 3.4.7 is not loaded");
            //Toast.makeText(ResultActivity.this, "OpenCV 3.4.7 not loaded", Toast.LENGTH_LONG).show();
        }

        getSupportActionBar().hide(); // ẩn thanh ActionBar đi
        // Phải để databaseHelper lên trước, không sẽ bị lỗi ngay
        databaseHelper = new DatabaseHelper(this);
        addControls(); // ánh xạ
        getDataIntent(); // lấy dữ liệu intent gửi qua
        addEvents(); // xử lý sự kiện

    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        String tex =
//                " \\(2x^2 + 2x - 1 = 0\\) " +
//                        "$$\\sum_{i=0}^n i^2 = \\frac{(n^2+n)(2n+1)}{6}$$";
//        String text = "\\" + result + "\\";
//
//        formula_one = (MathView) findViewById(R.id.formula_one);
//        formula_one.setText(tex);
//    }

    // hàm show từng bước giải
    public String showStepbyStep() {
        for (int i = 0; i < result; i++) {


        }
        return "";
    }

    // hàm giải phương trình bậc 2
    public String equation2(int a, int b, int c) {
        double delta = (b * b) - (4 * a * c);
        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
        return x1 + "" + x2;
    }

    public double xRoot(double a, double x) {
        double i = 1;
        if (a < 0) {
            i = -1;
        }
        return (i * Math.exp(Math.log(a * i) / x));
    }

    // Giải phương trình theo phương pháp Cardano
    public int calCardano() {
        double p, q, u, v;
        double r, alpha;
        int res;
        res = 0;
        if (a1 != 0) {
            a = b / a1;
            b = c / a1;
            c = d / a1;

            p = -(a * a / 3.0) + b;
            q = (2.0 / 27.0 * a * a * a) - (a * b / 3.0) + c;
            d = q * q / 4.0 + p * p * p / 27.0;
            if (Math.abs(d) < Math.pow(10.0, -11.0)) {
                d = 0;
            }
            // 3 cases: D > 0, D == 0, D <0
            if (d > 1e-20) {
                u = xRoot(-q / 2.0 + Math.sqrt(d), 3.0);
                v = xRoot(-q / 2.0 - Math.sqrt(d), 3.0);
                x1.real = u + v - a / 3.0;
                x2.real = -(u + v) / 2.0 - a / 3.0;
                x2.imag = Math.sqrt(3.0) / 2.0 * (u - v);
                x3.real = x2.real;
                x3.imag = -x2.imag;
                res = 1;
            }
            if (Math.abs(d) <= 1e-20) {
                u = xRoot(-q / 2.0, 3.0);
                v = xRoot(-q / 2.0, 3.0);
                x1.real = u + v - a / 3.0;
                x2.real = -(u + v) / 2.0 - a / 3.0;
                res = 2;
            }
            if (d < -1e-20) {
                r = Math.sqrt(-p * p * p / 27.0);
                alpha = Math.atan(Math.sqrt(-d) / -q * 2.0);
                if (q > 0) // if q > 0 the angle becomes 2 * PI - alpha
                {
                    alpha = 2.0 * Math.PI - alpha;
                }

                x1.real = xRoot(r, 3.0) * (Math.cos((6.0 * Math.PI - alpha) / 3.0) + Math.cos(alpha / 3.0)) - a / 3.0;
                x2.real = xRoot(r, 3.0) * (Math.cos((2.0 * Math.PI + alpha) / 3.0) + Math.cos((4.0 * Math.PI - alpha) / 3.0)) - a / 3.0;
                x3.real = xRoot(r, 3.0) * (Math.cos((4.0 * Math.PI + alpha) / 3.0) + Math.cos((2.0 * Math.PI - alpha) / 3.0)) - a / 3.0;
                res = 3;
            }
        } else {
            res = 0;
        }
        return res;
    }

    public void mainWin(double a1, double b, double c, double d) {
        x1 = new TKomplex();
        x2 = new TKomplex();
        x3 = new TKomplex();
        x1.real = 0;
        x1.imag = 0;
        x2.real = 0;
        x2.imag = 0;
        x3.real = 0;
        x3.imag = 0;
        // sample for D < 0

        // hệ số
//        a1 = 2.0;
//        b = 3.0;
//        c = -1.0;
//        d = -1.0;
//            tb_A.Text = String.valueOf(a1);
//            tb_B.Text = String.valueOf(b);
//            tb_C.Text = String.valueOf(c);
//            tb_D.Text = String.valueOf(d);
        if ((a1 != 0) && (b != 0) && (c != 0) && (d != 0)) {
            switch (calCardano()) {
                case 0: {
//                    tb_x1.Text = "";
//                    tb_x2.Text = "";
//                    tb_x3.Text = "";
                    edtResult.setText("x1: " + "\n" + "x2: " + "\n" + "x3: ");
//                    System.out.println("x1: ");
//                    System.out.println("x2: ");
//                    System.out.println("x3: ");
                    break;
                }
                case 1: {
                    edtResult.setText("x1: " + x1.real);
//                    System.out.println("x1: " + x1.real);
//                    System.out.println("x2: ");
//                    System.out.println("x3: ");
                    break;
                }
                case 2: {
                    edtResult.setText("x1: " + x1.real + "\n" + "x2: " + x2.real + "\n" + "x3: ");
//                    System.out.println("x1: " + x1.real);
//                    System.out.println("x2: " + x2.real);
//                    System.out.println("x3: ");
                    break;
                }
                case 3: {
                    edtResult.setText("x1: " + x1.real + "\n" + "x2: " + x2.real + "\n" + "x3: " + x3.real);
//                    System.out.println("x1: " + x1.real);
//                    System.out.println("x2: " + x2.real);
//                    System.out.println("x3: " + x3.real);
                    break;
                }
            }
        }
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
                //newBitmap = toGrayscale(imageBitmap);
                imgViewShow.setImageBitmap(newBitmap);
                newBitmap = imageProcessing(imageBitmap);
                // newBitmap = toGrayscale(imageBitmap);
                TextRecognizer recognizer = new TextRecognizer.Builder(getApplicationContext()).build();
                if (!recognizer.isOperational()) {
                    Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();

                } else {
                    Frame frame = new Frame.Builder().setBitmap(toGrayscale(imageBitmap)).build();
                    SparseArray<TextBlock> items = recognizer.detect(frame);
                    StringBuilder sb = new StringBuilder();
                    // lấy text cho đến khi không còn
                    for (int i = 0; i < items.size(); i++) {
                        TextBlock myItem = items.valueAt(i);
                        sb.append(myItem.getValue());
                        sb.append("\n");
                    }
                    String s = "";
                    originalData = sb.toString().trim(); // Phải có trim(), nếu ko chắc chắn báo lỗi

                    // set text to edit text
                    edtOriginal.setText(originalData);
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
                                    // textToSpeech.speak("Please try again", TextToSpeech.QUEUE_FLUSH, null);
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

                edtResult.setFocusable(false);
                // Test thử cho pt bậc 1: A x + b = 0
                int length = resultVoice.get(0).length();
                Toast.makeText(ResultActivity.this, "Length: " + length, Toast.LENGTH_LONG).show();
                if (length == 10 || length == 11 || length == 12) {
                    originalData = resultVoice.get(0);
                    // nếu là pt: y = ax + b thì không giải, chỉ vẽ đồ thị
                    if (originalData.charAt(0) == 'y') {
                        addData(originalData, getDateTime());
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
                                    //textToSpeech.speak("Please try again", TextToSpeech.QUEUE_FLUSH, null);
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
                // tạo hiệu ứng nhấp nháy hình ảnh
//                Animation animation = new AlphaAnimation(1,0);
//                animation.setDuration(600);
//                animation.setRepeatCount(Animation.INFINITE);
//                animation.setRepeatMode(Animation.REVERSE);
//                imgViewShow.startAnimation(animation);

                edtOriginal.setText(originalData);

                edtResult.setFocusable(false);
                try {
                    result = eval(originalData);
                    edtResult.setText("Kết quả: " + result);
                    edtResult.setTextColor(Color.RED);
                } catch (Exception e) {
                    edtResult.setText("Chỉ có đồ thị hàm số");
                    edtResult.setTextColor(Color.RED);
                    //Toast.makeText(ResultActivity.this, "Lỗi", Toast.LENGTH_LONG).show();
                }
            }
        }

    }

    // sự kiện
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
                databaseHelper.updateName(originalData, originalData = edtOriginal.getText().toString());
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
                // chuyển qua màn hình giải chi tiết (SolveDetailActivity)
                Intent intent = new Intent(ResultActivity.this, SolveDetailActivity.class);
                // gửi bài toán gốc qua
                intent.putExtra("expression", originalData);
                startActivity(intent);
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
                    FancyToast.makeText(ResultActivity.this, "Không hỗ trợ đồ thị!", FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                }
            }
        });
    }

    // ánh xạ
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
        // chuyển Bitmap sang Mat, xử ý sau đó chuyển về lại Bitmap
        Mat mat_origin = new Mat();
        Utils.bitmapToMat(bitmapOriginal, mat_origin);

        // blur:
        // có thể nhận vào tham số (rows, cols, CvType.CV_8UC4) tương đương với (bitmap.getHeigh(), bitmap.getWidth(), CvType.CV_8UC4)
        Mat matBlur = new Mat();
        Imgproc.blur(mat_origin, matBlur, new Size(10, 10)); // chuyển về blur
        // Sau đó chuyển về lại bitmap
        Bitmap bmBlur = Bitmap.createBitmap(mat_origin.cols(), mat_origin.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(matBlur, bmBlur);
        //imgViewShow.setImageBitmap(bmBlur);
        //Ảnh xám:
        Mat matGray = new Mat();
        //Blur -> Gray
        Imgproc.cvtColor(matBlur, matGray, Imgproc.COLOR_BGR2GRAY); //thao tác
        Bitmap bmGray = Bitmap.createBitmap(mat_origin.cols(), mat_origin.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(matGray, bmGray);
        //imgViewShow.setImageBitmap(bmGray);


        //Threshold:
        Mat matThreshold = new Mat();
        //Gray -> Threshold
        Imgproc.threshold(matGray, matThreshold, 127, 255, Imgproc.THRESH_OTSU); //pixel nào lớn hơn ngưỡng (127) thì gán giá trị "sáng nhất" của màu đó (255)
//        Imgproc.adaptiveThreshold(matGray, matThreshold, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY_INV, 11, 12);
        Bitmap bmThreshold = Bitmap.createBitmap(mat_origin.cols(), mat_origin.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(matThreshold, bmThreshold);
        //imgViewShow.setImageBitmap(bmThreshold);


        return bmThreshold;
    }


    private Bitmap imageProcessing(Bitmap originalBitmap) {

//        ImageView imgGray = findViewById(R.id.imgGray);
//        ImageView imgBlur = findViewById(R.id.imgBlur);
//        ImageView imgThreshold = findViewById(R.id.imgThreshold);
//        ImageView imgContour = findViewById(R.id.imgContour);
//        ImageView imgBounding = findViewById(R.id.imgBounding);

        // Chuyển Bitmap (ảnh) sang Mat, xử lý sau đó chuyển về lại Bitmap
        Bitmap bitmap_origin = originalBitmap;
        Mat mat_origin = new Mat();
        try {
            // imageBitmap: bitmap gốc
            bitmap_origin = getBitmap(getContentResolver(), imageCroppedURI);
            // Chuyển Bitmap sang Mat để xử lý
            Utils.bitmapToMat(bitmap_origin, mat_origin);
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Blur:
        Mat matBlur = new Mat();
        // Có thể nhận vào tham số (rows, cols, CvType.CV_8UC4) tương đương với (bitmap.getHeigh(), bitmap.getWidth(), CvType.CV_8UC4)
        // Chuyển ảnh gốc sang Blur
        Imgproc.blur(mat_origin, matBlur, new Size(10, 10));
        // Chuyển Mat về lại Bitmap
        Bitmap bmBlur = Bitmap.createBitmap(mat_origin.cols(), mat_origin.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(matBlur, bmBlur);
        // Show hình ảnh đã Blur
        imgViewShow.setImageBitmap(bmBlur);


        // Gray:
        Mat matGray = new Mat();
        // Chuyển Blur về Gray
        Imgproc.cvtColor(matBlur, matGray, Imgproc.COLOR_BGR2GRAY);
        // Chuyển Mat về lại Bitmap
        Bitmap bmGray = Bitmap.createBitmap(mat_origin.cols(), mat_origin.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(matGray, bmGray);
        // Show hình ảnh đã Gray
        imgViewShow.setImageBitmap(bmGray);


        // Threshold:
        Mat matThreshold = new Mat();
        // Chuyển Gray về Threshold
        Imgproc.threshold(matGray, matThreshold, 127, 255, Imgproc.THRESH_BINARY_INV); //pixel nào lớn hơn ngưỡng (127) thì gán giá trị "sáng nhất" của màu đó (255)
        // Imgproc.adaptiveThreshold(matGray, matThreshold, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY_INV, 11, 12);
        // Chuyển Mat về lại Bitmap
        Bitmap bmThreshold = Bitmap.createBitmap(mat_origin.cols(), mat_origin.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(matThreshold, bmThreshold);
        // Show hình ảnh đã Threshold
        imgViewShow.setImageBitmap(bmThreshold);


        // Tìm các Contours
        List<MatOfPoint> contours = new ArrayList<>(); // Danh sách các Contour
        Mat matHierarchy = new Mat();
        //RETR_EXTERNAL nghĩa là lấy contour bên ngoài, không tính contour bên trong, ví dụ: 6, 8, 9
        Imgproc.findContours(matThreshold, contours, matHierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE); //SIMPLE chỉ lưu những điểm cần thiết, NONE lưu hết
        // Chuyển về kênh BGR để hiển thị được màu của Scalar
        // Tham số -1 là vẽ tất cả contour
        // thickness là độ dày của chữ
        //thickness quan trọng, nhờ nó lớn mà mình mới thấy được contour đã vẽ :), nếu thickness = -1 thì nó sẽ fill luôn lỗ của số 6, 8, 9,...
        Mat matContour = matThreshold.clone();  // Clone để bảo toàn matThreshold
        // Chuyển về dạng GRAY2BGR
        Imgproc.cvtColor(matContour, matContour, Imgproc.COLOR_GRAY2BGR);
        // Vẽ Contours lên MatContour
        Imgproc.drawContours(matContour, contours, -1, new Scalar(0, 255, 0), 10);
        Bitmap bmContour = Bitmap.createBitmap(mat_origin.cols(), mat_origin.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(matContour, bmContour);
        imgViewShow.setImageBitmap(bmContour);

        // Bounding Box Rectangle:
        Mat matBounding = matContour.clone();
        for (int i = 0; i < contours.size(); i++) {
            Rect rect = Imgproc.boundingRect(contours.get(i));
            Imgproc.rectangle(matBounding, rect.tl(), rect.br(), new Scalar(255, 0, 0), 10); //vẽ
        }
        Bitmap bmBounding = Bitmap.createBitmap(mat_origin.cols(), mat_origin.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(matBounding, bmBounding);
        imgViewShow.setImageBitmap(bmBounding);


        return bmBounding;
    }

    // Xử lý hình ảnh
    public Bitmap process(Bitmap bitmapOriginal) {
        // chuyển Bitmap sang Mat, xử ý sau đó chuyển về lại Bitmap
        Bitmap origin = bitmapOriginal;
        Mat src = new Mat();
        Utils.bitmapToMat(origin, src);
        Mat gray = new Mat();
        Imgproc.cvtColor(src, gray, Imgproc.COLOR_RGBA2GRAY);
        Imgproc.Canny(gray, gray, 50, 200);
        Imgproc.threshold(gray, gray, 10, 255, Imgproc.THRESH_OTSU);

        List<MatOfPoint> contours = new ArrayList<>();
        Mat hierarchy = new Mat();
        Imgproc.findContours(gray, contours, hierarchy, Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE, new Point(0, 0));
        Imgproc.drawContours(src, contours, -1, new Scalar(0, 0, 255), -1);

        MatOfPoint2f approxCurve = new MatOfPoint2f();

        // For each contour found
        for (int i = 0; i < contours.size(); i++) {
            //Convert contours(i) from MatOfPoint to MatOfPoint2f
            MatOfPoint2f contour2f = new MatOfPoint2f(contours.get(i).toArray());
            //Processing on mMOP2f1 which is in type MatOfPoint2f
            double approxDistance = Imgproc.arcLength(contour2f, true) * 0.02;
            Imgproc.approxPolyDP(contour2f, approxCurve, approxDistance, true);

            // Convert back to MatOfPoint
            MatOfPoint points = new MatOfPoint(approxCurve.toArray());

            // Get bounding rect of contour
            Rect rect = Imgproc.boundingRect(points);

            // draw enclosing rectangle (all same color, but you could use variable i to make them unique)
            Imgproc.rectangle(src, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(255, 0, 255), 3);
        }
        Utils.matToBitmap(src, bitmapOriginal);
        imgViewShow.setImageBitmap(bitmapOriginal);
        return origin;
    }
}
