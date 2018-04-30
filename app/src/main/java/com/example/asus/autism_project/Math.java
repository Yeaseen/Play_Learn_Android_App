package com.example.asus.autism_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.security.PublicKey;

public class Math extends AppCompatActivity implements View.OnClickListener {

    ImageButton opt1;
    ImageButton opt2;
    ImageButton opt5;
    ImageButton opt3;


    public ImageView math;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        math =(ImageView)findViewById(R.id.mathImageView);
        math.setImageResource(R.drawable.letter1back);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        math.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
        math.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
        math.setAdjustViewBounds(false);
        math.setScaleType(ImageView.ScaleType.FIT_XY);

        opt1=findViewById(R.id.opt1Bttn);
        opt1.setOnClickListener(this);

        opt2=findViewById(R.id.opt2Bttn);
        opt2.setOnClickListener(this);

        opt5=findViewById(R.id.opt5Bttn);
        opt5.setOnClickListener(this);

        opt3= findViewById(R.id.opt3Bttn);
        opt3.setOnClickListener(this);

        }

    @Override
    public void onClick(View view) {

        if(view == opt1) Toast.makeText(Math.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        else if(view == opt2) Toast.makeText(Math.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        else if (view == opt5) Toast.makeText(Math.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        else if( view == opt3) Toast.makeText(Math.this,"Congatulations!!",Toast.LENGTH_SHORT).show();

    }
}
