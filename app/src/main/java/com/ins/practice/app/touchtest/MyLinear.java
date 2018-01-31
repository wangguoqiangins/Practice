package com.ins.practice.app.touchtest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/2/1.
 */
public class MyLinear extends LinearLayout{
    public MyLinear(Context context) {
        super(context);
    }

    public MyLinear(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinear(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        Toast.makeText(getContext(),getClass().getSimpleName()+"被点击了",Toast.LENGTH_SHORT).show();
        return super.onTouchEvent(event);
    }
}
