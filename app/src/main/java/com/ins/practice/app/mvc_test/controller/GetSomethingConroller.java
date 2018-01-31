package com.ins.practice.app.mvc_test.controller;

import android.view.View;
import com.ins.practice.app.R;
import com.ins.practice.app.mvc_test.model.IGetSomethingData;
import com.ins.practice.app.mvc_test.view.IGetSomethingView;

/**
 * Created by Administrator on 2018/1/31.
 */
public class GetSomethingConroller implements View.OnClickListener{
    private IGetSomethingView iGetSomethingView;
    private IGetSomethingData iGetSomethingData;
    private String url;
    public GetSomethingConroller(String url,IGetSomethingView iGetSomethingView, IGetSomethingData iGetSomethingData) {
        this.iGetSomethingView = iGetSomethingView;
        this.iGetSomethingData = iGetSomethingData;
        this.url = url;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mvc_btn:
                iGetSomethingData.getSomething(url, new IGetSomethingData.CallBack() {
                    @Override
                    public void onSuccess(String s) {
                        iGetSomethingView.onSuccess(s);
                    }

                    @Override
                    public void onFailure() {
                        iGetSomethingView.onFailure();
                    }
                });
                break;
        }
    }
}
