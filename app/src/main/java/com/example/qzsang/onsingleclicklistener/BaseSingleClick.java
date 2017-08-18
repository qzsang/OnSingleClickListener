package com.example.qzsang.onsingleclicklistener;

import android.view.View;

/**
 * Created by qzsang on 2017/8/18.
 */

public abstract class BaseSingleClick {
    private static final int CLICK_DELAY_TIME = 500;//在点击事件处理结束后 的500毫秒的时间内不处理点击事件
    private long endClickTime = 0;

    protected boolean isEableClick () {
        long currentTime = System.currentTimeMillis();
        if (Math.abs(currentTime - endClickTime) > CLICK_DELAY_TIME) {
            return true;
        }
        return false;
    }

    protected void endClick() {
        endClickTime = System.currentTimeMillis();
    }

}
