package com.android11.wallpager.home.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android11.wallpager.R;
import com.android11.wallpager.home.bean.CollectionBean;
import com.android11.wallpager.home.bean.PhotoListBean;
import com.android11.wallpager.utils.SharePreferenceUtil;
import com.android11.wallpager.utils.Tools;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by yuxun on 2017/4/15.
 */

public class CollectionListAdapter extends RecyclerView.Adapter {
    private ArrayList<CollectionBean> list;
    private Context mActivity;

    public CollectionListAdapter(ArrayList<CollectionBean> list, Context mActivity) {
        this.list = list;
        this.mActivity = mActivity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OrderViewHolder(LayoutInflater.from(mActivity).inflate(R.layout.item_photos, parent, false));

    }

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }


    private OnItemClickLitener mOnItemClickLitener;


    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final OrderViewHolder oholder = (OrderViewHolder) holder;
        CollectionBean bean = list.get(position);
        oholder.rlItem.setBackgroundColor(Color.parseColor(bean.getCover_photo().getColor()));


        SharePreferenceUtil spu = Tools.getSpu(mActivity);
        // 是否高清模式
        if (spu.getHighQulit()) {
            Glide.with(mActivity).load(bean.getCover_photo().getUrls().getRegular()).thumbnail(0.1f).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(oholder.ivphoto);
        } else {
            Glide.with(mActivity).load(bean.getCover_photo().getUrls().getSmall()) .thumbnail(0.1f).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(oholder.ivphoto);
        }

        oholder.tvname.setText(bean.getUser().getName());
        if (TextUtils.isEmpty(bean.getDescription())) {
            oholder.tvdes.setVisibility(View.GONE);
        } else {
            oholder.tvdes.setVisibility(View.VISIBLE);
            oholder.tvdes.setText(bean.getDescription());
        }
        if (mOnItemClickLitener != null) {
            oholder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickLitener.onItemClick(v, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class OrderViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_photo)
        ImageView ivphoto;

        @Bind(R.id.tv_name)
        TextView tvname;
        @Bind(R.id.tv_des)
        TextView tvdes;
        @Bind(R.id.rl_item)
        RelativeLayout rlItem;
        public OrderViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}