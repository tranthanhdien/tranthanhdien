package com.recognize.finalproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.recognize.finalproject.R;

public class StartActivity extends AppCompatActivity {
    ImageView imageView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getSupportActionBar().hide();

        imageView = (ImageView) findViewById(R.id.imgView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        //txtTitle = (TextView) findViewById(R.id.txtTittle);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }, 1000);

    }
}
