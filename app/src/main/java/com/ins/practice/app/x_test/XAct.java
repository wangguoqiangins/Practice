package com.ins.practice.app.x_test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.widget.Toast;
import com.ins.practice.app.BaseAct;
import com.ins.practice.app.R;


import com.ins.practice.app.beans.Student;
import org.xutils.DbManager;
import org.xutils.common.Callback;
import org.xutils.db.table.TableEntity;
import org.xutils.ex.DbException;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/29.
 */
@ContentView(R.layout.x_test)
public class XAct extends Activity{
    @ViewInject(R.id.x_btn_1)
    private Button btn_1;
    @ViewInject(R.id.x_btn_2)
    private Button btn_2;
    @ViewInject(R.id.x_tv_1)
    private TextView tv_1;
    @ViewInject(R.id.x_tv_2)
    private TextView tv_2;
    @ViewInject(R.id.x_btn_3)
    private TextView btn_3;
    @ViewInject(R.id.x_btn_4)
    private TextView btn_4;
    private DbManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        x.view().inject(this);

        btn_1.setText("创建数据库");
        btn_2.setText("获取数据库内容");
        btn_3.setText("添加内容");
        btn_4.setText("删除内容");
        setConfig();
    }
    public void setConfig(){
        DbManager.DaoConfig daoConfig = new DbManager.DaoConfig()
                //设置数据库名，默认xutils.db
                .setDbName("myapp.db")
                        //设置表创建的监听
                .setTableCreateListener(new DbManager.TableCreateListener() {
                    @Override
                    public void onTableCreated(DbManager db, TableEntity table){
                        Log.i("JAVA", "onTableCreated：" + table.getName());
                    }
                })
                        //设置是否允许事务，默认true
                        //.setAllowTransaction(true)
                        //设置数据库路径，默认安装程序路径下
                        //.setDbDir(new File("/mnt/sdcard/"))
                        //设置数据库的版本号
                        //.setDbVersion(1)
                        //设置数据库更新的监听
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion,
                                          int newVersion) {
                    }
                })
                        //设置数据库打开的监听
                .setDbOpenListener(new DbManager.DbOpenListener() {
                    @Override
                    public void onDbOpened(DbManager db) {
                        //开启数据库支持多线程操作，提升性能
                        db.getDatabase().enableWriteAheadLogging();
                    }
                });
        db = x.getDb(daoConfig);
    }

    @Event(R.id.x_btn_1)
    private void createData(View view){
        ArrayList<XStudent> xStudents = new ArrayList<XStudent>();
        xStudents.add(new XStudent("wangsan"));
        xStudents.add(new XStudent("alpha"));
        xStudents.add(new XStudent("basic"));
        xStudents.add(new XStudent("could"));
        xStudents.add(new XStudent("data"));
        xStudents.add(new XStudent("efinic"));
        xStudents.add(new XStudent("fantacy"));
        xStudents.add(new XStudent("goodman"));
        xStudents.add(new XStudent("how"));
        xStudents.add(new XStudent("infition"));
        xStudents.add(new XStudent("jeep"));
        xStudents.add(new XStudent("knowledge"));
        xStudents.add(new XStudent("loog"));
        try {
            db.save(xStudents);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }
    private String url = "http://192.168.43.218/user.txt";
    @Event(value = R.id.x_btn_2,type = View.OnClickListener.class)
    private void queryData(View view){
        try {
            List<XStudent> all = db.selector(XStudent.class).findAll();
            if(all != null && all.size() > 0){
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < all.size(); i++) {
                    stringBuilder.append(all.get(i).getName()).append("\n");
                }
                tv_1.setText(stringBuilder.toString());
            }else {
                tv_1.setText("内容为空");
            }

        } catch (DbException e) {
            e.printStackTrace();
        }
    }
    @Event(type = View.OnClickListener.class,value = R.id.x_btn_3)
    private void addData(View view){
        XStudent test = new XStudent("test");
        try {
            db.saveOrUpdate(test);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }
    @Event(type = View.OnClickListener.class,value = R.id.x_btn_4)
    private void deleteData(View view){
        try {
            db.dropTable(XStudent.class);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }
}
