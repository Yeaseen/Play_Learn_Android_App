package com.example.asus.autism_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static Button play_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClickPlayButtonListener();
    }

    public void onClickPlayButtonListener(){
        play_btn=(Button)findViewById(R.id.button);

        play_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent_PlaySelect= new Intent(MainActivity.this,PlaySelect.class);
                        startActivity(intent_PlaySelect);
                    }
                }
        );
    }
}
