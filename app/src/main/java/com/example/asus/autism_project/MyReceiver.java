package com.example.asus.autism_project;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
   // public MediaPlayer media_song;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
        String state = intent.getExtras().getString("extra");
        Log.e("Alarm_Receiver","we r in receiver and get from Breakfast: "+state);

        //media_song= MediaPlayer.create(context,R.raw.dove);
        //media_song.start();
        Log.e("at recevr","not ok");

       Intent service_intent= new Intent(context,RingtonePlayingService.class);

       context.startService(service_intent);
    }
}
