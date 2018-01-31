package com.ins.practice.app.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ins.practice.app.R;
import com.ins.practice.app.beans.Person;

import java.util.List;

/**
 * Created by Administrator on 2018/1/27.
 */
public class MountTypeAdapter extends BaseAdapter{
    private List<Person> list;

    public MountTypeAdapter(List<Person> list) {
        this.list = list;
    }

    public MountTypeAdapter() {
    }

    public void setList(List<Person> list) {
        this.list = list;
    }

    public List<Person> getList() {
        return list;
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
    public int getItemViewType(int position) {

        int type = list.get(position).getType();

        return type;
    }


    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        switch (type){
            case 0:
                StudentViewHolder svh = null;
                if(convertView != null ){
                    svh = (StudentViewHolder) convertView.getTag();
                }else {
                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mount_item_1,null);
                    svh = new StudentViewHolder();
                    svh.name = (TextView) convertView.findViewById(R.id.mount_item_1_text_student);
                    svh.grade = (TextView) convertView.findViewById(R.id.mount_item_1_text_grade);
                    convertView.setTag(svh);
                }
                svh.name.setText(list.get(position).getName());
                svh.grade.setText(list.get(position).getGrade()+"");
                break;
            case 1:
                TeacherViewHolder tvh = null;
                if(convertView != null ){
                    tvh = (TeacherViewHolder) convertView.getTag();
                }else {
                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mount_item_2,null);
                    tvh = new TeacherViewHolder();
                    tvh.name = (TextView) convertView.findViewById(R.id.mount_item_2_text_teacher);
                    tvh.grade = (TextView) convertView.findViewById(R.id.mount_item_2_text_grade);
                    convertView.setTag(tvh);
                }
                tvh.name.setText(list.get(position).getName());
                tvh.grade.setText(list.get(position).getGrade()+"");
                break;
        }
        return convertView;
    }
    public class StudentViewHolder{
        TextView name;
        TextView grade;
    }
    public class TeacherViewHolder{
        TextView name;
        TextView grade;
    }
}
