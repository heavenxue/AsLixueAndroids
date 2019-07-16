package com.aibei.lixue.lixueandroids.thirdframes.retrofitDemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * 作者：lixue on 2019/7/15 15:20
 */

public interface MyInterface {

    @GET(".../...") //相对url请求地址
    Call<List<MyResponse>> getCall();
}
