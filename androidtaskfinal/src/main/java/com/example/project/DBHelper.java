package com.example.project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public DBHelper(Context context) {
        super(context, "wordsdb", null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String wordsSQL = "create table tb_words (" +
                "_id integer primary key autoincrement, " +
                "string, " +
                "meaning, "+
                "step )";
        db.execSQL(wordsSQL);

        String dateSQL = "create table tb_today (" +
                "_id integer primary key autoincrement, " +
                "string, " +
                "meaning, " +
                "day)";
        db.execSQL(dateSQL);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion == DATABASE_VERSION) {
            db.execSQL("drop table tb_words");
            onCreate(db);
        }
    }
}