package com.example.asus.autism_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Letters extends AppCompatActivity {
    public static ImageButton banana_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters);
    }

    public void onClickbananaBtnListener(){
        banana_btn = (ImageButton)findViewById(R.id.bananaBttn);
        banana_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        
                    }
                }
        );
    }

}
