package com.aibei.lixue.lixueandroids.MVC;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：lixue on 2019/7/16 11:52
 */

public class SportsModelImpl implements SportsModel {
    @Override
    public void getSportsInfo(String cityNumber, OnSportsListener listener) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.resss.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Service service = retrofit.create(Service.class);
        Call<String> call = service.getMessage("北京");
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                listener.onSuccess();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                listener.onFailure();
            }
        });
    }
}
