package com.aibei.lixue.lixueandroids.samples.pictures;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.GridView;

import com.aibei.lixue.lixueandroids.R;

/**
 * 作者：lixue on 2019/7/3 15:59
 */

public class PhotoWallActivity extends Activity {
    private GridView gridView;
    private PhotoWallAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photowall);
        initView();
        initData();
    }

    private void initView(){
        gridView = findViewById(R.id.photo_wall);
    }

    private void initData(){
        adapter = new PhotoWallAdapter(this,0,Images.imageThumbUrls,gridView);
        gridView.setAdapter(adapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        adapter.cancle();
    }
}
