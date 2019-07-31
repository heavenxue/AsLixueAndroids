package com.aibei.lixue.lixueandroids.MVP;

/**
 * 作者：lixue on 2019/7/17 10:20
 */

public class SportsPresenterImpl implements SportsPresenter,OnLoadSportsListener {
    private static final String TAG = "SportsPresenterImpl";

    private SportView mNewsView;
    private SportsModel mNewsModel;

    public SportsPresenterImpl(SportView mNewsView){
        this.mNewsView = mNewsView;
    }

    @Override
    public void loadSportsNews(int type, int page) {
        mNewsModel = new SportsModel();
    }
}
