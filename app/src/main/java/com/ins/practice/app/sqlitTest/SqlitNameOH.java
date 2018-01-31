package com.ins.practice.app.sqlitTest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 2018/1/24.
 */
public class SqlitNameOH extends SQLiteOpenHelper{
    public SqlitNameOH(Context context) {
        super(context, "name.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table phone_name(id_ integer primary key autoincrement,name text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("dddddddddssssssssssssss",oldVersion+"  "+newVersion);
    }

}
