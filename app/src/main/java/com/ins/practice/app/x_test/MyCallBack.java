package com.ins.practice.app.x_test;

import com.google.gson.Gson;
import com.ins.practice.app.beans.Student;
import org.xutils.common.Callback;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/1/29.
 */
public  class MyCallBack implements Callback.CommonCallback<String> {
    private List<Student> list;
//    public abstract void doData(List<Student> list);
    public interface MyCallBackDataInterface{
        void playData(List<Student> list);
    }
    private MyCallBackDataInterface myCallBackDataInterface;

    public void setMyCallBackDataInterface(MyCallBackDataInterface myCallBackDataInterface) {
        this.myCallBackDataInterface = myCallBackDataInterface;
    }

    @Override
    public void onSuccess(String s) {
        Gson gson = new Gson();
        Student[] students = gson.fromJson(s, Student[].class);
        List<Student> studentList = Arrays.asList(students);
        this.list = studentList;
//        doData(list);
        if(myCallBackDataInterface != null){
            myCallBackDataInterface.playData(list);
        }
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
