package com.aibei.lixue.lixueandroids.MVC;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 作者：lixue on 2019/7/16 11:54
 */

public interface Service {
    @GET("service_info")
    Call<String> getMessage(@Query("info") String info);
}
