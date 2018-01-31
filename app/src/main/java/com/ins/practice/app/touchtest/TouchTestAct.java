package com.ins.practice.app.touchtest;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import com.ins.practice.app.BaseAct;
import com.ins.practice.app.R;
import com.ins.practice.app.fragments.PersonFragment;
import com.ins.practice.app.util.ListUtil;
import com.ins.practice.app.util.NBAAdapter;
import com.ins.practice.app.util.StringAdapter;

import java.util.ArrayList;

public class TouchTestAct extends BaseAct {


    private ListView listView;
    private ViewPager viewPager;

    private View mPosition = null;
    @Override
    protected void initdata(View view) {
        listView.setAdapter(new StringAdapter(ListUtil.getList()));
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new PersonFragment());
        fragments.add(new PersonFragment());
        fragments.add(new PersonFragment());
        viewPager.setAdapter(new NBAAdapter(getSupportFragmentManager(), fragments));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                view.setBackgroundColor(Color.WHITE);
                view.setSelected(true);
            }
        });
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

    }

    @Override
    protected View initviews() {
        View view = LayoutInflater.from(this).inflate(R.layout.activity_touch_test, null);
        listView = (ListView) view.findViewById(R.id.touch_lv);
        viewPager = (ViewPager) view.findViewById(R.id.touch_vp);
        return view;
    }
}
