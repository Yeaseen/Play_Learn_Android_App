package com.example.asus.autism_project;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Play.db";
    public static final String TABLE_NAME = "play_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "LEVEL";
    public static final String COL_3 = "ANSWER";
    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,LEVEL INTEGER,ANSWER INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }



}