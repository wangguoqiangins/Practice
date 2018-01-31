package com.ins.practice.app.mvc_test.view;

import android.view.View;

/**
 * Created by Administrator on 2018/1/31.
 */
public interface IGetSomethingView {
    void initview(View view);
    void onSuccess(String s);
    void onFailure();
}
