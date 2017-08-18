package com.example.qzsang.onsingleclicklistener;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by qzsang on 2017/8/18.
 */

public abstract class OnSingleItemClickListener extends BaseSingleClick implements AdapterView.OnItemClickListener{

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (isEableClick()) {
            singleItemClick(adapterView, view, i, l);
            endClick();
        }
    }

    public abstract void singleItemClick(AdapterView<?> adapterView, View view, int i, long l);
}
