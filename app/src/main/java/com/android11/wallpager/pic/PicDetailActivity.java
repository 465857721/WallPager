package com.android11.wallpager.pic;


import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.android11.wallpager.R;
import com.android11.wallpager.main.BaseActivity;
import com.android11.wallpager.pic.bean.PicDetailBean;
import com.android11.wallpager.pic.iviews.IGetPhotoDetailView;
import com.android11.wallpager.pic.presenter.GetPhotoDetailPresenter;
import com.android11.wallpager.utils.Tools;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.target.Target;
import com.jaeger.library.StatusBarUtil;

import java.io.File;
import java.util.concurrent.ExecutionException;

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
    @Bind(R.id.ctl_top)
    CollapsingToolbarLayout ctlTop;

    private GetPhotoDetailPresenter getPhotoDetailPresenter;
    private PicDetailBean bean;
    private Context mContext;
    private Handler mHandler;
    private String localUrl;
    private MaterialDialog dialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picdetail);
        mHandler = new Handler();
        ButterKnife.bind(this);
        mContext = this;
        initViw();
        getPhotoDetailPresenter = new GetPhotoDetailPresenter(this);
        getPhotoDetailPresenter.getPhoto();
        getLocalURrl();
        if (!TextUtils.isEmpty(getIntent().getStringExtra("color")))
            ctlTop.setBackgroundColor(Color.parseColor(getIntent().getStringExtra("color")));
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
    public void onGetPhoteDetail(final PicDetailBean bean) {
        this.bean = bean;
        // 是否高清模式
//        if (spu.getHighQulit()) {
//            Glide.with(this).load(bean.getUrls().getRegular()).centerCrop().into(ivTop);
//        } else {
//            Glide.with(this).load(bean.getUrls().getSmall()).centerCrop().into(ivTop);
//        }
        Glide.with(this.getApplicationContext()).load(bean.getUser().getProfile_image().getLarge())
                .placeholder(R.drawable.default_avatar_round).dontAnimate().into(ivHead);
        tvName.setText(bean.getUser().getName());


        tvTime.setText("拍摄于 " + bean.getCreated_at().split("T")[0]);
        tvAttrSize.setText("分辨率：" + bean.getWidth() + " x " + bean.getHeight());

        if (!TextUtils.isEmpty(bean.getExif().getExposure_time()))
            tvAttrExposure.setText("快门：" + bean.getExif().getExposure_time());
        if (!TextUtils.isEmpty(bean.getExif().getAperture()))
            tvAttrAperture.setText("光圈：" + bean.getExif().getAperture());//光圈
        if (!TextUtils.isEmpty(bean.getExif().getFocal_length()))
            tvAttrFocal.setText("焦距：" + bean.getExif().getFocal_length());
        if (!TextUtils.isEmpty(bean.getExif().getModel()))
            tvAttrModel.setText("器材：" + bean.getExif().getModel());
        if (!TextUtils.isEmpty(bean.getExif().getIso()))
            tvAttrIso.setText("感光度：" + bean.getExif().getIso());
        if (bean.getLocation() != null && !TextUtils.isEmpty(bean.getLocation().getName()))
            tvAttrLoaction.setText("拍摄地：" + bean.getLocation().getName());


    }

    @OnClick({R.id.tv_load_photo, R.id.tv_share, R.id.tv_set_phone_page})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_load_photo:
                downWallPaper();
                break;
            case R.id.tv_share:
                Tools.shareMsg(mContext, getString(R.string.app_name),
                        "发现美图", bean.getUser().getName(), localUrl);
                break;
            case R.id.tv_set_phone_page:
                dialog = new MaterialDialog.Builder(this)
                        .content("正在设置壁纸请稍等...")
                        .show();
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        setWallPaper();
                    }
                }, 2000);

                break;
        }
    }

    @Override
    protected void setStatusBar() {
//        super.setStatusBar();
//        StatusBarUtil.setTranslucentForImageView(this, 255, ivTop);
        StatusBarUtil.setTranslucent(this, 255);
    }

    //设置壁纸
    public void setWallPaper() {


        try {
            Bitmap bitmap = BitmapFactory.decodeFile(localUrl);
            WallpaperManager mWallManager = WallpaperManager.getInstance(this);
            mWallManager.setBitmap(bitmap);
            Tools.toastInBottom(this, "设置成功");
            dialog.dismiss();
        } catch (Exception e) {
            Tools.toastInBottom(this, "设置失败");
            dialog.dismiss();
            e.printStackTrace();

        }
    }

    //下载壁纸
    public void downWallPaper() {
        Bitmap bitmap = BitmapFactory.decodeFile(localUrl);
        if (bitmap != null) {
            // 在这里执行图片保存方法
            Tools.saveImageToGallery(mContext, bitmap);
        }

    }

    private void getLocalURrl() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                FutureTarget<File> future = Glide.with(mContext)
                        .load(getIntent().getStringExtra("url"))
                        .downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
                try {
                    File cacheFile = future.get();
                    localUrl = cacheFile.getAbsolutePath();
                    Log.d("zk path = ", localUrl);
//                    mHandler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            Bitmap bitmap = BitmapFactory.decodeFile(localUrl);
//                            ivTop.setImageBitmap(bitmap);
//                        }
//                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
