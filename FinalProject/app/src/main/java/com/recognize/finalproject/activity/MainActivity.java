package com.recognize.finalproject.activity;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.recognize.finalproject.R;
import com.recognize.finalproject.dao.DatabaseHelper;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    // Khai báo
    GridLayout mainGrid;
    CardView cardViewCamera, cardViewGallery, cardViewVoice, cardViewHistory, cardViewIntro, cardViewAbout;
    private static final int CAMERA_REQUEST_CODE = 200;
    private static final int STORAGE_REQUEST_CODE = 400;
    private static final int IMAGE_PICK_CAMERA_CODE = 1001;
    private static final int IMAGE_PICK_GALLERY_CODE = 1000;
    private static final int REQUEST_CODE_SPEECH_INPUT = 2000;
    String cameraPermission[];
    String storagePermission[];
    Uri image_uri;
    public static DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//            if(OpenCVLoader.initDebug()){
//                //Log.d("", "OpenCV 3.4.3 loaded");
//                Toast.makeText(MainActivity.this, "OpenCV 3.4.7 loaded", Toast.LENGTH_LONG).show();
//            } else {
//                Toast.makeText(MainActivity.this, "OpenCV 3.4.7 not loaded", Toast.LENGTH_LONG).show();
//            }


        // ẩn thanh ActionBar đi
        getSupportActionBar().hide();

        // camera permission
        cameraPermission = new String[]{Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE};
        // storage permission
        storagePermission = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};

        addControls();
        addEvents();
    }

    private void addControls() {
        // ánh xạ các component
        // mainGrid = (GridLayout) findViewById(R.id.mainGrid);
        cardViewCamera = (CardView) findViewById(R.id.cardViewCamera);
        cardViewGallery = (CardView) findViewById(R.id.cardViewGallery);
        cardViewVoice = (CardView) findViewById(R.id.cardViewVoice);
        cardViewHistory = (CardView) findViewById(R.id.cardViewHistory);
        cardViewIntro = (CardView) findViewById(R.id.cardViewIntro);
        cardViewAbout = (CardView) findViewById(R.id.cardViewAbout);

    }

    private void addEvents() {
        // CardView cho Camera
        cardViewCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // đổi màu cho CardView khi click vào
                // cardViewCamera.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                Toast.makeText(MainActivity.this, "Camera", Toast.LENGTH_LONG).show();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (!checkCameraPermission()) {
                        // camera permission not allowed, request it
                        requestCameraPermission();
                    } else {
                        // permission allowed
                        pickCamera();
                    }
                } else {
                    // system os < marshmallow
                    pickCamera();
                }
            }
        });

        // CardView cho Gallery
        cardViewGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // đổi màu cho CardView khi click vào
                // cardViewGallery.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                // Toast.makeText(MainActivity.this, "State : True", Toast.LENGTH_SHORT).show();

                // cardViewGallery.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                // Toast.makeText(MainActivity.this, "State : False", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "Bộ sưu tập", Toast.LENGTH_LONG).show();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    // gallery options clicked
                    if (!checkStoragePermission()) {
                        // Storage permission not allowed, request it
                        requestStoragePermission();
                    } else {
                        // permission allowed
                        pickGallery();
                    }
                } else {
                    // system os < marshmallow
                    pickGallery();
                }
            }
        });

        // CardView cho Giọng nói
        cardViewVoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(MainActivity.this, "Giọng nói", Toast.LENGTH_LONG).show();
                speak();
            }
        });

        // CardView cho Lịch sử
        cardViewHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Lịch sử", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });

        // CardView cho Hướng dẫn
        cardViewIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hướng dẫn", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, GuideActivity.class);
                startActivity(intent);
            }
        });

        // CardView cho About NLU
        cardViewAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Thông tin chi tiết app", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }

    // Phương thức cho phép nói
    private void speak() {
        // Intent to show speech to text dialog
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hi, speak something");

        // Start Intent
        try {
            // Hiển thị dialog cho phép nói
            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);

        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    // Mở Camera
    private void pickCamera() {
        // Intent để lấy hình ảnh từ camera, nó cũng sẽ được lưu trong bộ sưu tập để lấy hình ảnh chất lượng cao
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "New Picture");
        values.put(MediaStore.Images.Media.DESCRIPTION, "From the Camera");
        image_uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        // Camera Intent
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri);
        startActivityForResult(cameraIntent, IMAGE_PICK_CAMERA_CODE);

    }

    // Mở bộ sưu tập
    private void pickGallery() {
        // intent to pick image from gallery
        Intent intent = new Intent(Intent.ACTION_PICK);
        // set intent type to image
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_GALLERY_CODE);
    }

    private void requestStoragePermission() {
        ActivityCompat.requestPermissions(this, storagePermission, STORAGE_REQUEST_CODE);
    }

    private void requestCameraPermission() {
        ActivityCompat.requestPermissions(this, cameraPermission, CAMERA_REQUEST_CODE);

    }

    // Check camera permission
    private boolean checkCameraPermission() {
        boolean result1 = ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA) == (PackageManager.PERMISSION_GRANTED);
        boolean result2 = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == (PackageManager.PERMISSION_GRANTED);
        return result1 && result2;
    }

    // check storage permission
    private boolean checkStoragePermission() {
        boolean result = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == (PackageManager.PERMISSION_GRANTED);
        return result;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // called when image was captured from camera
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE_SPEECH_INPUT:
                if (resultCode == RESULT_OK && null != data) {
                    // lấy ra mảng text từ giọng nói người dùng
                    ArrayList<String> listVoice = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    // Sau đó chuyển kết quả sang ResultActivity
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putStringArrayListExtra("listVoice", listVoice);
                    startActivity(intent);
                }
        }
        if (resultCode == RESULT_OK) {
            if (requestCode == IMAGE_PICK_GALLERY_CODE) {
                // got image from gallery now crop it
                CropImage.activity(data.getData())
                        .setGuidelines(CropImageView.Guidelines.ON) // enable image guidline
                        .setActivityTitle("Crop")
                        .setGuidelinesThickness(0)
                        .setCropMenuCropButtonTitle("Giải")
                        .setInitialCropWindowRectangle(new Rect(300, 1800, 3100, 2600))
                        .setAutoZoomEnabled(true)
                        .start(this);

            }
            if (requestCode == IMAGE_PICK_CAMERA_CODE) {
                // set the image captured to our ImageView
                // got image from gallery now crop it
                CropImage.activity(image_uri)
                        .setGuidelines(CropImageView.Guidelines.ON) // enable image guidline
                        .setActivityTitle("Crop")
                        .setGuidelinesThickness(0)
                        .setCropMenuCropButtonTitle("Giải")
                        .setInitialCropWindowRectangle(new Rect(300, 1800, 3100, 2600))
                        .setAutoZoomEnabled(true)
                        .start(this);
            }

            // lấy hình ảnh đã crop
            if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
                CropImage.ActivityResult result = CropImage.getActivityResult(data);
                if (resultCode == RESULT_OK) {
                    Uri resultUri = result.getUri(); // get image uri
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("imageCropped", String.valueOf(resultUri));
                    startActivity(intent);
                }
            }
        }
    }
}

