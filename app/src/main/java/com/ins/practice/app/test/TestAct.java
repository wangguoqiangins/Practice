package com.ins.practice.app.test;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.ins.practice.app.BaseAct;
import com.ins.practice.app.R;

import com.ins.practice.app.java_knowledge.KnowledgeAct;
import com.ins.practice.app.x_test.MyCallBack;
import com.ins.practice.app.x_test.MyCallStringBack;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.http.app.ParamsBuilder;
import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2018/1/29.
 */
public class TestAct extends BaseAct{
    @Override
    protected void initdata(View view) {
        x.view().inject(this);
    }
    @ViewInject(R.id.test_tv)
    private TextView textView;
    @ViewInject(R.id.test_img)
    private ImageView imageView;

    @Event(R.id.test_btn_clear_data)
    private void clear_data(View view){
//        new Thread(){
//            @Override
//            public void run() {
//                Glide.get(TestAct.this).clearDiskCache();
//            }
//        }.start();

    }
    @Override
    protected View initviews() {
        return LayoutInflater.from(this).inflate(R.layout.test,null);
    }

    private String url = "http://192.168.0.104/tb.txt";
    private String urlImg = "http://192.168.0.104/test_2.jpg";
//    private String url = "http://55ba905f.ngrok.io/hh.txt";
    private void test(){

    }

    private void test(String s){

    }
    public void post_data(View view) {

//        Glide.with(this).load(urlImg).into(imageView);
        ImageOptions.Builder builder = new ImageOptions.Builder();
        ImageOptions options = builder.setFadeIn(true).setCircular(true).build();
        x.image().bind(imageView, urlImg, options, new MyBitmapCallBack() {
            @Override
            public void dowithbitmap(Bitmap b) {
                imageView.setImageBitmap(b);
            }
        });


    }

    private void getStringByXUtil() {
        x.http().get(new RequestParams(url), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                try {

                    textView.setText(s);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                textView.setText(s);
                Log.d("dddddddddddd", s);
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                Log.d("dddddddddddd", "error");
            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void getStringByOkhttp() {
        OkHttpUtils.get().url(url).build().execute(new MyCallStringBack() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(String s) {
                try {
//                    String s1 = new String(s.getBytes(), "utf-8");
                    textView.setText(s);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

}
