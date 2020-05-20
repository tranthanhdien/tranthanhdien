package com.recognize.opencv;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import org.opencv.android.JavaCameraView;


import java.io.FileOutputStream;
import java.util.List;

public class MyCameraView extends JavaCameraView implements Camera.PictureCallback {
    private static final String TAG = MyCameraView.class.getSimpleName();
    private String mPictureFileName;
    public static int minWidthQuality = 400;
    private Context context;

//    private final Paint paint;
//    private final int maskColor;
//    private final int frameColor;
//    private final int cornerColor;

    public MyCameraView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
//        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        Resources resources = getResources();
//        maskColor = resources.getColor(R.color.focus_box_mask);
//        frameColor = resources.getColor(R.color.focus_box_frame);
//        cornerColor = resources.getColor(R.color.focus_box_corner);
//        this.setOnTouchListener(getTouchListener());
    }

    public List<String> getEffectList() {
        return mCamera.getParameters().getSupportedColorEffects();
    }

    public boolean isEffectSupported() {
        return (mCamera.getParameters().getColorEffect() != null);
    }

    public String getEffect() {
        return mCamera.getParameters().getColorEffect();
    }

    public void setEffect(String effect) {
        Camera.Parameters params = mCamera.getParameters();
        params.setColorEffect(effect);
        mCamera.setParameters(params);
    }

    public List<Camera.Size> getResolutionList() {
        return mCamera.getParameters().getSupportedPreviewSizes();
    }

    public void setResolution(Camera.Size resolution) {
//        disconnectCamera();
//        mMaxHeight = resolution.height;
//        mMaxWidth = resolution.width;
//        connectCamera(getWidth(), getHeight());
        disconnectCamera();
        connectCamera((int) resolution.width, (int) resolution.height);
    }

    public Camera.Size getResolution() {
        Camera.Parameters params = mCamera.getParameters();
        Camera.Size s = params.getPreviewSize();
        return s;
    }

    public void takePicture(final String fileName) {
        Log.i(TAG, "Taking picture");
        this.mPictureFileName = fileName;
        mCamera.setPreviewCallback(null);

        mCamera.takePicture(null, null, this);
    }

    @SuppressLint("WrongThread")
    @Override
    public void onPictureTaken(byte[] data, Camera camera) {
        Log.i(TAG, "Saving a bitmap to file");
        // The camera preview was automatically stopped. Start it again.
        mCamera.startPreview();
        mCamera.setPreviewCallback(this);

        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
        Uri uri = Uri.parse(mPictureFileName);

        Log.d(TAG, "selectedImage: " + uri);
        Bitmap bm = null;
        bm = rotate(bitmap, 90);

        // Write the image in a file (in jpeg format)
        try {
            FileOutputStream fos = new FileOutputStream(mPictureFileName);
            bm.compress(Bitmap.CompressFormat.JPEG, 80, fos);
            fos.close();

        } catch (java.io.IOException e) {
            Log.e("PictureDemo", "Exception in photoCallback", e);
        }
    }

    private static Bitmap rotate(Bitmap bm, int rotation) {
        if (rotation != 0) {
            Matrix matrix = new Matrix();
            matrix.postRotate(rotation);
            Bitmap bmOut = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(), matrix, true);
            return bmOut;
        }
        return bm;
    }

    // focus mode
    public void setFocusMode(Context item, int type) {

        Camera.Parameters params = mCamera.getParameters();
        mCamera.cancelAutoFocus();
        mCamera.autoFocus(new Camera.AutoFocusCallback() {
            @Override
            public void onAutoFocus(boolean b, Camera camera) {
            }
        });

        List<String> FocusModes = params.getSupportedFocusModes();

        switch (type) {
            case 0:
                if (FocusModes.contains(Camera.Parameters.FOCUS_MODE_AUTO))
                    params.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
                else
                    Toast.makeText(item, "Auto Mode is not supported", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                if (FocusModes.contains(Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO))
                    params.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO);
                else
                    Toast.makeText(item, "Continuous Mode is not supported", Toast.LENGTH_SHORT).show();
                break;
            case 2:

                if (FocusModes.contains(Camera.Parameters.FOCUS_MODE_EDOF))
                    params.setFocusMode(Camera.Parameters.FOCUS_MODE_EDOF);
                else
                    Toast.makeText(item, "EDOF Mode is not supported", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                if (FocusModes.contains(Camera.Parameters.FOCUS_MODE_FIXED))
                    params.setFocusMode(Camera.Parameters.FOCUS_MODE_FIXED);
                else
                    Toast.makeText(item, "Fixed Mode is not supported", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                if (FocusModes.contains(Camera.Parameters.FOCUS_MODE_INFINITY))
                    params.setFocusMode(Camera.Parameters.FOCUS_MODE_INFINITY);
                else
                    Toast.makeText(item, "Infinity Mode is not supported", Toast.LENGTH_SHORT).show();
                break;
            case 5:
                if (FocusModes.contains(Camera.Parameters.FOCUS_MODE_MACRO))
                    params.setFocusMode(Camera.Parameters.FOCUS_MODE_MACRO);
                else
                    Toast.makeText(item, "Macro Mode is not supported", Toast.LENGTH_SHORT).show();
                break;
        }

        mCamera.setParameters(params);
    }
}
