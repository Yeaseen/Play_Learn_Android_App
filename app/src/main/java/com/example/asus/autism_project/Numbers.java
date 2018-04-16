package com.example.asus.autism_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Numbers extends AppCompatActivity implements View.OnClickListener {

    public ImageView carView;

    ImageButton opt3;
    ImageButton opt5;
    ImageButton opt6;
    ImageButton opt8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        opt3 = findViewById(R.id.opt3Bttn);
        opt3.setOnClickListener(this);

        opt5 = findViewById(R.id.opt5Bttn);
        opt5.setOnClickListener(this);


        opt6 = findViewById(R.id.opt6Bttn);
        opt6.setOnClickListener(this);

        opt8 = findViewById(R.id.opt8Bttn);
        opt8.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {

        if(view == opt3) Toast.makeText(Numbers.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        else if(view == opt5) Toast.makeText(Numbers.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        else if(view == opt8) Toast.makeText(Numbers.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        else if(view == opt6)  Toast.makeText(Numbers.this,"Congatulations!!",Toast.LENGTH_SHORT).show();

    }
}
