package com.ins.practice.app.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ins.practice.app.R;

import java.util.List;

/**
 * Created by Administrator on 2018/1/24.
 */
public class StringAdapter extends BaseAdapter {
    private List<String> list;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public StringAdapter(List<String> list) {
        this.list = list;
    }

    public StringAdapter() {
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView != null){
            viewHolder = (ViewHolder) convertView.getTag();
        }else {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.string_adapter, null);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.item_text);
            convertView.setTag(viewHolder);
        }
        viewHolder.textView.setText(list.get(position));
        return convertView;
    }
    public class ViewHolder{
        TextView textView;
    }
}
