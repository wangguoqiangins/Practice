package com.ins.practice.app.java_knowledge;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.ins.practice.app.BaseAct;
import com.ins.practice.app.R;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by Administrator on 2018/1/31.
 */
public class KnowledgeAct extends BaseAct{
    private final StringBuilder s = new StringBuilder("ddd");
    private final int a = 5;
    private static final int b = 6;
    @Event(R.id.knowledge_btn)
    private void testData(View view){
        s.append("ddddd");
        abc:
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if(j > 4){
                    break abc;
                }
                Toast.makeText(this,"i = "+i+"  "+"j = "+j,Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this,"i = "+i,Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void initdata(View view) {
        x.view().inject(this);

    }

    @Override
    protected View initviews() {
        return LayoutInflater.from(this).inflate(R.layout.knowledge,null);
    }
}
