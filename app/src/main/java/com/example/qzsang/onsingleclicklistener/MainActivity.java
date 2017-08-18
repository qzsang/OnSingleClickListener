package com.example.qzsang.onsingleclicklistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    public int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btn_click).setOnClickListener(new OnSingleClickListener() {
            @Override
            protected void singleClick(View v) {
                Log.e("OnSingleClickListener", "开始处理点击的事件 i:" + (++i));
                //仿ui线程的耗时操作
                for (int j = 0;j < 1000000000;j++){}

                Log.e("OnSingleClickListener", "结束处理点击的事件 i:" + i);

            }
        });
    }
}
