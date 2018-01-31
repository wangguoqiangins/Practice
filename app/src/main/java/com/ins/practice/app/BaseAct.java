package com.ins.practice.app;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.Toast;


public abstract class BaseAct extends FragmentActivity {
    private FrameLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_base);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.custom_title_1);
        container = (FrameLayout) findViewById(R.id.base_container);
        View view = initviews();
        if (view != null) {
            container.addView(view);
            initdata(view);
        }else {
            Toast.makeText(this,"请确认是否添加子View!",Toast.LENGTH_LONG).show();
        }

    }

    protected abstract void initdata(View view);

    protected abstract View initviews();

}
