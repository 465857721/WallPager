package com.android11.wallpager.collection;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.android11.wallpager.R;
import com.android11.wallpager.home.fragment.PhotosFragment;
import com.android11.wallpager.main.BaseActivity;
import com.android11.wallpager.utils.Const;

import butterknife.Bind;
import butterknife.ButterKnife;


public class CollectionActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
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
        mToolbar.setTitle(getIntent().getStringExtra("title"));
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
        photosFragment.setUrl(String.format(Const.COLLECTIONS_ID, getIntent().getStringExtra("id")));
        transaction.add(R.id.id_content, photosFragment);
        transaction.commit();

    }

}
