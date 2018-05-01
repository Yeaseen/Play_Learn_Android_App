package com.example.asus.autism_project;

import android.database.Cursor;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class PicturePuzzle extends AppCompatActivity implements View.OnClickListener {

    public ImageView pic_puzzl;
    int[] backgroundArray={R.drawable.picpuzzle,R.drawable.picpuzzle2};
    int[] quesView ={R.drawable.rsz_2ppuz_horse_shadow,R.drawable.rsz_pques2};
    int[] button1Array={R.drawable.rsz_puzzlehorse,R.drawable.rsz_pz2opt};
    int[] button2Array={R.drawable.rsz_puzzleelphant,R.drawable.rsz_opt1pz2};


    ImageButton[] imgButton=new ImageButton[2];
    public ImageView background;
    public ImageView ques;

    public int lvl;
    public int id;
    public int ans;

    DataBaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_puzzle);

        mydb= new DataBaseHelper(this);

        updateLevelAns();
        updateFeatures(lvl);
    }

    public void updateFeatures(int lvl){

        ques = findViewById(R.id.ques);
        ques.setImageResource(quesView[lvl]);
        background = (ImageView)findViewById(R.id.picPuzzleView);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        background.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
        background.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
        background.setAdjustViewBounds(false);
        background.setScaleType(ImageView.ScaleType.FIT_XY);
        background.setImageResource(backgroundArray[lvl]);
        imgButton[0] =findViewById(R.id.opt1);
        imgButton[1] =findViewById(R.id.opt2);


        imgButton[0].setBackgroundResource(button1Array[lvl]);
        imgButton[0].setOnClickListener(this);
        imgButton[1].setImageResource(button2Array[lvl]);
        imgButton[1].setOnClickListener(this);

    }

    public void updateLevel(){
        String level= String.valueOf((lvl+2));
        Cursor r= mydb.getAns(4,(lvl+2)); ///*///
        String ant = null;
        while (r.moveToNext()) {
            ant=r.getString(0);
        }

        String idS = String.valueOf(id);
        mydb.updateData(idS,level,ant);
    }
    public void updateLevelAns(){
        Cursor res= mydb.getData(40);   ////*///
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

        if(view == imgButton[0] && ans==0) {
            Toast.makeText(PicturePuzzle.this,"Congratulations !!",Toast.LENGTH_SHORT).show();
            updateLevel();
            updateLevelAns();
            updateFeatures(lvl);

        }
        else if(view == imgButton[0] && ans!=0) Toast.makeText(PicturePuzzle.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        else if(view == imgButton[1] && ans==1) {
            Toast.makeText(PicturePuzzle.this,"Congratulations !!",Toast.LENGTH_SHORT).show();

            updateLevel();
            updateLevelAns();
            updateFeatures(lvl);

        }
        else if(view == imgButton[1] && ans!=1) Toast.makeText(PicturePuzzle.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();    }
}
