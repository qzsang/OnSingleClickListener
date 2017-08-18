package com.example.qzsang.onsingleclicklistener;

import android.view.View;

/**
 * Created by qzsang on 2017/8/18.
 */

public abstract class OnSingleClickListener extends BaseSingleClick implements View.OnClickListener {

    @Override
    public void onClick(View v) {
       if (isEableClick()) {
           singleClick(v);
           endClick();
       }
    }

    protected abstract void singleClick(View v);


}