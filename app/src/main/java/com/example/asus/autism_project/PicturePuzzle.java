package com.example.asus.autism_project;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

public class PicturePuzzle extends AppCompatActivity {

    public ImageView pic_puzzl;

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
    }
}
