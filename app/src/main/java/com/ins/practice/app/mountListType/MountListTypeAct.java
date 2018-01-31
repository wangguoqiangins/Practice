package com.ins.practice.app.mountListType;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import com.ins.practice.app.R;
import com.ins.practice.app.beans.Person;
import com.ins.practice.app.util.MountTypeAdapter;

import java.util.ArrayList;

public class MountListTypeAct extends FragmentActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mount_list_type);

        listView = (ListView) findViewById(R.id.mount_lv);
        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(new Person(0, "张三", 100));
        persons.add(new Person(1, "王五", 987));
        persons.add(new Person(1, "李四", 333));
        persons.add(new Person(0,"狗四",444));
        persons.add(new Person(0,"刘涛",555));
        persons.add(new Person(0, "长成", 784));
        persons.add(new Person(1, "王五", 987));
        persons.add(new Person(1,"小哥",101));persons.add(new Person(0,"狗四",444));
        persons.add(new Person(0,"狗蛋",666));
        persons.add(new Person(0, "长成", 784));
        persons.add(new Person(1, "王五", 987));
        persons.add(new Person(1,"李四",333));persons.add(new Person(0,"狗四",444));
        persons.add(new Person(1,"刘涛",555));
        persons.add(new Person(0,"老四",193));
        persons.add(new Person(1,"小高",987));
        persons.add(new Person(0,"李四",333));persons.add(new Person(0,"狗四",444));
        persons.add(new Person(0,"刘涛",434));
        persons.add(new Person(0,"成功",784));
        persons.add(new Person(1,"大成",545));
        persons.add(new Person(0,"苍狗",498));
        MountTypeAdapter adapter = new MountTypeAdapter(persons);
        listView.setAdapter(adapter);
    }

}
