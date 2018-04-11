package com.example.asus.autism_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import java.security.PublicKey;

public class Math extends AppCompatActivity {


    public ImageView math;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        math =(ImageView)findViewById(R.id.mathImageView);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        math.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
        math.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
        math.setAdjustViewBounds(false);
        math.setScaleType(ImageView.ScaleType.FIT_XY);
    }
}
