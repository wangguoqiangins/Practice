package com.ins.practice.app.mvc_test.view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.ins.practice.app.R;

/**
 * Created by Administrator on 2018/1/31.
 */
public class GetSomethingView implements IGetSomethingView {
    private TextView view;
//    private TextView textView;
//    private Button button;
    public GetSomethingView(View view) {
        this.view = (TextView) view;
//        initview(view);
    }

    @Override
    public void initview(View view) {


    }

    @Override
    public void onSuccess(String s) {
        view.setText(s);
    }

    @Override
    public void onFailure() {
        view.setText("error");
    }
}
