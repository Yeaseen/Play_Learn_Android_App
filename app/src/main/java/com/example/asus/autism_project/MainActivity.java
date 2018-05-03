package com.example.asus.autism_project;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private  Button play_btn;
    private  Button alarm_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        android.app.ActionBar ab= getActionBar();
//        ab.setLogo(R.drawable.icon);



        play_btn=findViewById(R.id.button);

        alarm_btn = (Button)findViewById(R.id.button2);

        play_btn.setOnClickListener(this);
        alarm_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == play_btn){
            Intent intent_PlaySelect= new Intent(MainActivity.this,PlaySelect.class);
            startActivity(intent_PlaySelect);
        }
        else if(view == alarm_btn){
            Intent intent_AlarmSelect= new Intent(MainActivity.this,AlarmSelect.class);
            startActivity(intent_AlarmSelect);
        }
    }
}
