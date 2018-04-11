package com.example.asus.autism_project;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Letters extends AppCompatActivity implements View.OnClickListener {
    public  ImageButton banana_btn;
    public  ImageButton cat_btn;
    public  ImageButton elephant_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters);
        banana_btn = (ImageButton)findViewById(R.id.bananaBttn);
        cat_btn = (ImageButton)findViewById(R.id.catBttn);
        elephant_btn =  (ImageButton)findViewById(R.id.elephantBttn);
        banana_btn.setOnClickListener(this);
        cat_btn.setOnClickListener(this);
        elephant_btn.setOnClickListener(this);

    }



    @Override
    public void onClick(View view) {

        if(view == banana_btn)  Toast.makeText(Letters.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        else if(view == cat_btn) Toast.makeText(Letters.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        else if(view == elephant_btn) Toast.makeText(Letters.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();

    }
}
