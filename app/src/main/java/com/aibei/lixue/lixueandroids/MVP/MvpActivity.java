package com.aibei.lixue.lixueandroids.MVP;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aibei.lixue.lixueandroids.R;

import java.util.List;

public class MvpActivity extends AppCompatActivity implements SportView {
    private SportsPresenter mNewsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        mNewsPresenter = new SportsPresenterImpl(this);
    }

    @Override
    public void showProgess() {

    }

    @Override
    public void addNews(List<SportsBean> newsList) {
        mNewsPresenter.loadSportsNews(0,1);
    }
}
