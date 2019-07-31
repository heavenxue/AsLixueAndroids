package com.aibei.lixue.lixueandroids.samples.jingdongHome;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;


/**
 * 作者：lixue on 2019/7/29 17:05
 */

public class MyScrollView extends ScrollView {
    private OnScrollListener onScrollListener;
    private int lastScrollY;


    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(onScrollListener != null){
            onScrollListener.onScroll(lastScrollY = this.getScrollY());
        }
        switch(ev.getAction()){
            case MotionEvent.ACTION_UP:
                handler.sendMessageDelayed(handler.obtainMessage(), 20);
                break;
        }
        return super.onTouchEvent(ev);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }

    public interface OnScrollListener {
        /**
         * 回调方法
         *
         * @param scrollY 返回myScrollview滑动的Y方向距离
         */
        void onScroll(int scrollY);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int scrollY = MyScrollView.this.getScrollY();
            if (lastScrollY != scrollY){
                lastScrollY = scrollY;
                handler.sendMessageDelayed(handler.obtainMessage(),5);
            }
            if (onScrollListener != null){
                onScrollListener.onScroll(scrollY);
            }
        }
    };
}
