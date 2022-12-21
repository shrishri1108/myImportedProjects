package com.example.videoplayer.Client;

import com.example.videoplayer.Config.ApiConfig;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient retrofitClient;
    private static Retrofit retrofit;
    private static String BASE_URL="http://13.246.105.57/auth_api/";
    public static String token_id="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiNjM5MzMxZTBmY2FlMWU0ODBmMzAwMzhhIiwiaXNfdG9rZW5fdmFsaWRlIjoxLCJpYXQiOjE2NzA1OTA5NDR9.zZ_duk_PneFUaRz8y0RZi-oWcEJLJowuikw2mU40GoQ";

    public  RetrofitClient () {
        Gson gson= new Gson();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        retrofit= new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public static synchronized RetrofitClient getInstance() {
        if(retrofitClient ==null) {
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient;
    }

    public ApiConfig getMyApis () {
        return retrofit.create(ApiConfig.class);
    }

}
