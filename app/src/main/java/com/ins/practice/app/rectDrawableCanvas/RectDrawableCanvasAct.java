package com.ins.practice.app.rectDrawableCanvas;

import android.graphics.*;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.ins.practice.app.BaseAct;
import com.ins.practice.app.R;

/**
 * Created by Administrator on 2018/1/28.
 */
public class RectDrawableCanvasAct extends BaseAct{
    private ImageView imageView;
    @Override
    protected void initdata(View view) {
        imageView = (ImageView) view.findViewById(R.id.rdc_img);
    }

    @Override
    protected View initviews() {
        return LayoutInflater.from(this).inflate(R.layout.rdc_test,null);
    }

    public void start_paint(View view) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test_4).copy(Bitmap.Config.ARGB_8888,true);
        Canvas canvas = new Canvas(bitmap);
        Rect rect = new Rect(100, 100, 500, 500);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawRect(rect, paint);
        imageView.setImageBitmap(bitmap);
    }
}
