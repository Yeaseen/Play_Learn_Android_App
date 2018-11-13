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

       Intent service_intent= new Intent(context,RingtonePlayingService.class);
       service_intent.putExtra("extra", state);
       context.startService(service_intent);
    }
}
