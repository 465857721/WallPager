package com.android11.wallpager.pic;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.android11.wallpager.R;
import com.android11.wallpager.home.fragment.PhotosFragment;
import com.android11.wallpager.main.BaseActivity;
import com.android11.wallpager.search.SearchActivity;
import com.android11.wallpager.utils.Const;

import butterknife.Bind;
import butterknife.ButterKnife;


public class UserPicListActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userpiclist);
        ButterKnife.bind(this);
        initViw();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void initViw() {
        setSupportActionBar(mToolbar);
        //显示那个箭头
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setTitle("来自 "+getIntent().getStringExtra("name"));
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        PhotosFragment photosFragment = new PhotosFragment();
        photosFragment.setUrl(String.format(Const.USERPICLIST, getIntent().getStringExtra("name")));
        transaction.add(R.id.id_content, photosFragment);
        transaction.commit();

    }

}
