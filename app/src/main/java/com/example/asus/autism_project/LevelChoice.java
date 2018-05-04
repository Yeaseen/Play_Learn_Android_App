package com.example.asus.autism_project;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import static com.example.asus.autism_project.PlaySelect.mydb;


public class LevelChoice extends DialogFragment {

    public static String[] arr;

     public static CharSequence[] items;
    private static int id;

    public int selected;


    AlertDialog.Builder builder;

//    public LevelChoice(int x){
//
//        arr =new String[x];
//        for (int i = 0; i < x ; i++) {
//            arr[i]= "Level "+i;
//        }
//        items =arr;
//    }

    public static LevelChoice newInstance(String[] data, int i) {
        LevelChoice frag = new LevelChoice();
//        Bundle args = new Bundle();
//        args.putStringArray("arr",data);
        arr=data;
        id=i;
        return frag;
    }
    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState){

        //String[] arr =getArguments().getStringArray("arr");

        items=arr;

        builder = new AlertDialog.Builder(getActivity());

            builder.setTitle("Choose level").setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                selected= i;
                Log.v("fragment", String.valueOf(i));

            }
        }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Cursor r= mydb.getAns(id,(selected+1));
                String ant = null;
                while (r.moveToNext()) {
                    ant=r.getString(0);
                }

                String idS = String.valueOf(10);
                mydb.updateData(idS,String.valueOf(selected+1),ant);
                Log.v("levelchoice","chole nai ");


//                ll.updateLevelAns();
//                ll.updateFeatures(selected);

            }
        });
        return builder.create();

    }



}
