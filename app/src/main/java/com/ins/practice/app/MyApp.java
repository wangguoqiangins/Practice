package com.ins.practice.app;

import android.app.Application;
import org.xutils.x;

/**
 * Created by Administrator on 2018/1/29.
 */
public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
