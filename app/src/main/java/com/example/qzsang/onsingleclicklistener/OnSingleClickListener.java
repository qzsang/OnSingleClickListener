package com.example.qzsang.onsingleclicklistener;

import android.view.View;


public abstract class OnSingleClickListener implements View.OnClickListener {
    public static final int MIN_CLICK_DELAY_TIME = 100;//在点击事件处理结束后 的100毫秒的时间内不处理点击事件
    private long endClickTime = 0;

    @Override
    public void onClick(View v) {
        long currentTime = System.currentTimeMillis();
        if (Math.abs(currentTime - endClickTime) > MIN_CLICK_DELAY_TIME) {
            singleClick(v);
            endClickTime = System.currentTimeMillis();

        }
    }

    protected abstract void singleClick(View v);

}