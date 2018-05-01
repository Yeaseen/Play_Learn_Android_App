package com.example.asus.autism_project;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_NAME, null, null);

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

    public void insertData(String LEVEL,String ANSWER) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,LEVEL);
        contentValues.put(COL_3,ANSWER);
        long result = db.insert(TABLE_NAME,null ,contentValues);
    }

    public Cursor getData(int id){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor res = db.rawQuery("select * from "+TABLE_NAME+" WHERE ID = "+id,null);
        return res;
    }

    public void updateData(String id,String LEVEL,String ANSWER) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,LEVEL);
        contentValues.put(COL_3,ANSWER);

        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        //return true;
    }

    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }








}