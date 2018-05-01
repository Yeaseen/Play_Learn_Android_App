package com.example.asus.autism_project;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlaySelect extends AppCompatActivity implements View.OnClickListener {
    private  Button letters_btn;
    private Button math_btn;
    private Button nmbr_btn;
    private Button pic_btn;
    public static DataBaseHelper mydb;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mydb=new DataBaseHelper(this);
        Cursor res = mydb.getAllData();

        if(res.getCount()==0){

            mydb.insertData("1","1","1");
            mydb.insertData("1","2","3");
            mydb.insertData("1","3","4");
            mydb.insertData("1","4","3");


            mydb.insertData("2","1","2");
            mydb.insertData("2","2","1");
            mydb.insertData("2","3","3");
            mydb.insertData("2","4","1");

            mydb.insertData("3","1","1");
            mydb.insertData("3","2","3");
            mydb.insertData("3","3","4");
            mydb.insertData("3","4","2");

            mydb.insertData("4","1","1");
            mydb.insertData("4","2","2");
            mydb.insertData("4","3","1");
            mydb.insertData("4","4","1");

            mydb.insertData("10","1","1");
            mydb.insertData("20","1","2");
            mydb.insertData("30","1","1");
            mydb.insertData("40","1","1");

        }


        setContentView(R.layout.activity_play_select);
        letters_btn = (Button)findViewById(R.id.button3);
        letters_btn.setOnClickListener(this);

        math_btn = (Button)findViewById(R.id.mathBttn);
        math_btn.setOnClickListener(this);

        nmbr_btn = (Button)findViewById(R.id.numBttn);
        nmbr_btn.setOnClickListener(this);

        pic_btn = (Button)findViewById(R.id.picBttn);
        pic_btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(view == letters_btn){
            Intent intent_letters=new Intent(PlaySelect.this,Letters.class);
            startActivity(intent_letters);
        }
        else if(view == math_btn){
            Intent intent_math= new Intent(PlaySelect.this,Math.class);
            startActivity(intent_math);
        }
        else if (view == nmbr_btn){
            Intent intent_nmbr = new Intent(PlaySelect.this,Numbers.class);
            startActivity(intent_nmbr);
        }
        else if (view == pic_btn){
            Intent intent_pic = new Intent(PlaySelect.this,PicturePuzzle.class);
            startActivity(intent_pic);
        }
    }
}
