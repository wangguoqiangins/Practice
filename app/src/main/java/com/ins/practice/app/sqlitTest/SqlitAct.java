package com.ins.practice.app.sqlitTest;

import android.content.*;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.ins.practice.app.R;
import com.ins.practice.app.studentsqlittest.ListStudentCallback;
import com.ins.practice.app.studentsqlittest.Student;
import com.ins.practice.app.util.StringAdapter;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.*;

public class SqlitAct extends FragmentActivity {
    private ListView listView;
    private List<String> list;
    private StringAdapter stringAdapter;
    private Button netBtn;
    private NetBroadcast netBroadcast;
    private String url = "http://192.168.43.218/user.txt";
    private HashMap<String,Student> hashMap = new HashMap<String, Student>();
    private class NetBroadcast extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
                ConnectivityManager manager = (ConnectivityManager) context
                        .getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
                if (activeNetwork != null) { // connected to the internet
                    if (activeNetwork.isConnected()) {
                        netBtn.setVisibility(View.GONE);
                    }
                } else {   // not connected to the internet

                    netBtn.setVisibility(View.VISIBLE);
                    TranslateAnimation translateAnimation = new TranslateAnimation(
                            Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF,0,
                            Animation.RELATIVE_TO_SELF,-100,Animation.RELATIVE_TO_SELF, 0);
                    translateAnimation.setDuration(1000);
                    netBtn.startAnimation(translateAnimation);
                }

            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlit);
        initviews();
        initdata();
    }

    private void initdata() {
        ContentResolver contentResolver = getContentResolver();
        Uri uri = Uri.parse("content://com.ins.www.ddd/studenthome");
        Cursor cursor = contentResolver.query(uri, null, null, null, null);
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String grade = cursor.getString(cursor.getColumnIndex("grade"));
            list.add(name+" "+" "+grade);
        }
//        stringAdapter.notifyDataSetChanged();
        listView.invalidateViews();
        netBroadcast = new NetBroadcast();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(netBroadcast,intentFilter);
    }

    private void initviews() {
        netBtn = (Button) findViewById(R.id.net_btn);
        listView = (ListView) findViewById(R.id.sqlit_lv);
        stringAdapter = new StringAdapter();
        list = new ArrayList<String>();
        stringAdapter.setList(list);
        listView.setAdapter(stringAdapter);
        list.clear();
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(netBroadcast);
        super.onDestroy();
    }

    public void add_name(View view) {
        ContentResolver contentResolver = getContentResolver();
        Uri uri = Uri.parse("content://com.ins.www.ccc/userhome");
        ContentValues contentValues = new ContentValues();
        contentValues.put("name","liangsan");
        contentValues.put("sex","男");
        contentValues.put("grade","378");
        contentResolver.insert(uri,contentValues);
    }

    public void delete_name(View view) {
        ContentResolver contentResolver = getContentResolver();
        Uri uri = Uri.parse("content://com.ins.www.ccc/userhome");
        contentResolver.delete(uri,"name = ?",new String[]{"liangsan"});
    }

    public void update_name(View view) {
        ContentResolver contentResolver = getContentResolver();
        Uri uri = Uri.parse("content://com.ins.www.ccc/userhome");
        ContentValues contentValues = new ContentValues();
        contentValues.put("name","shibatian");
        contentValues.put("sex","女");
        contentValues.put("grade","876");
        contentResolver.update(uri,contentValues,"name = ?",new String[]{"liangsan"});
    }

    public void search_name(View view) {
        list.clear();
        ContentResolver contentResolver = getContentResolver();
        Uri uri = Uri.parse("content://com.ins.www.ccc/userhome");
        Cursor cursor = contentResolver.query(uri, null, null, null, null);
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String sex = cursor.getString(cursor.getColumnIndex("sex"));
            String grade = cursor.getString(cursor.getColumnIndex("grade"));
            list.add(name+" "+sex+" "+grade);
        }
//        stringAdapter.notifyDataSetChanged();
        listView.invalidateViews();
    }


    public void get_net_data(View view) {
        boolean netValid = isNetValid(this);
        if(netValid){
            getNetData();
        }else {

        }

    }

    public void start_net_settings(View view) {
        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
    }

    public boolean isNetValid(Context context){
        boolean ret = false;
        if (context != null) {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                ret = activeNetworkInfo.isAvailable();
            }
        }


        return ret;
    }

    private void getNetData() {
        OkHttpUtils.get().url(url).build().execute(new ListStudentCallback() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(List<Student> students) {
                list.clear();
                //1,取出数据库中的内容放到hashmap中
                ContentResolver contentResolver = getContentResolver();
                Uri uri = Uri.parse("content://com.ins.www.ddd/studenthome");
                Cursor cursor = contentResolver.query(uri, null, null, null, null);
                while (cursor.moveToNext()){
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    String grade = cursor.getString(cursor.getColumnIndex("grade"));
                    hashMap.put(name,new Student(name,grade));
                }
                //2,添加网络数据内容到hashmap中
                for (int i = 0; i < students.size(); i++) {
                    hashMap.put(students.get(i).getName(),students.get(i));
                }
                //3,数据库清空，然后把hashmap中的数据放入数据库
                contentResolver.delete(uri, null, null);
                Set<Map.Entry<String, Student>> entries = hashMap.entrySet();
                Iterator<Map.Entry<String, Student>> iterator = entries.iterator();
                while (iterator.hasNext()){
                    Map.Entry<String, Student> next = iterator.next();
                    Student value = next.getValue();
                    ContentValues contentValues = new ContentValues();
                    String name = value.getName();
                    contentValues.put("name", name);
                    String grade = value.getGrade();
                    contentValues.put("grade", grade);
                    list.add(name + "  " + grade);
                    Collections.sort(list);
                    contentResolver.insert(uri, contentValues);
                }
                listView.invalidateViews();

            }
        });
    }
}
