package com.example.pxwzoukao422.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pxwzoukao422.R;
import com.example.pxwzoukao422.bean.BannerBean;
import com.example.pxwzoukao422.bean.HomeBean;
import com.example.pxwzoukao422.bean.SqBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.List;

public class HomeAdapter extends XRecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<BannerBean.ResultBean> bannerBean;
    private List<HomeBean.ResultBean> list;
    private List<SqBean> sqBeans;

    private final static int ONR=0;
    private final static int TWO=1;

    public HomeAdapter(Context context, List<BannerBean.ResultBean> bannerBean, List<HomeBean.ResultBean> list, List<SqBean> sqBeans) {
        this.context = context;
        this.bannerBean = bannerBean;
        this.list = list;
        this.sqBeans = sqBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
          View view;
          if (i==ONR){
              view=LayoutInflater.from(context).inflate(R.layout.layout_banner,viewGroup,false);
              BannerHolder bannerHolder = new BannerHolder(view);
              return bannerHolder;
          }else{
              view=LayoutInflater.from(context).inflate(R.layout.layout_home_recycler,viewGroup,false);
              IViewHolder iViewHolder = new IViewHolder(view);
              return iViewHolder;
          }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

         if (list!=null||bannerBean!=null){
             if (getItemViewType(i)==ONR){
                 ((BannerHolder) viewHolder).xbanner.setData(bannerBean,null);
                 ((BannerHolder) viewHolder).xbanner.loadImage(new XBanner.XBannerAdapter() {
                     @Override
                     public void loadBanner(XBanner banner, Object model, View view, int position) {
                         Glide.with(context).load(bannerBean.get(position).getImageUrl()).into((ImageView) view);
                     }
                 });
                 ((BannerHolder) viewHolder).xbanner.setPageTransformer(Transformer.Default);
             }else{
                 LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                 ((IViewHolder) viewHolder).recycler.setLayoutManager(linearLayoutManager);
                 ItemAdapter itemAdapter = new ItemAdapter(context, list,null);
                 ((IViewHolder) viewHolder).recycler.setAdapter(itemAdapter);
             }
         }else {
             if (viewHolder instanceof IViewHolder){
                 LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                 ((IViewHolder) viewHolder).recycler.setLayoutManager(linearLayoutManager);
                 ItemAdapter itemAdapter = new ItemAdapter(context, null,sqBeans);
                 ((IViewHolder) viewHolder).recycler.setAdapter(itemAdapter);
             }
         }

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return ONR;
        }else if (position==1){
            return TWO;
        }
        return super.getItemViewType(position);
    }

    class BannerHolder extends RecyclerView.ViewHolder {
        private XBanner xbanner;
        public BannerHolder(@NonNull View itemView) {
            super(itemView);
           xbanner=itemView.findViewById(R.id.xbanner);
        }
    }

    class IViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView recycler;
        public IViewHolder(@NonNull View itemView) {
            super(itemView);
          recycler=itemView.findViewById(R.id.recyclersss);
        }
    }
}
