package com.example.asus.autism_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlaySelect extends AppCompatActivity implements View.OnClickListener {
    private  Button letters_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_select);
        letters_btn = (Button)findViewById(R.id.button3);
        letters_btn.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        if(view == letters_btn){
            Intent intent_letters=new Intent(PlaySelect.this,Letters.class);
            startActivity(intent_letters);
        }
    }
}
