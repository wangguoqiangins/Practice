package com.ins.practice.app.lianXiRenLiebiao;

import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.ins.practice.app.BaseAct;
import com.ins.practice.app.R;
import com.ins.practice.app.util.StringAdapter;

/**
 * Created by Administrator on 2018/1/29.
 */
public class ContactAct extends BaseAct{
    @Override
    protected void initdata(View view) {
        MyView myView = (MyView) view.findViewById(R.id.letter_my_view);
        TextView showView = (TextView) view.findViewById(R.id.letter_show_view);
        myView.setShowText(showView);
        ExpandableListView listView = (ExpandableListView) view.findViewById(R.id.letter_lv);
        ExpandableListAdapter listAdapter = new BaseExpandableListAdapter() {
            int[] logs = new int[]{R.mipmap.test_3,R.mipmap.test_4,R.mipmap.test_5};
            private String[] generalTypes = new String[]{"秦始皇","路人甲","狗四"};
            private String[][] generals = new String[][]{{"曹操","夏侯惇","曹丕","夏侯楙","曹冲"},{"刘备","诸葛亮","诸葛恪","黄月英","刘禅"},
                    {"孙权","陆逊","鲁肃","黄盖","张昭"}};
            private int[][] generallogos = new int[][]{{R.mipmap.test_2,R.mipmap.test_3,R.mipmap.test_4,R.mipmap.test_5,R.mipmap.test_6},
                    {R.mipmap.test_2,R.mipmap.test_3,R.mipmap.test_4,R.mipmap.test_5,R.mipmap.test_6},
                    {R.mipmap.test_2,R.mipmap.test_3,R.mipmap.test_4,R.mipmap.test_5,R.mipmap.test_6}};

            @Override
            public int getGroupCount() {
                return generalTypes.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return generals[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return generalTypes[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return generals[groupPosition][childPosition];
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }

            TextView getTextView() {
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                        ViewGroup.LayoutParams.FILL_PARENT, 64);
                TextView textView = new TextView(
                        ContactAct.this);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL);
                textView.setPadding(36, 0, 0, 0);
                textView.setTextSize(20);
                textView.setTextColor(Color.BLACK);
                return textView;
            }
            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                LinearLayout ll = new LinearLayout(
                        ContactAct.this);
                ll.setOrientation(LinearLayout.VERTICAL);
                ImageView logo = new ImageView(ContactAct.this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(160, 160);
                logo.setLayoutParams(layoutParams);
                logo.setScaleType(ImageView.ScaleType.CENTER_CROP);
                logo.setImageResource(logs[groupPosition]);
                logo.setPadding(50, 0, 0, 0);
//                ll.addView(logo);
                ll.setBackgroundColor(Color.GRAY);
                TextView textView = getTextView();
                textView.setTextColor(Color.BLACK);
                textView.setText(getGroup(groupPosition).toString());
                ll.addView(textView);
                return ll;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                LinearLayout ll = new LinearLayout(
                        ContactAct.this);
                ll.setOrientation(LinearLayout.VERTICAL);
                ImageView generallogo = new ImageView(
                        ContactAct.this);
                generallogo
                        .setImageResource(generallogos[groupPosition][childPosition]);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(160, 160);
                generallogo.setLayoutParams(layoutParams);
                generallogo.setScaleType(ImageView.ScaleType.CENTER_CROP);
                ll.addView(generallogo);
                TextView textView = getTextView();
                textView.setText(getChild(groupPosition, childPosition)
                        .toString());
                ll.addView(textView);
                return ll;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }
        };
        listView.setAdapter(listAdapter);

        int count = listView.getCount();
        for (int i = 0; i < count; i++) {
            listView.expandGroup(i);
        }
        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
            }
        });
        listView.setSelectedGroup(1);

    }

    @Override
    protected View initviews() {
        return LayoutInflater.from(this).inflate(R.layout.contact,null);
    }
}
