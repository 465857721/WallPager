package com.android11.wallpager.pic;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android11.wallpager.R;
import com.android11.wallpager.main.BaseActivity;
import com.android11.wallpager.pic.bean.PicDetailBean;
import com.android11.wallpager.pic.iviews.IGetPhotoDetailView;
import com.android11.wallpager.pic.presenter.GetPhotoDetailPresenter;
import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;


public class PicDetailActivity extends BaseActivity implements IGetPhotoDetailView {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.iv_top)
    ImageView ivTop;
    @Bind(R.id.main_abl_app_bar)
    AppBarLayout appBar;
    @Bind(R.id.iv_head)
    CircleImageView ivHead;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_load_photo)
    TextView tvLoadPhoto;
    @Bind(R.id.tv_share)
    TextView tvShare;
    @Bind(R.id.tv_set_phone_page)
    TextView tvSetPhonePage;
    @Bind(R.id.tv_time)
    TextView tvTime;
    @Bind(R.id.tv_attr_size)
    TextView tvAttrSize;
    @Bind(R.id.tv_attr_exposure)
    TextView tvAttrExposure;
    @Bind(R.id.tv_attr_aperture)
    TextView tvAttrAperture;
    @Bind(R.id.tv_attr_focal)
    TextView tvAttrFocal;
    @Bind(R.id.tv_attr_model)
    TextView tvAttrModel;
    @Bind(R.id.tv_attr_iso)
    TextView tvAttrIso;
    @Bind(R.id.divide)
    View divide;
    @Bind(R.id.tv_attr_loaction)
    TextView tvAttrLoaction;

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
        getPhotoDetailPresenter = new GetPhotoDetailPresenter(this);
        getPhotoDetailPresenter.getPhoto();

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
//        if (spu.getHighQulit()) {
//            Glide.with(this).load(bean.getUrls().getRegular()).centerCrop().into(ivTop);
//        } else {
//            Glide.with(this).load(bean.getUrls().getSmall()).centerCrop().into(ivTop);
//        }
        Glide.with(this).load(bean.getUser().getProfile_image().getLarge()).into(ivHead);
        tvName.setText(bean.getUser().getName());


        tvTime.setText("拍摄于 " + bean.getCreated_at().split("T")[0]);
        tvAttrSize.setText("分辨率：" + bean.getWidth() + " x " + bean.getHeight());
        tvAttrExposure.setText("快门：" + bean.getExif().getExposure_time());
        tvAttrAperture.setText("光圈：" + bean.getExif().getAperture());//光圈
        tvAttrFocal.setText("焦距：" + bean.getExif().getFocal_length());
        tvAttrModel.setText("器材：" + bean.getExif().getModel());
        tvAttrIso.setText("感光度：" + bean.getExif().getIso() + "");
        if (bean.getLocation() != null)
            tvAttrLoaction.setText("拍摄地：" + bean.getLocation().getName());
    }

    @OnClick({R.id.tv_load_photo, R.id.tv_share, R.id.tv_set_phone_page})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_load_photo:
                break;
            case R.id.tv_share:
                break;
            case R.id.tv_set_phone_page:
                break;
        }
    }
}
