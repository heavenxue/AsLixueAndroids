package com.aibei.lixue.lixueandroids.thirdframes.retrofitDemo;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：lixue on 2019/7/15 10:40
 */

public class RetrofitS {
    public void MyRetrofit() throws IOException {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("")//设置网络请求的url地址，必须以“/”结尾
                .addConverterFactory(GsonConverterFactory.create())//设置数据解析器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//支持RxJava平台
                .build();

        MyInterface myInterface = retrofit.create(MyInterface.class);
        Call call = myInterface.getCall(); //通过动态代理利用okhttpcall来执行真正的执行网络请求
        call.execute();
        call.enqueue(new retrofit2.Callback(){

            @Override
            public void onResponse(Call call, Response response) {
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
