package com.recognize.finalproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;
import com.googlecode.tesseract.android.TessBaseAPI;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import io.github.kexanie.library.MathView;

public class ResultActivity extends AppCompatActivity {
    public static final String TESS_DATA = "/tessdata";
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String DATA_PATH = Environment.getExternalStorageDirectory().toString() + "/Tess";
    private TessBaseAPI tessBaseAPI;
    private Uri outputFileDir;
    DatabaseHelper databaseHelper;

    ImageView imgViewShow;
    EditText edtOriginal, edtResult;
    Toolbar toolBarResult;
    Button btnSolveDetail;
    MathView mathView;
    String tex = "This come from string. You can insert inline formula:" +
            " \\(ax^2 + bx + c = 0\\) " +
            "or displayed formula: $$\\sum_{i=0}^n i^2 = \\frac{(n^2+n)(2n+1)}{6}$$";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        // ẩn thanh ActionBar đi
        getSupportActionBar().hide();
        // Phải để databaseHelper lên trước, không sẽ bị lỗi ngay
        databaseHelper = new DatabaseHelper(this);
        addControls();
        getDataIntent();
        addEvents();

    }

    // hàm này để kiểm tra có dữ liệu có đc gửi qua hay không
    private void getDataIntent() {
        Intent intent = getIntent();

        // nếu có dữ liệu hình ảnh đã crop gửi qua
        if (intent != null) {
            if (intent.hasExtra("imageCropped")) {
                imgViewShow.setImageURI(Uri.parse(intent.getStringExtra("imageCropped")));

                // get drawable bitmap for text recognition
                BitmapDrawable bitmapDrawable = (BitmapDrawable) imgViewShow.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap(); // representation of the image, eg: PNG, JPG

                TextRecognizer recognizer = new TextRecognizer.Builder(getApplicationContext()).build();
                if (!recognizer.isOperational()) {
                    Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();

                } else {
                    Frame frame = new Frame.Builder().setBitmap(bitmap).build();
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
                    String result = sb.toString().trim(); // Phải có trim(), nếu ko chắc chắn báo lỗi
                    // Toast.makeText(ResultActivity.this, result, Toast.LENGTH_LONG).show();
                    edtResult.setText("Kết quả: " + eval(result));
                    // Lưu vào lịch sử
                    addData(result);
                }
            }
        }
        // nếu có dữ liệu Voice gửi qua
        if (intent != null) {
            if (intent.hasExtra("listVoice")) {
                ArrayList<String> resultVoice = intent.getStringArrayListExtra("listVoice");
                imgViewShow.setImageResource(R.drawable.reg_voice);
                edtOriginal.setText(resultVoice.get(0));
                double anwser = eval(resultVoice.get(0));
                edtResult.setText("Kết quả: " + anwser);
                // Lưu vào lịch sử
                addData(resultVoice.get(0));
            }
        }
    }

    private void addEvents() {
        toolBarResult.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
    }

    private void addControls() {
        // Khai báo
        toolBarResult = (Toolbar) findViewById(R.id.toolBarResult);
        toolBarResult.setTitle("Result");

        imgViewShow = (ImageView) findViewById(R.id.imgViewShow);
        edtOriginal = (EditText) findViewById(R.id.edtOriginal);
        edtResult = (EditText) findViewById(R.id.edtResult);
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
                        if (func.equals("sqrt") || (func.equalsIgnoreCase("can") || (func.equalsIgnoreCase("cang"))))
                            x = Math.sqrt(x);
                        else if (func.equals("sin") || (func.equalsIgnoreCase("sinh") || (func.equalsIgnoreCase("sing"))))
                            x = Math.sin(Math.toRadians(x));
                        else if (func.equals("cos") || (func.equalsIgnoreCase("coi") || (func.equalsIgnoreCase("cost"))))
                            x = Math.cos(Math.toRadians(x));
                        else if (func.equals("tan") || (func.equalsIgnoreCase("tang") || func.equalsIgnoreCase("tang")))
                            x = Math.tan(Math.toRadians(x));
                        else throw new RuntimeException("Unknown function: " + func);
                    } else {
                        Toast.makeText(ResultActivity.this, "Không thể nhận dạng", Toast.LENGTH_LONG).show();
                        throw new RuntimeException("Unexpected: " + (char) ch);
                    }

                    if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                    return x;
                }
            }.parse();
        }

    // Phương thức để thêm data vào lịch sử (HistoryActivity)
    public void addData(String item) {
        // Nó sẽ gọi phương thức bên databaseHelper để xử lý
        boolean insertData = databaseHelper.insertData(item);

        if (insertData) {
            toastMessage("Data Successfully Inserted!");
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
}
