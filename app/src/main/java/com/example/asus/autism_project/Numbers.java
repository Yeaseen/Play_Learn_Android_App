package com.example.asus.autism_project;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Numbers extends AppCompatActivity implements View.OnClickListener {


    int[] backgroundArray={R.drawable.rsz_cars,R.drawable.rsz_birds};

    int[] button1Array={R.drawable.rsz_copt3,R.drawable.rsz_opt2};
    int[] button2Array={R.drawable.rsz_copt6,R.drawable.rsz_copt5};
    int[] button3Array={R.drawable.rsz_copt8,R.drawable.rsz_copt3};
    int[] button4Array={R.drawable.rsz_copt5,R.drawable.rsz_opt1};

    ImageButton[] imgButton=new ImageButton[4];
    public ImageView background;
    public int lvl;
    public int id;
    public int ans;



    DataBaseHelper mydb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        mydb= new DataBaseHelper(this);

        updateLevelAns();
        updateFeatures(lvl);
    }

    public void updateFeatures(int lvl){

        background = (ImageView)findViewById(R.id.carView);

        background.setImageResource(backgroundArray[lvl]);
        imgButton[0] =findViewById(R.id.opt1);
        imgButton[1] =findViewById(R.id.opt1);
        imgButton[2] =findViewById(R.id.opt1);
        imgButton[3] =findViewById(R.id.opt1);

        imgButton[0].setBackgroundResource(button1Array[lvl]);
        imgButton[0].setOnClickListener(this);
        imgButton[1].setImageResource(button2Array[lvl]);
        imgButton[1].setOnClickListener(this);
        imgButton[2].setImageResource(button3Array[lvl]);
        imgButton[2].setOnClickListener(this);
        imgButton[3].setImageResource(button4Array[lvl]);
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
            Toast.makeText(Numbers.this,"Congratulations !!",Toast.LENGTH_SHORT).show();
            updateLevel();
            updateLevelAns();
            updateFeatures(lvl);

        }
        else if(view == imgButton[0] && ans!=0) Toast.makeText(Numbers.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        else if(view == imgButton[1] && ans==1) {
            Toast.makeText(Numbers.this,"Congratulations !!",Toast.LENGTH_SHORT).show();
            updateLevel();
            updateLevelAns();
            updateFeatures(lvl);

        }
        else if(view == imgButton[1] && ans!=1) Toast.makeText(Numbers.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        else if(view == imgButton[2] && ans==2) {
            Toast.makeText(Numbers.this,"Congratulations !!",Toast.LENGTH_SHORT).show();
            updateLevel();
            updateLevelAns();
            updateFeatures(lvl);
        }
        else if(view == imgButton[2] && ans!=2) Toast.makeText(Numbers.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        else if(view == imgButton[3] && ans==3) {
            Toast.makeText(Numbers.this,"Congratulations !!",Toast.LENGTH_SHORT).show();
            updateLevel();
            updateLevelAns();
            updateFeatures(lvl);
        }
        else if(view == imgButton[3] && ans!=3) Toast.makeText(Numbers.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();


    }
}
