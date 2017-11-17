package com.android11.wallpager.pic;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android11.wallpager.R;
import com.android11.wallpager.main.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.xiaopan.sketch.SketchImageView;
import me.xiaopan.sketch.request.DownloadProgressListener;


public class BigPicActivity extends BaseActivity {


    @BindView(R.id.iv)
    SketchImageView iv;
    @BindView(R.id.tv_progress)
    TextView tvProgress;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bigpic);
        ButterKnife.bind(this);
        initViw();
    }

    @Override
    protected void setStatusBar() {
//        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.black));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(android.R.anim.fade_in,
                android.R.anim.fade_out);
    }

    private void initViw() {
        iv.setZoomEnabled(true);
        iv.setDownloadProgressListener(new DownloadProgressListener() {
            @Override
            public void onUpdateDownloadProgress(int totalLength, int completedLength) {
                int pro = completedLength * 100 / totalLength;
                Log.d("zk pro = ", "" + pro);
                tvProgress.setText(pro + " %");
                if (pro == 100)
                    tvProgress.setVisibility(View.GONE);
            }
        });
        iv.displayImage(getIntent().getStringExtra("url"));
    }

    @OnClick(R.id.iv)
    public void onViewClicked() {
        onBackPressed();
    }
}
