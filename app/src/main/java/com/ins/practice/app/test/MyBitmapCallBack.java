package com.ins.practice.app.test;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.ins.practice.app.java_knowledge.KnowledgeAct;
import org.xutils.common.Callback;

/**
 * Created by Administrator on 2018/1/30.
 */
public abstract class MyBitmapCallBack implements Callback.CommonCallback<Drawable> {
    public abstract void dowithbitmap(Bitmap b);
    @Override
    public void onSuccess(Drawable drawable) {

        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap bitmap = bitmapDrawable.getBitmap();
        dowithbitmap(bitmap);
    }



    @Override
    public void onError(Throwable throwable, boolean b) {

    }

    @Override
    public void onCancelled(CancelledException e) {

    }

    @Override
    public void onFinished() {

    }
}
