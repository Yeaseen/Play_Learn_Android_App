package com.example.asus.autism_project;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class RingtonePlayingService extends Service {
    public MediaPlayer media_song;
    private boolean isRunning;
    private int startId;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
       // throw new UnsupportedOperationException("Not yet implemented");

        //Log.e("RingtoneService","at the ringtoneservice");
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {

        Log.e("RingtoneService","at the ringtoneservice");


        //MediaPlayer player = MediaPlayer.create(this,
              //  Settings.System.DEFAULT_RINGTONE_URI);
        //player.start();


        String state = intent.getExtras().getString("extra");
        assert state != null;

        switch (state) {
            case "nope":
                startId = 0;
                break;
            case "yes":
                startId = 1;
                break;
            default:
                startId = 0;
                break;
        }

        if(!this.isRunning && startId == 1) {
            Log.e("if there was not sound ", " and you want start");


            media_song = MediaPlayer.create(this,R.raw.alarm);
            media_song.start();

            this.isRunning = true;
            this.startId = 0;

        }
        else if (!this.isRunning && startId == 0){
            Log.e("if there was not sound ", " and you want end");

            this.isRunning = false;
            this.startId = 0;

        }
        else if (this.isRunning && startId == 1){
            Log.e("if there is sound ", " and you want start");

            this.isRunning = true;
            this.startId = 0;

        }

        else {
            Log.e("if there is sound ", " and you want end");

            media_song.stop();
            media_song.reset();

            this.isRunning = false;
            this.startId = 0;
        }



        Log.e("after playing","Sound done");


        return START_NOT_STICKY;

    }

    @Override
    public void onDestroy() {
        Log.e("on Destry","yeep");
        super.onDestroy();
        Log.e("on Destry","yeep");
        //Toast.makeText(this,"On Destroy Called",Toast.LENGTH_SHORT).show();
        this.isRunning = false;
    }





}
