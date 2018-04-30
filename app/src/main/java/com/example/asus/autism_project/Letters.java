package com.example.asus.autism_project;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.media.Image;
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

import static com.example.asus.autism_project.R.drawable.rsz_math;

public class Letters extends AppCompatActivity implements View.OnClickListener {

    int[] backgroundArray={R.drawable.letter1back,R.drawable.rsz_letter_2back};
    int[] button1Array={R.drawable.apple,R.drawable.rsz_horse};
    int[] button2Array={R.drawable.banana,R.drawable.rsz_fish};
    int[] button3Array={R.drawable.elephant,R.drawable.rsz_ball};
    int[] button4Array={R.drawable.cat,R.drawable.rsz_doll};
    String[] txtArray={"A stands for....","B stands for......"};

    ImageButton[] imgButton=new ImageButton[4];
    public ImageView background;
    public TextView txt;
    public int lvl;

    public int ans;

    DataBaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters);

        mydb= new DataBaseHelper(this);

        Cursor res= mydb.getData(1);
        if(res.getCount()==0) Log.v("chole na","ki r kora");
        else Log.v("chole na","kene cholor");
        //Log.v("chole",res.getString(0));
        //lvl=Integer.parseInt(res.getString(0))-1;
        while (res.moveToNext()) {
            String i=res.getString(0);
            String m= res.getString(1);
            Log.v("asi",m);
            lvl=Integer.parseInt(m)-1;
            String k=res.getString(2);
            ans=Integer.parseInt(k);
        }
       // String j=res.getString(0);
        Log.v("getString(0)","kjk");
        //lvl=0;

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
        imgButton[3] =findViewById(R.id.elephantBttn);



        imgButton[0].setBackgroundResource(button1Array[lvl]);
        imgButton[0].setOnClickListener(this);
        imgButton[1].setImageResource(button2Array[lvl]);
        imgButton[1].setOnClickListener(this);
        imgButton[2].setImageResource(button3Array[lvl]);
        imgButton[2].setOnClickListener(this);
        imgButton[3].setImageResource(button4Array[lvl]);
        imgButton[3].setOnClickListener(this);


    }



    @Override
    public void onClick(View view) {

        //there should be a for loop then update database for correct ans from dataabse and redirect the intent

        if(view == imgButton[0]) Toast.makeText(Letters.this,"Congratulations !!",Toast.LENGTH_SHORT).show();
        else if(view == imgButton[1]) Toast.makeText(Letters.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        else if(view == imgButton[2]) Toast.makeText(Letters.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        else if(view == imgButton[3] ) {
            Toast.makeText(Letters.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
        }

    }
}
