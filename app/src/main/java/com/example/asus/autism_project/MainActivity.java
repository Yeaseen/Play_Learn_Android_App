package com.example.asus.autism_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private  Button play_btn;
    private  Button alarm_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClickPlayButtonListener();
        onClickAlarmButtonListener();

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
    public void onClickAlarmButtonListener(){
        alarm_btn = (Button)findViewById(R.id.button2);

        alarm_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent_AlarmSelect= new Intent(MainActivity.this,AlarmSelect.class);
                        startActivity(intent_AlarmSelect);
                    }
                }
        );
    }



}
