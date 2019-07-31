package com.aibei.lixue.lixueandroids.samples.jingdongHome.banner;

import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public abstract class BannerAdapter<T> {
    private List<T> mDataList;

    List<T> getDataList() {
        return mDataList;
    }

    protected BannerAdapter(List<T> dataList) {
        mDataList = dataList;
    }

    void setImageViewSource(ImageView imageView, int position) {
        bindImage(imageView, mDataList.get(position));
    }

    void selectTips(TextView tv, int position) {
        if (mDataList != null && mDataList.size() > 0){
            bindTips(tv, mDataList.get(position));
        }
    }

    protected abstract void bindTips(TextView tv, T t);

    public abstract void bindImage(ImageView imageView, T t);


}
