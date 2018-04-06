package com.example.asus.autism_project;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Letters extends AppCompatActivity {
    public static ImageButton banana_btn;
    public static ImageButton cat_btn;
    public static ImageButton elephant_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters);
        onClickbananaBtnListener();
        onClickcatBtnListener();
        onClickelephantBtnListener();
    }

    public void onClickbananaBtnListener(){
        banana_btn = (ImageButton)findViewById(R.id.bananaBttn);
        banana_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(Letters.this,"Ops, its not ok",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void onClickcatBtnListener(){
        cat_btn = (ImageButton)findViewById(R.id.catBttn);
        cat_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(Letters.this,"Ops, its not ok",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void onClickelephantBtnListener(){
        elephant_btn =  (ImageButton)findViewById(R.id.elephantBttn);
        elephant_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(Letters.this,"Ops, its not ok",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }



}
