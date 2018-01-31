package com.ins.practice.app.sqlitTest;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * Created by Administrator on 2018/1/24.
 */
public class NameProvider extends ContentProvider{
    private static UriMatcher uriMatcher = new UriMatcher(0);
    static {
        uriMatcher.addURI("com.ins.www.abc","thewaytohome",107);
    }
    private SqlitNameOH helper;
    @Override
    public boolean onCreate() {
        helper = new SqlitNameOH(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        int match = uriMatcher.match(uri);
        SQLiteDatabase database = helper.getWritableDatabase();
        Cursor cursor = null;
        switch (match){
            case 107:
                cursor = database.query("phone_name", projection, selection, selectionArgs, null, null, sortOrder);
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
        int match = uriMatcher.match(uri);
        SQLiteDatabase database = helper.getWritableDatabase();
        switch (match){
            case 107:
                database.insert("phone_name",null,values);
                break;
        }
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int ret = 0;
        int match = uriMatcher.match(uri);
        SQLiteDatabase database = helper.getWritableDatabase();
        switch (match){
            case 107:
                ret = database.delete("phone_name", selection, selectionArgs);
                break;
        }
        return ret;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int ret = 0;
        int match = uriMatcher.match(uri);
        SQLiteDatabase database = helper.getWritableDatabase();
        switch (match){
            case 107:
                ret = database.update("phone_name", values, selection, selectionArgs);
                break;
        }
        return ret;
    }
}
