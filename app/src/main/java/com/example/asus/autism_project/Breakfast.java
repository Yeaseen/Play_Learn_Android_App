package com.example.asus.autism_project;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class Breakfast extends AppCompatActivity implements View.OnClickListener {

    public static AlarmManager alarmManager;
    public  TimePicker timePicker;
    public  TextView updateText;
    public  Button alarmOn;
    public  Button alarmoff;
    public static Intent myIntent;
    public static Calendar calendar;
    public static PendingIntent pendingIntent;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);

        this.context = this;

        alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);

        timePicker = (TimePicker)findViewById(R.id.timePicker);
        updateText = (TextView)findViewById(R.id.updateText);


        myIntent= new Intent(this.context,MyReceiver.class);
        calendar= Calendar.getInstance();

        alarmOn = (Button)findViewById(R.id.turnOn);
        alarmoff = (Button)findViewById(R.id.turnOff);

        alarmOn.setOnClickListener(this);
        alarmoff.setOnClickListener(this);


    }


    public void set_alarm_text(String output){

        updateText.setText(output);

    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onClick(View view) {
        if(view == alarmOn){
            calendar.add(Calendar.SECOND, 3);
            calendar.set(Calendar.HOUR_OF_DAY,timePicker.getCurrentHour());
            calendar.set(calendar.MINUTE,timePicker.getCurrentMinute());

            int hour = timePicker.getCurrentHour();
            int min = timePicker.getCurrentMinute();
            String h=String.valueOf(hour);
            String m=String.valueOf(min);
            set_alarm_text("Alarm set to: "+h+":"+m );
            myIntent.putExtra("extra", "yes");
            pendingIntent= PendingIntent.getBroadcast(context,0,myIntent,pendingIntent.FLAG_UPDATE_CURRENT);
            Log.e("Context","after pending");
            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
            Log.e("Context","after alrmamngr");
        }

        else if (view == alarmoff){
            myIntent.putExtra("extra","nope");
            sendBroadcast(myIntent);
            alarmManager.cancel(pendingIntent);
            set_alarm_text("Alarm canceled");
        }
    }
}
