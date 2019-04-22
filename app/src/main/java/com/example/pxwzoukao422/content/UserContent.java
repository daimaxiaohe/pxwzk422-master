package com.example.pxwzoukao422.content;

import com.example.pxwzoukao422.bean.BannerBean;
import com.example.pxwzoukao422.bean.HomeBean;
import com.example.pxwzoukao422.callback.UserCallback;

import java.util.HashMap;

public interface UserContent {

    public abstract class showPersenter{
         public abstract void showBanner(String uri, HashMap<String,String> map);
        public abstract void showHomes(String uri, HashMap<String,String> map);
    }


    public interface  showModel{
        public void showBanner(String uri, HashMap<String,String> map, UserCallback callback);
        public void showHome(String uri, HashMap<String,String> map, UserCallback callback);
    }

    public interface  showView{
        void showBanner(BannerBean bannerBean);
        void showHome(HomeBean homeBean);
    }
}
