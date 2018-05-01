package com.example.asus.autism_project;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Math extends AppCompatActivity implements View.OnClickListener {


    int[] backgroundArray={R.drawable.rsz_math,R.drawable.rsz_mathlvl2};
    int[] button1Array={R.drawable.opt3,R.drawable.opt7};
    int[] button2Array={R.drawable.opt1,R.drawable.opt9};
    int[] button3Array={R.drawable.opt2,R.drawable.opt5};
    int[] button4Array={R.drawable.opt5,R.drawable.opt6};
    String[] txtArray={" 1 + 2 ="," 5 - 0 ="};

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
        setContentView(R.layout.activity_math);


        mydb= new DataBaseHelper(this);

        updateLevelAns();
        updateFeatures(lvl);


        }

    public void updateFeatures(int lvl){
        txt=findViewById(R.id.textView2);
        txt.setText(txtArray[lvl]);
        background = (ImageView)findViewById(R.id.mathImageView);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        background.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
        background.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
        background.setAdjustViewBounds(false);
        background.setScaleType(ImageView.ScaleType.FIT_XY);
        background.setImageResource(backgroundArray[lvl]);
        imgButton[0] =findViewById(R.id.opt1);
        imgButton[1] =findViewById(R.id.opt2);
        imgButton[2] =findViewById(R.id.opt3);
        imgButton[3] =findViewById(R.id.opt4);

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
            Toast.makeText(Math.this,"Congratulations !!",Toast.LENGTH_SHORT).show();
            updateLevel();
            updateLevelAns();
            updateFeatures(lvl);

        }
        else if(view == imgButton[0] && ans!=0) Toast.makeText(Math.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        else if(view == imgButton[1] && ans==1) {
            Toast.makeText(Math.this,"Congratulations !!",Toast.LENGTH_SHORT).show();
            updateLevel();
            updateLevelAns();
            updateFeatures(lvl);
        }
        else if(view == imgButton[1] && ans!=1) Toast.makeText(Math.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        else if(view == imgButton[2] && ans==2) {
            Toast.makeText(Math.this,"Congratulations !!",Toast.LENGTH_SHORT).show();
            updateLevel();
            updateLevelAns();
            updateFeatures(lvl);
        }
        else if(view == imgButton[2] && ans!=2) Toast.makeText(Math.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        else if(view == imgButton[3] && ans==3) {
            Toast.makeText(Math.this,"Congratulations !!",Toast.LENGTH_SHORT).show();
            updateLevel();
            updateLevelAns();
            updateFeatures(lvl);
        }
        else if(view == imgButton[3] && ans!=3) Toast.makeText(Math.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();


    }
}
