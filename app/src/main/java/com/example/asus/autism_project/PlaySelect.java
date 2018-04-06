package com.example.asus.autism_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlaySelect extends AppCompatActivity {
    private static Button letters_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_select);
        onClickLettersListener();
    }

    public void onClickLettersListener(){
        letters_btn = (Button)findViewById(R.id.button3);

        letters_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent_letters=new Intent(PlaySelect.this,Letters.class);
                        startActivity(intent_letters);
                    }
                }
        );
    }



}
