package com.ins.practice.app.x_test;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;

/**
 * Created by Administrator on 2018/1/30.
 */
public  abstract class MyCallStringBack extends Callback<String>{

    @Override
    public String parseNetworkResponse(Response response) throws IOException {
        String string = response.body().string();
        return string;
    }

}
