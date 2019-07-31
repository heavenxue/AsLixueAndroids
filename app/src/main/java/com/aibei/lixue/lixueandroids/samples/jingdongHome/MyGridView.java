package com.aibei.lixue.lixueandroids.samples.jingdongHome;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * 作者：lixue on 2019/7/29 16:32
 */

public class MyGridView extends GridView {
    public MyGridView(Context context) {
        super(context);
    }

    public MyGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
