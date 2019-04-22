package com.example.pxwzoukao422.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pxwzoukao422.R;
import com.example.pxwzoukao422.bean.HomeBean;
import com.example.pxwzoukao422.bean.SqBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.IViewHolder> {

    private Context context;
    private List<HomeBean.ResultBean> list;
    private List<SqBean> sqBeans;

    public ItemAdapter(Context context, List<HomeBean.ResultBean> list, List<SqBean> sqBeans) {
        this.context = context;
        this.list = list;
        this.sqBeans = sqBeans;
    }

    @NonNull
    @Override
    public IViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.layout_home_item,viewGroup,false);
        IViewHolder iViewHolder = new IViewHolder(view);
        return iViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull IViewHolder iViewHolder, int i) {
        if (list!=null&&list.size()>0){
            if (list.get(i).getThumbnail()!=null){
                iViewHolder.item_img.setImageURI(list.get(i).getThumbnail());
            }
            iViewHolder.item_text.setText(list.get(i).getTitle());
        }else {
            Uri parse = Uri.parse(sqBeans.get(i).getImage());
            iViewHolder.item_img.setImageURI(parse);
            iViewHolder.item_text.setText(sqBeans.get(i).getName());
        }

    }

    @Override
    public int getItemCount() {
        if (list!=null&&list.size()>0){
            return list.size();
        }else {
            return sqBeans.size();
        }

    }

    public class IViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView item_img;
        private TextView item_text;
        public IViewHolder(@NonNull View itemView) {
            super(itemView);
            item_img=itemView.findViewById(R.id.item_img);
            item_text=itemView.findViewById(R.id.item_text);
        }
    }
}
