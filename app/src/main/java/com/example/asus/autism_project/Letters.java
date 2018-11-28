package com.example.asus.autism_project;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.support.v4.app.FragmentActivity;
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

public class Letters extends FragmentActivity implements View.OnClickListener {

    int[] backgroundArray={R.drawable.letter1back,R.drawable.rsz_letter_2back,R.drawable.letter1back,R.drawable.rsz_letter_2back,R.drawable.letter1back};
    int[] button1Array={R.drawable.apple,R.drawable.rsz_horse,R.drawable.elephant,R.drawable.cat,R.drawable.elephant};
    int[] button2Array={R.drawable.banana,R.drawable.rsz_fish,R.drawable.apple,R.drawable.rsz_horse,R.drawable.rsz_doll};
    int[] button3Array={R.drawable.elephant,R.drawable.rsz_ball,R.drawable.rsz_fish,R.drawable.rsz_doll,R.drawable.apple};
    int[] button4Array={R.drawable.cat,R.drawable.rsz_doll,R.drawable.cat,R.drawable.banana,R.drawable.cat};
    String[] txtArray={"A stands for....","B stands for......","C stands for.....","D stands for....","E stands for...."};

    int[] toneArray={R.raw.apple,R.raw.ball,R.raw.cat,R.raw.doll,R.raw.elephant};

    Button goLevel;
    ImageButton[] imgButton=new ImageButton[4];
    public ImageView background;
    public TextView txt,levelTxt;
    public int lvl;
    public int id;
    public int ans;

    public int total_level= button1Array.length;

    public MediaPlayer media_song;
    DataBaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters);

        mydb= new DataBaseHelper(this);
        goLevel=findViewById(R.id.goTo);

        updateLevelAns();
        updateFeatures(lvl);
    }
    public void updateFeatures(int lvl){

        txt=findViewById(R.id.textView);
        txt.setText(txtArray[lvl]);
        levelTxt=findViewById(R.id.level);
        levelTxt.setText("Current Level: "+(lvl+1));
        background = (ImageView)findViewById(R.id.letters);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        background.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
        background.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
        background.setAdjustViewBounds(false);
        background.setScaleType(ImageView.ScaleType.FIT_XY);
        background.setImageResource(backgroundArray[lvl]);
        imgButton[0] =findViewById(R.id.appleBttn);
        imgButton[1] =findViewById(R.id.bananaBttn);
        imgButton[2] =findViewById(R.id.catBttn);
        imgButton[3] =findViewById(R.id.opt2);

        imgButton[0].setBackgroundResource(button1Array[lvl]);
        imgButton[0].setOnClickListener(this);
        imgButton[1].setBackgroundResource(button2Array[lvl]);
        imgButton[1].setOnClickListener(this);
        imgButton[2].setBackgroundResource(button3Array[lvl]);
        imgButton[2].setOnClickListener(this);
        imgButton[3].setBackgroundResource(button4Array[lvl]);
        imgButton[3].setOnClickListener(this);
    }

    public void updateLevel(){
        String level= String.valueOf((lvl+2));
        Cursor r= mydb.getAns(1,(lvl+2)); ///*///
        String ant = null;
        while (r.moveToNext()) {
            ant=r.getString(0);
        }

        String idS = String.valueOf(id);
        mydb.updateData(idS,level,ant);
    }

    public void updateLevelAns(){
        Cursor res= mydb.getData(10);   ////*///
        if(res.getCount()==0) Log.v("chole na","ki r kora");
        else Log.v("chole na","kene cholor");
        while (res.moveToNext()) {
            String i=res.getString(0);
            id=Integer.parseInt(i);
            Log.v("id no",String.valueOf(id));
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
            Toast.makeText(Letters.this,"Congratulations !!",Toast.LENGTH_SHORT).show();


            if(lvl<total_level-1){
                updateLevel();
                updateLevelAns();
                updateFeatures(lvl);

            }
        }
        else if(view == imgButton[0] && ans!=0) Toast.makeText(Letters.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        else if(view == imgButton[1] && ans==1) {
            media_song = MediaPlayer.create(this,toneArray[lvl]);
            media_song.start();
            Toast.makeText(Letters.this,"Congratulations !!",Toast.LENGTH_SHORT).show();

            if(lvl<total_level-1){
                updateLevel();
                updateLevelAns();
                updateFeatures(lvl);
            }
        }
        else if(view == imgButton[1] && ans!=1) Toast.makeText(Letters.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        else if(view == imgButton[2] && ans==2) {
            media_song = MediaPlayer.create(this,toneArray[lvl]);
            media_song.start();
            Toast.makeText(Letters.this,"Congratulations !!",Toast.LENGTH_SHORT).show();

            if(lvl<total_level-1){
                updateLevel();
                updateLevelAns();
                updateFeatures(lvl);

            }
        }
        else if(view == imgButton[2] && ans!=2) Toast.makeText(Letters.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        else if(view == imgButton[3] && ans==3) {
            media_song = MediaPlayer.create(this,toneArray[lvl]);
            media_song.start();
            Toast.makeText(Letters.this,"Congratulations !!",Toast.LENGTH_SHORT).show();

            if(lvl<total_level-1){
                updateLevel();
                updateLevelAns();
                updateFeatures(lvl);

            }
        }
        else if(view == imgButton[3] && ans!=3) Toast.makeText(Letters.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        else if(view == goLevel){
            String[] arr;
            arr =new String[lvl+1];
            for (int i = 0; i < lvl+1 ; i++) arr[i] = "Level " + String.valueOf(i+1);

            CharSequence[] items=arr;
            final int[] select = new int[1];
            new AlertDialog.Builder(Letters.this)
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
                            Cursor r= mydb.getAns(1,(lvl+1));
                            String ant = null;
                            while (r.moveToNext()) {
                                ant=r.getString(0);
                            }

                            String idS = String.valueOf(10);
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
