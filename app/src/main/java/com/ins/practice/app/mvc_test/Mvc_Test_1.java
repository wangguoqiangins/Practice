package com.ins.practice.app.mvc_test;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.ins.practice.app.BaseAct;
import com.ins.practice.app.R;
import com.ins.practice.app.mvc_test.controller.GetSomethingConroller;
import com.ins.practice.app.mvc_test.model.GetSomethingData;
import com.ins.practice.app.mvc_test.view.GetSomethingView;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

public class Mvc_Test_1 extends BaseAct {

    private String url = "http://192.168.0.104/tb.txt";
    @Override
    protected void initdata( View view) {
        TextView textView = (TextView) view.findViewById(R.id.mvc_tv);
        Button button = (Button) view.findViewById(R.id.mvc_btn);
        GetSomethingConroller getSomethingConroller = new GetSomethingConroller(url, new GetSomethingView(textView), new GetSomethingData());
        button.setOnClickListener(getSomethingConroller);
    }

    @Override
    protected View initviews() {
        return LayoutInflater.from(this).inflate(R.layout.activity_mvc__test_1,null);
    }


}
