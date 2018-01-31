package com.ins.practice.app.textColorTest;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.ins.practice.app.BaseAct;
import com.ins.practice.app.R;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by Administrator on 2018/1/30.
 */
public class TextColorAct extends BaseAct{
    @ViewInject(R.id.text_test_tv_1)
    private TextView tv_1;
    @ViewInject(R.id.text_test_tv_all_text)
    private TextView tv_all;
    @ViewInject(R.id.text_test_tv_all_web)
    private TextView tv_all_2;
    @Override
    protected void initdata(View view) {
        tv_1 = (TextView) view.findViewById(R.id.text_test_tv_1);
        SpannableStringBuilder ssb = new SpannableStringBuilder("test_abc_abc_abc_abc_abc_abc");
//        ssb.setSpan(new ForegroundColorSpan(Color.RED),3,13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssb.setSpan(new TextClick(), 3, 13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv_1.setMovementMethod(LinkMovementMethod.getInstance());
        tv_1.setText(ssb);


    }
    public class TextClick extends ClickableSpan{

        @Override
        public void onClick(View widget) {
            Toast.makeText(TextColorAct.this,((TextView)widget).getText().toString(),Toast.LENGTH_SHORT).show();
        }

        @Override
        public void updateDrawState(TextPaint ds) {
//            super.updateDrawState(ds);
//            ds.setColor(Color.YELLOW);
        }

    }

    @Override
    protected View initviews() {
        x.view().inject(this);

        return LayoutInflater.from(this).inflate(R.layout.text_color_test,null);
    }
}
