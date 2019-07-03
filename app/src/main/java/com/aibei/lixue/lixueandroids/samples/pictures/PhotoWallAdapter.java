package com.aibei.lixue.lixueandroids.samples.pictures;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.aibei.lixue.lixueandroids.R;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 作者：lixue on 2019/7/3 16:46
 */

public class PhotoWallAdapter extends ArrayAdapter<String> implements AbsListView.OnScrollListener {

    private GridView mGridView;
    private String[] imageUrls;
    private int firstVisibleItem;//第一张可见图片的下标
    private int visibleItemCount;//一屏有多少张可见
    private boolean isFirstEnter = true; //记录是否刚打开程序，用于解决进入程序不滚动屏幕，不会下载图片的问题
    private LruCache<String,Bitmap> mMemoryCache;
    private OkHttpClient okHttpClient;
    private ExecutorService executorService;


    public PhotoWallAdapter(Context context, int textViewResouceId,String[] imageUrls,GridView photowall) {
        super(context,textViewResouceId,imageUrls);
        this.imageUrls = imageUrls;
        mGridView = photowall;
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int cacheSize = maxMemory / 8;
        mMemoryCache = new LruCache<String,Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount();
            }
        };
        mGridView.setOnScrollListener(this);
         okHttpClient = new OkHttpClient();
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        // 仅当GridView静止时才去下载图片，GridView滑动时取消所有正在下载的任务
        if (scrollState == SCROLL_STATE_IDLE) {
            loadBitmaps(firstVisibleItem, visibleItemCount);
        } else {
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.firstVisibleItem = firstVisibleItem;
        this.visibleItemCount = visibleItemCount;
        // 下载的任务应该由onScrollStateChanged里调用，但首次进入程序时onScrollStateChanged并不会调用，
        // 因此在这里为首次进入程序开启下载任务。
        if (isFirstEnter && visibleItemCount > 0) {
            loadBitmaps(firstVisibleItem, visibleItemCount);
            isFirstEnter = false;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final String url = getItem(position);
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.photo_layout, null);
        } else {
            view = convertView;
        }
        final ImageView photo = view.findViewById(R.id.photo);
        // 给ImageView设置一个Tag，保证异步加载图片时不会乱序
        photo.setTag(url);
        setImageView(url, photo);
        return view;
    }

    private void setImageView(String imageUrl, ImageView imageView) {
        Bitmap bitmap = getBitmapFromMemoryCache(imageUrl);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
            imageView.setImageResource(R.mipmap.empty_photo);
        }
    }

    private void loadBitmaps(int firstVisibleItem,int visibleItemCount){
        for (int i = firstVisibleItem;i < firstVisibleItem + visibleItemCount;i ++){
            final String imageUrl = imageUrls[i];
            final Bitmap bitmap = getBitmapFromMemoryCache(imageUrl);
            if (bitmap == null){
                if (executorService == null)
                    executorService = Executors.newFixedThreadPool(5);
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
//                       new Thread(new Runnable() {
//                           @Override
//                           public void run() {
                               try {
                                   Request request = new Request.Builder()
                                           .url(imageUrl)
                                           .build();
                                   Response response = null;
                                   response = okHttpClient.newCall(request).execute();
                                   InputStream inputStream = response.body().byteStream();
                                   Bitmap theBitmap = BitmapFactory.decodeStream(inputStream);
                                   if (theBitmap != null){
                                       addBitmapToMemoryCache(imageUrl,theBitmap);
                                   }
                               } catch (IOException e) {
                                   e.printStackTrace();
                               }
//                           }
//                       }).start();
                    }
                });

            }else {
                ImageView imageView = (ImageView) mGridView.findViewWithTag(imageUrl);
                if (imageView != null && bitmap != null) {
                    imageView.setImageBitmap(bitmap);
                }
            }
        }

    }

    /**
     * 将一张图片存储到LruCache中。
     *
     * @param key
     *            LruCache的键，这里传入图片的URL地址。
     * @param bitmap
     *            LruCache的键，这里传入从网络上下载的Bitmap对象。
     */
    public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        if (getBitmapFromMemoryCache(key) == null) {
            mMemoryCache.put(key, bitmap);
        }
    }

    /**
     * 从LruCache中获取一张图片，如果不存在就返回null。
     *
     * @param key
     *            LruCache的键，这里传入图片的URL地址。
     * @return 对应传入键的Bitmap对象，或者null。
     */
    public Bitmap getBitmapFromMemoryCache(String key) {
        return mMemoryCache.get(key);
    }

    public void cancle(){
        if (executorService != null)
            executorService.shutdown();
    }
}
