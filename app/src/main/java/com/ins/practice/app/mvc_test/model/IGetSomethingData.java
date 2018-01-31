package com.ins.practice.app.mvc_test.model;

/**
 * Created by Administrator on 2018/1/31.
 */
public interface IGetSomethingData {
    void getSomething(String url,IGetSomethingData.CallBack callBack);
     interface CallBack{
        void onSuccess(String s);
        void onFailure();
    }

}
