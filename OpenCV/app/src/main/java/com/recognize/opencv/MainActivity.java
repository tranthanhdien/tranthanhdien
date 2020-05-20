package com.recognize.opencv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Camera;
import android.media.MediaActionSound;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.Rect;

import java.io.FileOutputStream;
import java.util.Date;

import ir.sohreco.circularpulsingbutton.CircularPulsingButton;

// CvCameraViewListener2 to allow OpenCV to communicate with android camera functionalities.
public class MainActivity extends AppCompatActivity implements CameraBridgeViewBase.CvCameraViewListener2, Camera.PictureCallback {
    private static final String TAG = "OCVSample::Activity"; // used for logging success or failure messages
    CameraBridgeViewBase cameraBridgeViewBase; // Loads camera view of OpenCV, bridge between camera and OpenCV library.
    Mat mat1, mat2, mat3; // These variables are used (at the moment) to fix camera orientation from 270degree to 0degree

    BaseLoaderCallback baseLoaderCallback; //
    Button btnTakePicture, btnIntro, btnHistory;
    String mPictureFileName;
    MyCameraView myCameraView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // keep the screen always turn on
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        myCameraView = (MyCameraView) findViewById(R.id.myCameraView);
        btnTakePicture = (Button) findViewById(R.id.btnTakePicture);
        btnIntro = (Button) findViewById(R.id.btnIntro);
        btnHistory = (Button) findViewById(R.id.btnHistory);
        myCameraView.setVisibility(SurfaceView.VISIBLE);
        myCameraView.setCvCameraViewListener(this);
        myCameraView.enableView();
        myCameraView.enableFpsMeter();
        myCameraView.setMaxFrameSize(720, 1280);
        //myCameraView.getResolution();
        // set focus mode
        //myCameraView.setFocusMode(MainActivity.this, 0);


        // take picture
        btnTakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String outPicture = SyncStateContract.Constants.SCAN_IMAGE_LOCATION + File.separator + Utilities.generateFilename();
//                FolderUtil.createDefaultFolder(SyncStateContract.Constants.SCAN_IMAGE_LOCATION);
//
//                cameraBridgeViewBase.takePicture(outPicture);
                Toast.makeText(MainActivity.this, "Picture has been taken ", Toast.LENGTH_LONG).show();
//                Log.d(TAG, "Path " + outPicture);
                MediaActionSound sound = new MediaActionSound();
                sound.play(MediaActionSound.SHUTTER_CLICK);
                Log.i(TAG, "On button Click");
                Date sdf = new Date();
                String currentDateTime = sdf.toString();
                String fileName = Environment.getExternalStorageDirectory().getPath() +
                        "/sample_picture_" + currentDateTime + ".jpeg";
                Toast.makeText(MainActivity.this, fileName, Toast.LENGTH_LONG).show();
                myCameraView.takePicture(fileName);

            }
        });

        // history
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // takePicture(mPictureFileName);
                Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });

        // introduction
        btnIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // communicate with android phone to make OpenCV work
        baseLoaderCallback = new BaseLoaderCallback(this) {
            @Override
            public void onManagerConnected(int status) {
                switch (status) {
                    case BaseLoaderCallback.SUCCESS:
                        Log.i(TAG, "OpenCV loaded successfully");
                        myCameraView.enableView();
                        break;
                    default:
                        super.onManagerConnected(status);
                        break;
                }
            }
        };
    }

    // Receive Image Data when the camera preview starts on screen
    @Override
    public void onCameraViewStarted(int width, int height) {
        // Mat(int rows, int cols, type);
        // rows: height of picture, cols: width of picture,
        // CV_8UC4: Có nghĩa là một điểm ảnh sẽ có 3 channel, mỗi channel dùng 8 bit không dấu để biểu diễn.
        mat1 = new Mat(width, height, CvType.CV_8UC4);
        mat2 = new Mat(width, height, CvType.CV_8UC4);
        mat3 = new Mat(width, height, CvType.CV_8UC4);
    }

    // Destroy image data when you stop camera preview on phone screen
    @Override
    public void onCameraViewStopped() {
        mat1.release();
    }

    // Now, this one is interesting! OpenCV orients the camera to left by 90 degrees. So if the app is in portrait more, camera will be in -90 or 270 degrees orientation
    @Override
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
        mat1 = inputFrame.rgba();
        // rotate the frame to 90 degree
        Core.transpose(mat1, mat2);
        Imgproc.resize(mat2, mat3, mat1.size(), 0, 0, 0);
        Core.flip(mat3, mat1, 1);
        return mat1;

    }

    // three functions handle the events when the app is Paused, Resumed and Closed/Destroyed
    @Override
    protected void onPause() {
        super.onPause();
        if (myCameraView != null) {
            myCameraView.disableView();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!OpenCVLoader.initDebug()) {
            Toast.makeText(getApplicationContext(), "There is a problem in opencv", Toast.LENGTH_LONG).show();
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_4_0, this, baseLoaderCallback);
        } else {
            Log.d(TAG, "OpenCV library found inside package. Using it!");
            baseLoaderCallback.onManagerConnected(BaseLoaderCallback.SUCCESS);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (myCameraView != null) {
            myCameraView.disableView();
        }
    }

    public void takePicture(final String fileName) {
        Log.i(TAG, "Taking picture");
        this.mPictureFileName = fileName;
        //mCamera.setPreviewCallback(MainActivity.this);
    }

    @Override
    public void onPictureTaken(byte[] data, Camera camera) {
        Log.i(TAG, "Saving a bitmap to file");
        //The camera preview was automatically stopped. Start it again.
        //mCamera.startPreview();
        //mCamera.setPreviewCallback(this);
        // Write the image in a file (in jpeg format)
        try {
            FileOutputStream fos = new FileOutputStream(mPictureFileName);

            fos.write(data);
            fos.close();

        } catch (java.io.IOException e) {
            Log.e("PictureDemo", "Exception in photoCallback", e);
        }
    }
}