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
import com.lb.utils.EncryptUtil;
import com.lb.utils.LogUtil;
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

        StateListDrawable selector = SelectorUtil.createNormalAndPressedSelector(drawableN, drawableP);


        tv.setBackgroundDrawable(selector);

        CacheUtil.putString(this, "key", "你好");

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShortToast(MainActivity.this, String.valueOf(CacheUtil.getString(MainActivity.this, "key", "ajdkjadask")));
            }
        });


        LogUtil.initLog(true, LogUtil.Level.e);
        String desDecrypt = EncryptUtil.desEncrypt("key", "This is data");
        LogUtil.log(this, "加密之后：" + desDecrypt);

        String data = EncryptUtil.desDecrypt("key", desDecrypt);
        LogUtil.log(this, "解密之后：" + data);

    }
}
