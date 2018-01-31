package com.ins.practice.app.studentsqlittest;

import com.google.gson.Gson;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/1/26.
 */
public abstract class ListStudentCallback extends Callback<List<Student>>
{
    @Override
    public List<Student> parseNetworkResponse(Response response) throws IOException
    {
        String string = response.body().string();
//        List<User> user = new Gson().fromJson(string, List.class);
//        return user;

        Gson gson = new Gson();
        Student[] list  = gson.fromJson(string,Student[].class);

        return Arrays.asList(list);
    }


}
