package com.example.pxwzoukao422.api;

import com.example.pxwzoukao422.bean.BannerBean;
import com.example.pxwzoukao422.bean.HomeBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface UserApi {

     @GET
     Call<BannerBean> showBanners(@Url String uri, @QueryMap HashMap<String,String> map);

    @GET
     Call<HomeBean> showHOmes(@Url String uri, @QueryMap HashMap<String,String> map);
}
