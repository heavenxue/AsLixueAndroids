package com.aibei.lixue.lixueandroids.samples.jingdongHome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aibei.lixue.lixueandroids.R;
import com.aibei.lixue.lixueandroids.samples.jingdongHome.banner.Banner;
import com.aibei.lixue.lixueandroids.samples.jingdongHome.banner.BannerAdapter;
import com.aibei.lixue.lixueandroids.samples.pictures.Images;
import com.aibei.lixue.lixuelib.utils.LogUtil;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JingdongHomeActivity extends AppCompatActivity implements MyScrollView.OnScrollListener {
    private static final String TAG = "JingdongHomeActivity";

    private Banner banner;
    private Banner banner2;
    private List<String> imageUrls;
    private List<String> imageJingdongUrls;

    private CommonViewPager viewPager;
    private PagerIndicator pagerIndicator;
    private GridviewAdapter adapter;

    private MyScrollView myScrollView;
    private int Layout = R.layout.viewpager_content;
    private View pageView;
    private LinearLayout ll_rootview,ll_dalei,ll_leibie1,ll_leibie2,ll_dalei3;

    private int topHeight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jingdong_home);
        initView();
        initData();
    }

    private void  initView(){
        banner = findViewById(R.id.banner_jingdong);
        banner2 = findViewById(R.id.banner_jingdong2);
        viewPager = findViewById(R.id.viewpager);
        pagerIndicator = findViewById(R.id.pagerIndicator);
        myScrollView = findViewById(R.id.scrollview_jingdong);
        myScrollView.setOnScrollListener(this);
        ll_rootview = findViewById(R.id.ll_rootview);
        ll_dalei = findViewById(R.id.ll_dalei);
        ll_leibie1 = findViewById(R.id.ll_leibie1);
        ll_leibie2 = findViewById(R.id.ll_leibie2);
        ll_dalei3 = findViewById(R.id.ll_dalei3);

    }

    private void initData(){
        initBanner();
        initViewPager();

    }

    private void initBanner(){
        imageUrls = Arrays.asList(Images.imageJingdongUrls1);
        imageJingdongUrls = Arrays.asList(Images.imageJingdongUrls2);
        banner.setBannerAdapter(new BannerAdapter<String>(imageUrls) {
            @Override
            protected void bindTips(TextView tv, String strings) {

            }

            @Override
            public void bindImage(ImageView imageView, String strings) {
                Glide.with(JingdongHomeActivity.this).load(strings).into(imageView);
            }
        });
        banner.notifyDataHasChanged();

        banner2.setBannerAdapter(new BannerAdapter<String>(imageJingdongUrls) {
            @Override
            protected void bindTips(TextView tv, String strings) {

            }

            @Override
            public void bindImage(ImageView imageView, String strings) {
                Glide.with(JingdongHomeActivity.this).load(strings).into(imageView);
            }
        });
        banner2.notifyDataHasChanged();
    }

    private void initViewPager(){
        int length = pagerIndicator.getTabCount();
        List<View> views = new ArrayList<View>(length);
        for (int i = 0 ;i < length;i ++){
            pageView = getLayoutInflater().inflate(Layout,null);
            MyGridView gridView = pageView.findViewById(R.id.content_viewpager);
            adapter = new GridviewAdapter(this,0,Images.imageThumbUrls,gridView);
            gridView.setAdapter(adapter);
            gridView.setFocusable(false);
            views.add(pageView);
        }
        viewPager.setAdapter(new ViewPagerAdapter(views));
        pagerIndicator.setViewPager(viewPager);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (banner != null) {
            banner.pauseScroll();
            banner.removeAllViews();
            banner = null;
        }

        if (banner2 != null) {
            banner2.pauseScroll();
            banner2.removeAllViews();
            banner2 = null;
        }

        if (adapter != null){
            adapter.cancle();
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){
            topHeight = banner2.getBottom();
        }
    }

    @Override
    public void onScroll(int scrollY) {
        LogUtil.e(TAG,"滑动距离:" + scrollY + ",topHeight : " + topHeight);
        if (scrollY >= topHeight){
            LogUtil.e(TAG,"pagerIndicator.getParent() : " +pagerIndicator.getParent());
            if (pagerIndicator.getParent() == ll_dalei){
                ll_dalei3.removeView(pagerIndicator);
                ll_dalei.removeAllViews();
                banner.setVisibility(View.GONE);
                banner2.setVisibility(View.GONE);
                ll_leibie1.setVisibility(View.GONE);
                ll_leibie2.setVisibility(View.GONE);
                ll_dalei.setVisibility(View.GONE);
                ll_dalei3.addView(pagerIndicator,0);
                ll_rootview.addView(viewPager);
            }
        }else {
            if (pagerIndicator.getParent() == ll_dalei3){
                ll_dalei3.removeView(pagerIndicator);
                ll_rootview.removeView(viewPager);
                ll_dalei.removeAllViews();
                banner.setVisibility(View.VISIBLE);
                banner2.setVisibility(View.VISIBLE);
                ll_leibie1.setVisibility(View.VISIBLE);
                ll_leibie2.setVisibility(View.VISIBLE);
                ll_dalei.setVisibility(View.VISIBLE);
                ll_dalei.addView(pagerIndicator);
                ll_dalei.addView(viewPager);
            }
        }
    }
}
