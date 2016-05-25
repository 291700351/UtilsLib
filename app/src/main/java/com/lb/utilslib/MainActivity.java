package com.lb.utilslib;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lb.utils.CacheUtil;
import com.lb.utils.DrawableUtil;
import com.lb.utils.SelectorUtil;
import com.lb.utils.ToastUtil;
import com.lb.utils.ViewUtil;

public class MainActivity extends AppCompatActivity {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = ViewUtil.findViewById(this, R.id.tv);

        GradientDrawable drawableN = DrawableUtil.createRectangleDrawable(Color.GREEN, 30f, 10f, 10f, 30f);
        GradientDrawable drawableP = DrawableUtil.createRectangleDrawable(Color.RED, 30f, 10f, 10f, 30f);

        StateListDrawable selector = SelectorUtil.createPressedSelector(drawableN, drawableP);

        tv.setBackgroundDrawable(selector);

        CacheUtil.putString(this, "key", "你好");

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShortToast(MainActivity.this, String.valueOf(CacheUtil.getString(MainActivity.this, "key", "ajdkjadask")));
            }
        });

    }
}
