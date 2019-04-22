package com.example.pxwzoukao422.utils;

import com.example.pxwzoukao422.api.Api;
import com.example.pxwzoukao422.api.UserApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;

public class RetrfitUtils {

      public static volatile RetrfitUtils mInstance;
     private final Retrofit retrofit;

    private RetrfitUtils(){
          HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
          interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
          OkHttpClient okHttpClient = new OkHttpClient.Builder()
                  .addInterceptor(interceptor)
                  .addNetworkInterceptor(interceptor)
                  .build();


        retrofit = new Retrofit.Builder()
                .baseUrl(Api.PAHT)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
      }

      //双重检验锁
    public static RetrfitUtils getmInstance() {
        if (mInstance == null) {
            synchronized (RetrfitUtils.class){
                if (mInstance == null) {
                    mInstance=new RetrfitUtils();
                }
            }

        }
        return mInstance;
    }

    public UserApi showApi(){
        return retrofit.create(UserApi.class);
    }
}
