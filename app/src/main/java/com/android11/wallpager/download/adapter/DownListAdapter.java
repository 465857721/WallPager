package com.android11.wallpager.download.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android11.wallpager.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by yuxun on 2017/4/15.
 */

public class DownListAdapter extends RecyclerView.Adapter {
    private List<File> list;
    private Context mActivity;

    public DownListAdapter(List<File> list, Context mActivity) {
        this.list = list;
        this.mActivity = mActivity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OrderViewHolder(LayoutInflater.from(mActivity).inflate(R.layout.item_download, parent, false));

    }

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }


    private OnItemClickLitener mOnItemClickLitener;


    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public interface OndeleteClickLitener {
        void onDeleteClick(View view, int position);
    }


    private OndeleteClickLitener mOndeleteClickLitener;


    public void setOndeleteClickLitener(OndeleteClickLitener mOndeleteClickLitener) {
        this.mOndeleteClickLitener = mOndeleteClickLitener;
    }

    public interface OnDetailClickLitener {
        void onDetaiClick(View view, int position);
    }


    private OnDetailClickLitener mOnDetailClickLitener;


    public void setOnDetailClickLitener(OnDetailClickLitener mOnDetailClickLitener) {
        this.mOnDetailClickLitener = mOnDetailClickLitener;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final OrderViewHolder oholder = (OrderViewHolder) holder;
        File bean = list.get(position);
        Glide.with(mActivity).load(bean.getAbsoluteFile())
                .apply(new RequestOptions().centerCrop()).into(oholder.ivphoto);
        oholder.tvName.setText(bean.getName().replace("downpic_", "").replace(".jpg", ""));
        if (mOnItemClickLitener != null) {
            oholder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickLitener.onItemClick(v, position);
                }
            });
        }
        if (mOndeleteClickLitener != null) {
            oholder.ivDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOndeleteClickLitener.onDeleteClick(v, position);
                }
            });
        }
        if (mOnDetailClickLitener != null) {
            oholder.ivSearch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnDetailClickLitener.onDetaiClick(v, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class OrderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_search)
        ImageView ivSearch;
        @BindView(R.id.iv_photo)
        ImageView ivphoto;
        @BindView(R.id.iv_delete)
        ImageView ivDelete;
        @BindView(R.id.tv_name)
        TextView tvName;

        public OrderViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
