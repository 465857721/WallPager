package com.android11.wallpager.pic;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.android11.wallpager.R;
import com.android11.wallpager.main.BaseActivity;
import com.android11.wallpager.pic.bean.PicDetailBean;
import com.android11.wallpager.pic.iviews.IGetPhotoDetailView;
import com.android11.wallpager.pic.presenter.GetPhotoDetailPresenter;
import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;


public class PicDetailActivity extends BaseActivity implements IGetPhotoDetailView {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.iv_top)
    ImageView ivTop;
    @Bind(R.id.main_abl_app_bar)
    AppBarLayout appBar;

    private GetPhotoDetailPresenter getPhotoDetailPresenter;
    private PicDetailBean bean;
    private Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picdetail);
        ButterKnife.bind(this);
        mContext = this;
        initViw();
//        getPhotoDetailPresenter = new GetPhotoDetailPresenter(this);
//        getPhotoDetailPresenter.getPhoto();

        Glide.with(this).load(getIntent().getStringExtra("url")).centerCrop().into(ivTop);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void initViw() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }


    @Override
    public String getPhotoID() {
        return getIntent().getStringExtra("id");
    }

    @Override
    public void onGetPhoteDetail(PicDetailBean bean) {
        this.bean = bean;
        // 是否高清模式
        if (spu.getHighQulit()) {
            Glide.with(this).load(bean.getUrls().getRegular()).centerCrop().into(ivTop);
        } else {
            Glide.with(this).load(bean.getUrls().getSmall()).centerCrop().into(ivTop);
        }

    }
}
