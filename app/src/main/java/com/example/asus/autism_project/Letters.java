package com.example.asus.autism_project;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.database.Cursor;
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

    int[] backgroundArray={R.drawable.letter1back,R.drawable.rsz_letter_2back,R.drawable.letter1back,R.drawable.rsz_letter_2back};
    int[] button1Array={R.drawable.apple,R.drawable.rsz_horse,R.drawable.elephant,R.drawable.cat};
    int[] button2Array={R.drawable.banana,R.drawable.rsz_fish,R.drawable.apple,R.drawable.rsz_horse};
    int[] button3Array={R.drawable.elephant,R.drawable.rsz_ball,R.drawable.rsz_fish,R.drawable.rsz_doll};
    int[] button4Array={R.drawable.cat,R.drawable.rsz_doll,R.drawable.cat,R.drawable.banana};
    String[] txtArray={"A stands for....","B stands for......","C stands for.....","D stands for...."};

    Button goLevel;
    ImageButton[] imgButton=new ImageButton[4];
    public ImageView background;
    public TextView txt;
    public int lvl;
    public int id;
    public int ans;

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
            String m= res.getString(1);
            Log.v("asi",m);
            lvl=Integer.parseInt(m)-1;
            String k=res.getString(2);
            ans=Integer.parseInt(k)-1;
        }
        Log.v("getString(0)","kjk");

    }





    @Override
    public void onClick(View view) {

        //there should be a for loop then update database for correct ans from dataabse and redirect the intent

        if(view == imgButton[0] && ans==0) {
            Toast.makeText(Letters.this,"Congratulations !!",Toast.LENGTH_SHORT).show();
            if(lvl<3){
                updateLevel();
                updateLevelAns();
                updateFeatures(lvl);

            }
        }
        else if(view == imgButton[0] && ans!=0) Toast.makeText(Letters.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        else if(view == imgButton[1] && ans==1) {
            Toast.makeText(Letters.this,"Congratulations !!",Toast.LENGTH_SHORT).show();
            if(lvl<3){
                updateLevel();
                updateLevelAns();
                updateFeatures(lvl);

            }
        }
        else if(view == imgButton[1] && ans!=1) Toast.makeText(Letters.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        else if(view == imgButton[2] && ans==2) {
            Toast.makeText(Letters.this,"Congratulations !!",Toast.LENGTH_SHORT).show();
            if(lvl<3){
                updateLevel();
                updateLevelAns();
                updateFeatures(lvl);

            }
        }
        else if(view == imgButton[2] && ans!=2) Toast.makeText(Letters.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        else if(view == imgButton[3] && ans==3) {
            Toast.makeText(Letters.this,"Congratulations !!",Toast.LENGTH_SHORT).show();
            if(lvl<3){
                updateLevel();
                updateLevelAns();
                updateFeatures(lvl);

            }
        }
        else if(view == imgButton[3] && ans!=3) Toast.makeText(Letters.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        else if(view == goLevel){
            String[] arr;
            arr =new String[lvl+1];
            for (int i = 0; i < lvl+1 ; i++) arr[i] = "Level " + i;

            DialogFragment newFragment= LevelChoice.newInstance(arr,1);
            newFragment.show(getFragmentManager(),"dialog");
            //updateLevelAns();
            //updateFeatures(lvl);
            Log.v("context","chole nai ");

        }



    }
}
