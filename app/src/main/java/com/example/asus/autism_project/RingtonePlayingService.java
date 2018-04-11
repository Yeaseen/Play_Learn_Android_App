package com.example.asus.autism_project;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class RingtonePlayingService extends Service {
    public MediaPlayer media_song;

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
        media_song= MediaPlayer.create(this,R.raw.dove);
        media_song.start();
        Log.e("after playing","404 not heard");


        return START_NOT_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"On Destroy Called",Toast.LENGTH_SHORT).show();
    }





}
