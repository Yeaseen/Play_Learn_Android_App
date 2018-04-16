package com.example.asus.autism_project;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class PicturePuzzle extends AppCompatActivity implements View.OnClickListener {

    public ImageView pic_puzzl;

    ImageButton horse_btn;
    ImageButton elephant_bttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_puzzle);

        pic_puzzl =(ImageView)findViewById(R.id.picPuzzleView);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        pic_puzzl.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
        pic_puzzl.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
        pic_puzzl.setAdjustViewBounds(false);
        pic_puzzl.setScaleType(ImageView.ScaleType.FIT_XY);

        horse_btn = findViewById(R.id.horseBttn);
        horse_btn.setOnClickListener(this);
        elephant_bttn = findViewById(R.id.elephantBttn);
        elephant_bttn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == horse_btn) Toast.makeText(PicturePuzzle.this,"Congratulations !!",Toast.LENGTH_SHORT).show();
        else if (view == elephant_bttn) Toast.makeText(PicturePuzzle.this,"Ops, its not ok",Toast.LENGTH_SHORT).show();
    }
}
