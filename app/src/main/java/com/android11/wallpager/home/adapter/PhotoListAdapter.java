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
import com.android11.wallpager.home.bean.PhotoListBean;
import com.android11.wallpager.utils.SharePreferenceUtil;
import com.android11.wallpager.utils.Tools;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by yuxun on 2017/4/15.
 */

public class PhotoListAdapter extends RecyclerView.Adapter {
    private ArrayList<PhotoListBean> list;
    private Context mActivity;

    public PhotoListAdapter(ArrayList<PhotoListBean> list, Context mActivity) {
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
        final PhotoListBean bean = list.get(position);
        oholder.rlItem.setBackgroundColor(Color.parseColor(bean.getColor()));


        SharePreferenceUtil spu = Tools.getSpu(mActivity);
        // 是否高清模式
        if (spu.getHighQulit()) {
            Glide.with(mActivity).load(bean.getUrls().getRegular()).apply(new RequestOptions().centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL)).into(oholder.ivphoto);
        } else {
            Glide.with(mActivity).load(bean.getUrls().getSmall()).thumbnail(0.1f).apply(new RequestOptions().centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL)).into(oholder.ivphoto);
        }
        Glide.with(mActivity).load(bean.getUser().getProfile_image().getLarge()).apply(new RequestOptions().centerCrop().dontAnimate().diskCacheStrategy(DiskCacheStrategy.ALL)).into(oholder.ivHead);

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
        oholder.ivdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tools.downloadImage(mActivity, bean.getUrls().getRegular(), bean.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class OrderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_photo)
        ImageView ivphoto;
        @BindView(R.id.iv_down)
        ImageView ivdown;

        @BindView(R.id.tv_name)
        TextView tvname;
        @BindView(R.id.tv_des)
        TextView tvdes;
        @BindView(R.id.rl_item)
        RelativeLayout rlItem;
        @BindView(R.id.iv_head)
        CircleImageView ivHead;

        public OrderViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
