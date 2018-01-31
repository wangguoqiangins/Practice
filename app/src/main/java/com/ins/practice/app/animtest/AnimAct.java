package com.ins.practice.app.animtest;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.*;
import android.widget.TextView;
import android.widget.Toast;
import com.ins.practice.app.BaseAct;
import com.ins.practice.app.R;

/**
 * Created by Administrator on 2018/1/28.
 */
public class AnimAct extends BaseAct {

    private TextView textView;
    private ObjectAnimator alpha;

    @Override
    protected void initdata(View view) {
        textView = (TextView) view.findViewById(R.id.anim_text);

    }

    @Override
    protected View initviews() {
        View view = LayoutInflater.from(this).inflate(R.layout.activity_anim, null);
        return view;
    }

    public void anim_go(View view) {
        objectTest(textView);
    }
    public void anim_cancle(View view) {
        alpha.cancel();
    }
    public void objectTest(View view){
        alpha = ObjectAnimator.ofFloat(view, "rotation", 0, 150, -200, 300, -300, 0);
        alpha.setDuration(5000);
        alpha.setRepeatCount(-1);
        alpha.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (Float)animation.getAnimatedValue();
                Log.d("aaaaaaaaaaabbbbbbbbb",value+" ");
            }
        });
        alpha.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Toast.makeText(AnimAct.this, "动画开始", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Toast.makeText(AnimAct.this, "动画结束", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Toast.makeText(AnimAct.this, "动画取消", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Toast.makeText(AnimAct.this, "动画重复", Toast.LENGTH_SHORT).show();
            }
        });
        alpha.start();
    }

    public void frameTest(View view){
        AnimationDrawable animationDrawable = (AnimationDrawable) view.getBackground();
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    public void rotateTest(View view){
        RotateAnimation rotateAnimation = new RotateAnimation(0,360,200,200);
        rotateAnimation.setDuration(3000);
        view.startAnimation(rotateAnimation);
    }

    public void scaleTest(View view){
        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 2, 0, 2,100,200);
//        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(1000);
        view.startAnimation(scaleAnimation);
    }

    public void alphaTest(View view){
        AlphaAnimation alphaAnimation = new AlphaAnimation(-2, 2);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    public void translateTest(View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, (float)0.5, Animation.RELATIVE_TO_SELF, (float)0.5
        ,Animation.RELATIVE_TO_SELF,(float)0.5,Animation.RELATIVE_TO_SELF,2);
        translateAnimation.setDuration(2000);
        translateAnimation.setFillAfter(true);
        view.startAnimation(translateAnimation);
    }



}
