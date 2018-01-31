package com.ins.practice.app.usersqlittest;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * Created by Administrator on 2018/1/26.
 */
public class UserProvider extends ContentProvider{
    private static UriMatcher uriMatcher = new UriMatcher(0);
    static {
        uriMatcher.addURI("com.ins.www.ccc","userhome",108);
    }
    private UserSqlitOH helper;
    @Override
    public boolean onCreate() {
        helper = new UserSqlitOH(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor ret = null;
        int match = uriMatcher.match(uri);
        SQLiteDatabase database = helper.getWritableDatabase();
        switch (match){
            case 108:
                ret = database.query("user", projection, selection, selectionArgs, null, null, sortOrder);
                break;
        }

        return ret;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase database = helper.getWritableDatabase();
        int match = uriMatcher.match(uri);
        switch (match){
            case 108:
                database.insert("user",null,values);
                break;
        }
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int match = uriMatcher.match(uri);
        switch (match){
            case 108:
                SQLiteDatabase database = helper.getWritableDatabase();
                int i = database.delete("user", selection, selectionArgs);
                break;
        }
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int match = uriMatcher.match(uri);
        switch (match){
            case 108:
                SQLiteDatabase database = helper.getWritableDatabase();
                int i = database.update("user", values, selection, selectionArgs);
                break;
        }
        return 0;
    }
}
