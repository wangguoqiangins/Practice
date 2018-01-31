package com.ins.practice.app.recycleviewTest;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import com.ins.practice.app.BaseAct;
import com.ins.practice.app.R;
import com.ins.practice.app.util.ListUtil;

import java.util.List;

/**
 * Created by Administrator on 2018/1/28.
 */
public class RecycleAct extends BaseAct{
    private RecyclerView recyclerView;
    @Override
    protected void initdata(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        List<String> list = ListUtil.getList();
        list.addAll(list);
        list.addAll(list);
        recyclerView.setAdapter(new MyReAdapter(list));
        recyclerView.addItemDecoration(new MyDividerItemDecoration(this,LinearLayoutManager.VERTICAL));
    }

    @Override
    protected View initviews() {

        return LayoutInflater.from(this).inflate(R.layout.recycle_item,null);
    }
}
