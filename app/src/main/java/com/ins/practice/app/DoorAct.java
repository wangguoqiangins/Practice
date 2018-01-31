package com.ins.practice.app;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.ins.practice.app.animtest.AnimAct;
import com.ins.practice.app.baiduditu.MapTest;
import com.ins.practice.app.java_knowledge.KnowledgeAct;
import com.ins.practice.app.lianXiRenLiebiao.ContactAct;
import com.ins.practice.app.mountListType.MountListTypeAct;
import com.ins.practice.app.mvc_test.Mvc_Test_1;
import com.ins.practice.app.rectDrawableCanvas.RectDrawableCanvasAct;
import com.ins.practice.app.recycleviewTest.RecycleAct;
import com.ins.practice.app.sqlitTest.SqlitAct;
import com.ins.practice.app.test.TestAct;
import com.ins.practice.app.textColorTest.TextColorAct;
import com.ins.practice.app.touchtest.TouchAct;
import com.ins.practice.app.touchtest.TouchTestAct;
import com.ins.practice.app.x_test.XAct;


public class DoorAct extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_door);
    }


    public void go_quick(View view) {
        Intent intent = new Intent(this, TouchAct.class);
        startActivity(intent);
    }
}
