package com.example.asus.autism_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlarmSelect extends AppCompatActivity {
    public static Button breakfastBttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_select);
        setOnClickBreakfastListener();
    }

    public void setOnClickBreakfastListener(){
        breakfastBttn = (Button)findViewById(R.id.breakfast);

        breakfastBttn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent breakfast = new Intent(AlarmSelect.this,Breakfast.class);
                        startActivity(breakfast);
                    }
                }
        );

    }



}
