package com.aibei.lixue.lixueandroids.samples.jingdongHome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.aibei.lixue.lixueandroids.R;
import com.aibei.lixue.lixueandroids.samples.pictures.Images;
import com.aibei.lixue.lixuelib.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

public class JingdongHome2Activity extends AppCompatActivity implements MyScrollView.OnScrollListener {
    private static final String TAG = "JingdongHomeActivity";

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
        setContentView(R.layout.activity_jingdong_home2);
        initView();
        initData();
    }

    private void  initView(){
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
        initViewPager();

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
        if (adapter != null){
            adapter.cancle();
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    public void onScroll(int scrollY) {
        LogUtil.e(TAG,"滑动距离:" + scrollY + ",topHeight : " + topHeight);
    }
}
