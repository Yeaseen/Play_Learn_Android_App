package com.example.asus.autism_project;

import android.content.DialogInterface;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Numbers extends AppCompatActivity implements View.OnClickListener {


    int[] backgroundArray={R.drawable.rsz_cars,R.drawable.rsz_birds,R.drawable.pens,R.drawable.rsz_apples};

    int[] button1Array={R.drawable.rsz_copt3,R.drawable.rsz_opt2,R.drawable.rsz_opt1,R.drawable.rsz_copt9};
    int[] button2Array={R.drawable.rsz_copt6,R.drawable.rsz_copt8,R.drawable.rsz_copt8,R.drawable.rsz_copt8};
    int[] button3Array={R.drawable.rsz_copt8,R.drawable.rsz_copt3,R.drawable.rsz_copt9,R.drawable.rsz_copt5};
    int[] button4Array={R.drawable.rsz_copt5,R.drawable.rsz_opt1,R.drawable.rsz_opt2,R.drawable.rsz_opt1};

    int[] toneArray={R.raw.two,R.raw.six,R.raw.nine,R.raw.five};
    ImageButton[] imgButton=new ImageButton[4];
    public ImageView background;
    public int lvl;
    public int id;
    public int ans;
    public TextView txte;
    public Button go_level_;

    public int total_level= button1Array.length;

    public MediaPlayer media_song;


    DataBaseHelper mydb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        mydb= new DataBaseHelper(this);
        go_level_=findViewById(R.id.goTOO);

        updateLevelAns();
        updateFeatures(lvl);
    }

    public void updateFeatures(int lvl){

        txte=findViewById(R.id.levvel);
        txte.setText("Current Level: "+(lvl+1));
        background = (ImageView)findViewById(R.id.carView);

        background.setImageResource(backgroundArray[lvl]);
        imgButton[0] =findViewById(R.id.butt_1);
        imgButton[1] =findViewById(R.id.bttoN_2);
        imgButton[2] =findViewById(R.id.butto_3);
        imgButton[3] =findViewById(R.id.butn_4);

        imgButton[0].setBackgroundResource(button1Array[lvl]);
        imgButton[0].setOnClickListener(this);
        imgButton[1].setBackgroundResource(button2Array[lvl]);
        imgButton[1].setOnClickListener(this);
        imgButton[2].setBackgroundResource(button3Array[lvl]);
        imgButton[2].setOnClickListener(this);
        imgButton[3].setBackgroundResource(button4Array[lvl]);
        imgButton[3].setOnClickListener(this);
    }
    public void updateLevelAns(){
        Cursor res= mydb.getData(20);   ////*///
        if(res.getCount()==0) Log.v("chole na","ki r kora");
        else Log.v("chole na","kene cholor");
        while (res.moveToNext()) {
            String i=res.getString(0);
            Log.v("id",i);
            id=Integer.parseInt(i);
            String m= res.getString(1);
            Log.v("level",m);
            lvl=Integer.parseInt(m)-1;
            String k=res.getString(2);
            Log.v("ans",k);
            ans=Integer.parseInt(k)-1;
        }
        Log.v("getString(0)","kjk");

    }

    public void updateLevel(){
        String level= String.valueOf((lvl+2));
        Cursor r= mydb.getAns(2,(lvl+2)); ///*///
        String ant = null;
        while (r.moveToNext()) {
            ant=r.getString(0);
        }

        String idS = String.valueOf(id);
        mydb.updateData(idS,level,ant);
    }



    @Override
    public void onClick(View view) {

        if(view == imgButton[0] && ans==0) {
            media_song = MediaPlayer.create(this,toneArray[lvl]);
            media_song.start();
            Toast.makeText(Numbers.this,"Congratulations !!",Toast.LENGTH_SHORT).show();
            if(lvl<total_level-1){
                updateLevel();
                updateLevelAns();
                updateFeatures(lvl);

            }

        }
        else if(view == imgButton[0] && ans!=0) {
            media_song = MediaPlayer.create(this,R.raw.wrong);
            media_song.start();
            Toast.makeText(Numbers.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        }
        else if(view == imgButton[1] && ans==1) {
            media_song = MediaPlayer.create(this,toneArray[lvl]);
            media_song.start();
            Toast.makeText(Numbers.this,"Congratulations !!",Toast.LENGTH_SHORT).show();
            if(lvl<total_level-1){
                updateLevel();
                updateLevelAns();
                updateFeatures(lvl);

            }

        }
        else if(view == imgButton[1] && ans!=1) {
            media_song = MediaPlayer.create(this,R.raw.wrong);
            media_song.start();
            Toast.makeText(Numbers.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        }
        else if(view == imgButton[2] && ans==2) {
            media_song = MediaPlayer.create(this,toneArray[lvl]);
            media_song.start();
            Toast.makeText(Numbers.this,"Congratulations !!",Toast.LENGTH_SHORT).show();
            if(lvl<total_level-1){
                updateLevel();
                updateLevelAns();
                updateFeatures(lvl);

            }
        }
        else if(view == imgButton[2] && ans!=2) {
            media_song = MediaPlayer.create(this,R.raw.wrong);
            media_song.start();
            Toast.makeText(Numbers.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        }
        else if(view == imgButton[3] && ans==3) {
            media_song = MediaPlayer.create(this,toneArray[lvl]);
            media_song.start();
            Toast.makeText(Numbers.this,"Congratulations !!",Toast.LENGTH_SHORT).show();
            if(lvl<total_level-1){
                updateLevel();
                updateLevelAns();
                updateFeatures(lvl);

            }
        }
        else if(view == imgButton[3] && ans!=3) {
            media_song = MediaPlayer.create(this,R.raw.wrong);
            media_song.start();
            Toast.makeText(Numbers.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        }

        else if(view == go_level_){
            String[] arr;
            arr =new String[lvl+1];
            for (int i = 0; i < lvl+1 ; i++) arr[i] = "Level " + String.valueOf(i+1);

            CharSequence[] items=arr;


            new AlertDialog.Builder(Numbers.this)
                    // new SweetAlertDialog
                    .setTitle("Choose Level")
                    .setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            lvl=i;
                        }
                    })
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Log.v("ans",String.valueOf(i));
                            Cursor r= mydb.getAns(2,(lvl+1));
                            String ant = null;
                            while (r.moveToNext()) {
                                ant=r.getString(0);
                            }

                            String idS = String.valueOf(20);
                            Log.v("ans",idS);
                            mydb.updateData(idS,String.valueOf(lvl+1),ant);
                            Log.v("levelchoice","chole nai ");
                            updateLevelAns();
                            updateFeatures(lvl);

                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            updateLevelAns();
                            updateFeatures(lvl);
                        }
                    })
                    .show();
        }

    }
}
