package com.ins.practice.app.touchtest;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.ins.practice.app.BaseAct;
import com.ins.practice.app.R;

/**
 * Created by Administrator on 2018/2/1.
 */
public class TouchAct extends BaseAct implements View.OnClickListener {
    @Override
    protected void initdata(View view) {
        view.setOnClickListener(this);
        MyLinear linearLayout = (MyLinear) view;
        linearLayout.setFocusableInTouchMode(true);
        linearLayout.setClickable(true);


//        view.findViewById(R.id.touch_btn).setOnClickListener(this);
    }

    @Override
    protected View initviews() {
        return LayoutInflater.from(this).inflate(R.layout.touch_ll,null);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.touch_ll:
                Toast.makeText(this, getClass().getSimpleName() + "被点击了", Toast.LENGTH_SHORT).show();

                break;
//            case R.id.touch_btn:
//                Toast.makeText(this,getClass().getSimpleName()+"被点击了",Toast.LENGTH_SHORT).show();
//
//                break;
        }
    }
}
