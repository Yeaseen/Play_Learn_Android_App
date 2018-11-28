package com.example.asus.autism_project;

import android.content.DialogInterface;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Math extends AppCompatActivity implements View.OnClickListener {


    int[] backgroundArray={R.drawable.rsz_math,R.drawable.rsz_mathlvl2,R.drawable.rsz_math,R.drawable.rsz_mathlvl2,R.drawable.rsz_math};
    int[] button1Array={R.drawable.opt3,R.drawable.opt7,R.drawable.opt1,R.drawable.opt7,R.drawable.opt1};
    int[] button2Array={R.drawable.opt1,R.drawable.opt9,R.drawable.opt7,R.drawable.opt3,R.drawable.opt2};
    int[] button3Array={R.drawable.opt2,R.drawable.opt5,R.drawable.opt5,R.drawable.opt9,R.drawable.opt5};
    int[] button4Array={R.drawable.opt5,R.drawable.opt6,R.drawable.opt9,R.drawable.opt5,R.drawable.opt9};
    String[] txtArray={" 1 + 2 ="," 5 - 0 ="," 3 * 3 ="," 9 / 3 ="," 7 + 2 ="};


    int[] toneArray={R.raw.three,R.raw.five,R.raw.nine,R.raw.three,R.raw.nine};
    ImageButton[] imgButton=new ImageButton[4];
    public ImageView background;
    public TextView txt,level_text;
    public int lvl;
    public int id;
    public int ans;
    public Button go_level;
    public int total_level= button1Array.length;

    public MediaPlayer media_song;
    DataBaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);


        mydb= new DataBaseHelper(this);
        go_level=findViewById(R.id.goTo);

        updateLevelAns();
        updateFeatures(lvl);


        }

    public void updateFeatures(int lvl){
        txt=findViewById(R.id.textView2);
        txt.setText(txtArray[lvl]);
        level_text=findViewById(R.id.level);
        level_text.setText("Current Level: "+(lvl+1));
        background = (ImageView)findViewById(R.id.mathImageView);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        background.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
        background.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
        background.setAdjustViewBounds(false);
        background.setScaleType(ImageView.ScaleType.FIT_XY);
        background.setImageResource(backgroundArray[lvl]);
        imgButton[0] =findViewById(R.id.buttoN_1);
        imgButton[1] =findViewById(R.id.butoN_2);
        imgButton[2] =findViewById(R.id.buttoN_3);
        imgButton[3] =findViewById(R.id.buttoN_4);

        imgButton[0].setBackgroundResource(button1Array[lvl]);
        imgButton[0].setOnClickListener(this);
        imgButton[1].setImageResource(button2Array[lvl]);
        imgButton[1].setOnClickListener(this);
        imgButton[2].setImageResource(button3Array[lvl]);
        imgButton[2].setOnClickListener(this);
        imgButton[3].setImageResource(button4Array[lvl]);
        imgButton[3].setOnClickListener(this);
    }

    public void updateLevel(){
        String level= String.valueOf((lvl+2));
        Cursor r= mydb.getAns(3,(lvl+2)); ///*///
        String ant = null;
        while (r.moveToNext()) {
            ant=r.getString(0);
        }

        String idS = String.valueOf(id);
        mydb.updateData(idS,level,ant);
    }
    public void updateLevelAns(){
        Cursor res= mydb.getData(30);   ////*///
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



    @Override
    public void onClick(View view) {

        //there should be a for loop then update database for correct ans from dataabse and redirect the intent

        if(view == imgButton[0] && ans==0) {
            media_song = MediaPlayer.create(this,toneArray[lvl]);
            media_song.start();
            Toast.makeText(Math.this,"Congratulations !!",Toast.LENGTH_SHORT).show();
            if(lvl<total_level-1){
                updateLevel();
                updateLevelAns();
                updateFeatures(lvl);

            }

        }
        else if(view == imgButton[0] && ans!=0) {
            media_song = MediaPlayer.create(this,R.raw.wrong);
            media_song.start();
            Toast.makeText(Math.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        }
        else if(view == imgButton[1] && ans==1) {
            media_song = MediaPlayer.create(this,toneArray[lvl]);
            media_song.start();
            Toast.makeText(Math.this,"Congratulations !!",Toast.LENGTH_SHORT).show();

            if(lvl<total_level-1){
                updateLevel();
                updateLevelAns();
                updateFeatures(lvl);

            }

        }
        else if(view == imgButton[1] && ans!=1) {
            media_song = MediaPlayer.create(this,R.raw.wrong);
            media_song.start();
            Toast.makeText(Math.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        }
        else if(view == imgButton[2] && ans==2) {
            media_song = MediaPlayer.create(this,toneArray[lvl]);
            media_song.start();
            Toast.makeText(Math.this,"Congratulations !!",Toast.LENGTH_SHORT).show();
            if(lvl<total_level-1){
                updateLevel();
                updateLevelAns();
                updateFeatures(lvl);

            }
        }
        else if(view == imgButton[2] && ans!=2) {
            media_song = MediaPlayer.create(this,R.raw.wrong);
            media_song.start();
            Toast.makeText(Math.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        }
        else if(view == imgButton[3] && ans==3) {
            media_song = MediaPlayer.create(this,toneArray[lvl]);
            media_song.start();
            Toast.makeText(Math.this,"Congratulations !!",Toast.LENGTH_SHORT).show();
            if(lvl<total_level-1){
                updateLevel();
                updateLevelAns();
                updateFeatures(lvl);

            }
        }
        else if(view == imgButton[3] && ans!=3) {
            media_song = MediaPlayer.create(this,R.raw.wrong);
            media_song.start();
            Toast.makeText(Math.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        }

        else if(view == go_level){
            String[] arr;
            arr =new String[lvl+1];
            for (int i = 0; i < lvl+1 ; i++) arr[i] = "Level " + String.valueOf(i+1);

            CharSequence[] items=arr;

            new AlertDialog.Builder(Math.this)
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
                            Cursor r= mydb.getAns(3,(lvl+1));
                            String ant = null;
                            while (r.moveToNext()) {
                                ant=r.getString(0);
                            }

                            String idS = String.valueOf(30);
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
