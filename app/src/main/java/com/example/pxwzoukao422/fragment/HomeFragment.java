package com.example.pxwzoukao422.fragment;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pxwzoukao422.R;
import com.example.pxwzoukao422.adapter.HomeAdapter;
import com.example.pxwzoukao422.api.Api;
import com.example.pxwzoukao422.bean.BannerBean;
import com.example.pxwzoukao422.bean.HomeBean;
import com.example.pxwzoukao422.bean.SqBean;
import com.example.pxwzoukao422.content.UserContent;
import com.example.pxwzoukao422.persenter.UserPsersnter;
import com.example.pxwzoukao422.utils.GrennDaoUtils;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeFragment extends Fragment implements UserContent.showView ,XRecyclerView.LoadingListener{


    @BindView(R.id.recycler)
    XRecyclerView recycler;
    Unbinder unbinder;
    private UserPsersnter userPsersnter;
    private List<BannerBean.ResultBean> result;
    private HomeAdapter homeAdapter;
    private  int page=1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup
            container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_home_fragment, container, false);

        unbinder = ButterKnife.bind(this, view);

        initView();
        return view;
    }

    private void initView() {
         recycler.setLayoutManager(new LinearLayoutManager(getContext()));
         userPsersnter = new UserPsersnter(this);
         userPsersnter.showBanner(Api.BANNER,new HashMap<String, String>());
         userPsersnter.showHomes(Api.HOME,new HashMap<String, String>());
         recycler.setLoadingListener(this);
         recycler.setPullRefreshEnabled(true);
         recycler.setLoadingMoreEnabled(true);

         if (!iswork(getContext())){
             List<SqBean> sqBeans = GrennDaoUtils.getIntance().getDaoSession().loadAll(SqBean.class);
             homeAdapter = new HomeAdapter(getContext(), result,null,sqBeans);
             recycler.setAdapter(homeAdapter);
         }
    }


    @Override
    public void showBanner(BannerBean bannerBean) {
         result = bannerBean.getResult();
    }

    @Override
    public void showHome(HomeBean homeBean) {
        Log.e("TAF",homeBean.getResult()+"");
        homeAdapter = new HomeAdapter(getContext(), result, homeBean.getResult(),null);
        recycler.setAdapter(homeAdapter);

        for (HomeBean.ResultBean resultBean : homeBean.getResult()) {
            GrennDaoUtils.getIntance().getDaoSession().insertOrReplace(new SqBean(null,resultBean.getThumbnail(),resultBean.getTitle()));
        }
    }


    //判断网络
    public boolean iswork(Context context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = cm.getActiveNetworkInfo();
        return activeNetworkInfo!=null&&activeNetworkInfo.isAvailable();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        userPsersnter.vh();
    }

    @Override
    public void onRefresh() {
        page=1;
        recycler.refreshComplete();
    }

    @Override
    public void onLoadMore() {
       page++;
       recycler.loadMoreComplete();
        Toast.makeText(getContext(),"暂无数据",Toast.LENGTH_SHORT).show();
    }
}
