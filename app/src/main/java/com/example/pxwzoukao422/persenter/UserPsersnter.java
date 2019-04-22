package com.example.pxwzoukao422.persenter;

import com.example.pxwzoukao422.bean.BannerBean;
import com.example.pxwzoukao422.bean.HomeBean;
import com.example.pxwzoukao422.callback.UserCallback;
import com.example.pxwzoukao422.content.UserContent;
import com.example.pxwzoukao422.model.UserModel;

import java.util.HashMap;

public class UserPsersnter extends UserContent.showPersenter {

    private UserContent.showView view;
    private UserModel model;

    public UserPsersnter(UserContent.showView view) {
        this.view = view;
        model=new UserModel();
    }

    @Override
    public void showBanner(String uri, HashMap<String, String> map) {
         model.showBanner(uri, map, new UserCallback() {
             @Override
             public void success(Object o) {
                  if (view!=null){
                      BannerBean bannerBean= (BannerBean) o;
                      view.showBanner(bannerBean);
                  }
             }

             @Override
             public void defaeter(String error) {

             }
         });
    }

    @Override
    public void showHomes(String uri, HashMap<String, String> map) {
         model.showHome(uri, map, new UserCallback() {
             @Override
             public void success(Object o) {
                   if (view!=null){
                       HomeBean homeBean= (HomeBean) o;
                       view.showHome(homeBean);
                   }
             }

             @Override
             public void defaeter(String error) {

             }
         });
    }

    public void vh(){
        if (view!=null){
            view=null;
        }
    }
}
