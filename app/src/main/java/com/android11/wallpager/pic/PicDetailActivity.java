package com.android11.wallpager.pic;


import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.android11.wallpager.R;
import com.android11.wallpager.home.adapter.PhotoListAdapter;
import com.android11.wallpager.main.BaseActivity;
import com.android11.wallpager.pic.bean.PicDetailBean;
import com.android11.wallpager.pic.iviews.IGetPhotoDetailView;
import com.android11.wallpager.pic.presenter.GetPhotoDetailPresenter;
import com.android11.wallpager.utils.Tools;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.jaeger.library.StatusBarUtil;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.io.File;
import java.util.concurrent.ExecutionException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;


public class PicDetailActivity extends BaseActivity implements IGetPhotoDetailView {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.iv_top)
    ImageView ivTop;
    @BindView(R.id.main_abl_app_bar)
    AppBarLayout appBar;
    @BindView(R.id.iv_head)
    CircleImageView ivHead;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_load_photo)
    TextView tvLoadPhoto;
    @BindView(R.id.tv_share)
    TextView tvShare;
    @BindView(R.id.tv_set_phone_page)
    TextView tvSetPhonePage;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_attr_size)
    TextView tvAttrSize;
    @BindView(R.id.tv_attr_exposure)
    TextView tvAttrExposure;
    @BindView(R.id.tv_attr_aperture)
    TextView tvAttrAperture;
    @BindView(R.id.tv_attr_focal)
    TextView tvAttrFocal;
    @BindView(R.id.tv_attr_model)
    TextView tvAttrModel;
    @BindView(R.id.tv_attr_iso)
    TextView tvAttrIso;
    @BindView(R.id.divide)
    View divide;
    @BindView(R.id.tv_attr_loaction)
    TextView tvAttrLoaction;
    @BindView(R.id.ctl_top)
    CollapsingToolbarLayout ctlTop;
    @BindView(R.id.tvheader)
    TextView tvheader;
    @BindView(R.id.tvfooter)
    TextView tvfooter;

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
        Glide.with(this)
                .load(getIntent()
                        .getStringExtra("url"))
                .apply(new RequestOptions().centerCrop())
                .into(ivTop);
        Glide.with(this)
                .load(getIntent().getStringExtra("headurl"))
                .apply(new RequestOptions().placeholder(R.drawable.default_avatar_round)
                        .dontAnimate())
                .into(ivHead);
        RefreshLayout refreshLayout = findViewById(R.id.refreshLayout);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                onBackPressed();
            }
        });
        refreshLayout.setEnableAutoLoadMore(false);

        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                onBackPressed();
            }
        });
        refreshLayout.setOnMultiPurposeListener(new OnMultiPurposeListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {

            }

            @Override
            public void onHeaderPulling(RefreshHeader header, float percent, int offset, int headerHeight, int extendHeight) {

            }

            @Override
            public void onHeaderReleased(RefreshHeader header, int headerHeight, int extendHeight) {

            }

            @Override
            public void onHeaderReleasing(RefreshHeader header, float percent, int offset, int headerHeight, int extendHeight) {

            }

            @Override
            public void onHeaderStartAnimator(RefreshHeader header, int headerHeight, int extendHeight) {

            }

            @Override
            public void onHeaderFinish(RefreshHeader header, boolean success) {

            }

            @Override
            public void onFooterPulling(RefreshFooter footer, float percent, int offset, int footerHeight, int extendHeight) {

            }

            @Override
            public void onFooterReleased(RefreshFooter footer, int footerHeight, int extendHeight) {

            }

            @Override
            public void onFooterReleasing(RefreshFooter footer, float percent, int offset, int footerHeight, int extendHeight) {

            }

            @Override
            public void onFooterStartAnimator(RefreshFooter footer, int footerHeight, int extendHeight) {

            }

            @Override
            public void onFooterFinish(RefreshFooter footer, boolean success) {

            }


            @Override
            public void onRefresh(RefreshLayout refreshlayout) {

            }

            @Override
            public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {
                if (newState == RefreshState.PullDownToRefresh) {
                    tvheader.setText("下拉关闭页面");
                }
                if (newState == RefreshState.ReleaseToRefresh) {
                    tvheader.setText("松开关闭页面");
                }
                if (newState == RefreshState.PullUpToLoad) {
                    tvfooter.setText("上拉关闭页面");
                }
                if (newState == RefreshState.ReleaseToLoad) {
                    tvfooter.setText("松开关闭页面");
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pic_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.share:
                if (bean == null || TextUtils.isEmpty(localUrl)) {
                    Tools.toastInBottom(this, "正在加载请稍后分享");
                }
                Tools.shareMsg(mContext, getString(R.string.app_name),
                        "发现美图", bean.getUser().getName(), localUrl);
                return true;
        }
        return super.onOptionsItemSelected(item);
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

        int sw = Tools.getScreenW(this);
        Double rate = getIntent().getIntExtra("h", 1000) * 1.0 / getIntent().getIntExtra("w", 600);
        int h = (int) (sw * rate);
        CollapsingToolbarLayout.LayoutParams params = (CollapsingToolbarLayout.LayoutParams) ivTop.getLayoutParams();
        params.height = h;
        ivTop.setLayoutParams(params);

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
        if (getIntent().getIntExtra("h", -1) == -1) {
            int sw = Tools.getScreenW(this);
            Double rate = getIntent().getIntExtra("h", 1000) * 1.0 / getIntent().getIntExtra("w", 600);
            int h = (int) (sw * rate);
            CollapsingToolbarLayout.LayoutParams params = (CollapsingToolbarLayout.LayoutParams) ivTop.getLayoutParams();
            params.height = h;
            ivTop.setLayoutParams(params);
        }



        Glide.with(this.getApplicationContext()).load(bean.getUser().getProfile_image().getLarge())
                .apply(new RequestOptions().placeholder(R.drawable.default_avatar_round).dontAnimate()).into(ivHead);
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

    @OnClick({R.id.iv_head, R.id.iv_top, R.id.tv_load_photo, R.id.tv_share, R.id.tv_set_phone_page})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_top:
                Intent gobig = new Intent(this, BigPicActivity.class);
                if (!TextUtils.isEmpty(localUrl)) {
                    gobig.putExtra("url", localUrl);
                } else {
                    gobig.putExtra("url", getIntent().getStringExtra("url"));
                }


                startActivity(gobig);
                overridePendingTransition(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                break;
            case R.id.tv_load_photo:
                if (bean == null)
                    return;
                Tools.downloadImage(mContext, getIntent().getStringExtra("url"), bean.getId());
//                dialog = new MaterialDialog.Builder(this)
//                        .content("正在加载请稍等...")
//                        .show();
//                mHandler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        downWallPaper();
//                    }
//                }, 2000);
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
            case R.id.iv_head:
                if (bean == null)
                    break;
                Intent gouser = new Intent(this, UserPicListActivity.class);
                gouser.putExtra("name", bean.getUser().getUsername());
                startActivity(gouser);
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
            Tools.saveImageToGallery(mContext, bitmap, bean.getId());

        }
        dialog.dismiss();

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
