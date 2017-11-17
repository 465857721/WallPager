package com.android11.wallpager.about;


import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.android11.wallpager.R;
import com.android11.wallpager.main.BaseActivity;
import com.android11.wallpager.utils.Tools;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AboutActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tv_version)
    TextView tvVersion;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        initViw();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void initViw() {
//        mToolbar.setNavigationIcon(R.drawable.icon_back);
        setSupportActionBar(mToolbar);
        //显示那个箭头
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mToolbar.setTitle("关于");
        setSupportActionBar(mToolbar);
        tvVersion.setText("V" + Tools.getVerName(this));
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}
