package com.example.pxwzoukao422.model;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.pxwzoukao422.api.UserApi;
import com.example.pxwzoukao422.bean.BannerBean;
import com.example.pxwzoukao422.bean.HomeBean;
import com.example.pxwzoukao422.callback.UserCallback;
import com.example.pxwzoukao422.content.UserContent;
import com.example.pxwzoukao422.utils.RetrfitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserModel implements UserContent.showModel {


    @Override
    public void showBanner(String uri, HashMap<String, String> map, final UserCallback callback) {
        UserApi userApi = RetrfitUtils.getmInstance().showApi();
        userApi.showBanners(uri, map)
                .enqueue(new Callback<BannerBean>() {
                    @Override
                    public void onResponse(Call<BannerBean> call, Response<BannerBean> response) {
                        BannerBean body = response.body();
                        if (callback!=null){
                            callback.success(body);
                        }
                    }

                    @Override
                    public void onFailure(Call<BannerBean> call, Throwable t) {
                            if (callback!=null){
                                callback.defaeter(t.getMessage());
                            }
                    }
                });

    }


    @Override
    public void showHome(String uri, HashMap<String, String> map, final UserCallback callback) {
        UserApi userApi = RetrfitUtils.getmInstance().showApi();
        userApi.showHOmes(uri, map)
                .enqueue(new Callback<HomeBean>() {
                    @Override
                    public void onResponse(Call<HomeBean> call, Response<HomeBean> response) {
                        HomeBean body = response.body();
                        if (callback!=null){
                            callback.success(body);
                        }
                    }

                    @Override
                    public void onFailure(Call<HomeBean> call, Throwable t) {
                        if (callback!=null){
                            callback.defaeter(t.getMessage());
                        }
                    }
                });

    }
}
