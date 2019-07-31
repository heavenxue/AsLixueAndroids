package com.aibei.lixue.lixueandroids.thirdframes.glideDemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.aibei.lixue.lixueandroids.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class GlideDemoActivity extends AppCompatActivity {
    private String url = "http://图片地址";
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_demo);
        imageView = findViewById(R.id.image_show);
    }

    private void httpCache(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(8, TimeUnit.SECONDS);
        builder.writeTimeout(8,TimeUnit.SECONDS);
        builder.readTimeout(8,TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(false);//设置不进行链接失败重试

    }

    public void loadImageSimple(View view){
        Glide.with(this).load(url).into(imageView);
    }

    private void loadImage(){
        Glide.with(getApplicationContext())//指定context
                .load(url)
                .placeholder(R.mipmap.ic_launcher)//指定图片未成功加载前显示的图片
                .error(R.mipmap.ic_launcher)//指定图片加载失败显示的图片
                .override(300,300)//制定图片的尺寸
                .fitCenter()//制定图片缩放类型,使图片小于等于imageview
                .centerCrop()//制定图片缩放类型为,让图片填充整个imageview，会裁剪imageview以外的地方
                .skipMemoryCache(true)//跳过内存缓存
                .crossFade(1000)//设置渐变式显示的时间
                .diskCacheStrategy(DiskCacheStrategy.NONE)//跳过磁盘缓存
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)//仅仅只缓存原来的全分辨率的图像
                .diskCacheStrategy(DiskCacheStrategy.RESULT)//仅仅缓存最终的图像
                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存所有版本的图像
                .priority(Priority.HIGH)//指定优先级Glide将会用他们作为一个准则，并尽可能的处理这些请求，但是
                .into(imageView);
    }

    private void cacheOkhttpRequest(){
        OkHttpClient client = new OkHttpClient.Builder()
                .cache(new Cache(new File("cache"),24*1024*1024)).build();
        Request request = new Request.Builder().url("http://www.baidu.com").build();
    }
}
