package com.ins.practice.app.mvc_test.model;

import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

/**
 * Created by Administrator on 2018/1/31.
 */
public class GetSomethingData implements IGetSomethingData{


    @Override
    public void getSomething(String url, final CallBack callBack) {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(String s) {
                callBack.onSuccess(s);
            }
        });
    }
}
