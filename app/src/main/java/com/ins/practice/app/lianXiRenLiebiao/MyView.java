package com.ins.practice.app.lianXiRenLiebiao;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2018/1/29.
 */
public class MyView extends View{

    public MyView(Context context) {
        super(context);
        initview(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initview(context);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initview(context);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initview(context);
    }

    /**
     * 右边要显示的字母列表
     */
    private String[] letters = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T"
            ,"U","V","W","X","Y","Z"};
    /**
     * 中间要显示的TextView
     */
    private TextView showText;
    private Paint paint;
    public void setShowText(TextView showText) {
        this.showText = showText;
    }
    private void initview(Context context){
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
        paint.setTextSize(40);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int height = getHeight();
        int blockHeight = height/letters.length;
        for (int i = 0; i < letters.length; i++) {
            int measureText = (int)paint.measureText(letters[i]);
            canvas.drawText(letters[i],getWidth()/2-measureText/2,blockHeight/2+blockHeight*i,paint);
        }

    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int width = getHeight();
        int blockSize = width/letters.length;
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                setBackgroundColor(Color.GRAY);
                int y = (int)event.getY();
                for (int i = 0; i < letters.length; i++) {
                    if(y > i*blockSize && y < (i+1)*blockSize){
                        if(showText != null){
                            showText.setVisibility(VISIBLE);
                            showText.setText(letters[i]);
                            return true;
                        }
                    }

                }
                break;
            case MotionEvent.ACTION_UP:
                setBackgroundColor(Color.WHITE);
                if(showText != null)
                showText.setVisibility(GONE);
                break;
        }
        return true;
    }
}
