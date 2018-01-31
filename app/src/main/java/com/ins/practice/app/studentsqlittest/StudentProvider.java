package com.ins.practice.app.studentsqlittest;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * Created by Administrator on 2018/1/26.
 */
public class StudentProvider extends ContentProvider{
    private static UriMatcher matcher = new UriMatcher(0);
    static {
        matcher.addURI("com.ins.www.ddd","studenthome",109);
    }
    private StudentSqlitOH helper;
    @Override
    public boolean onCreate() {

        helper = new StudentSqlitOH(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        int match = matcher.match(uri);
        Cursor cursor = null;
        switch (match){
            case 109:
                SQLiteDatabase database = helper.getWritableDatabase();
                cursor = database.query("student", projection, selection, selectionArgs, null, null, sortOrder);
                break;
        }
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        int match = matcher.match(uri);
        switch (match){
            case 109:
                SQLiteDatabase database = helper.getWritableDatabase();
                database.insert("student",null,values);
                break;
        }
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int match = matcher.match(uri);
        switch (match){
            case 109:
                SQLiteDatabase database = helper.getWritableDatabase();
                database.delete("student",selection,selectionArgs);
                break;
        }
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int match = matcher.match(uri);
        switch (match){
            case 109:
                SQLiteDatabase database = helper.getWritableDatabase();
                database.update("student",values,selection,selectionArgs);
                break;
        }
        return 0;
    }
}
