package com.android11.wallpager.home;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.android11.wallpager.R;
import com.android11.wallpager.home.adapter.HomeFragmentPagerAdapter;
import com.android11.wallpager.home.fragment.PhotosFragment;
import com.android11.wallpager.main.BaseActivity;
import com.android11.wallpager.utils.Const;
import com.android11.wallpager.utils.OrderType;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Bind(R.id.tab)
    TabLayout tab;
    @Bind(R.id.vp)
    ViewPager vp;
    private ArrayList<String> list_title;
    private List<Fragment> list_fragment = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initView();
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        StatusBarUtil.setColorForDrawerLayout(this, drawer, getResources().getColor(R.color.colorAccent));
        //初始 fragment

        PhotosFragment lastFragment = new PhotosFragment();
        lastFragment.setUrl(Const.LASTPHOTO);
        PhotosFragment hotFragment = new PhotosFragment();
        hotFragment.setUrl(Const.LASTPHOTO);
        hotFragment.setOrderby(OrderType.POPULAR);
        PhotosFragment curatedFragment = new PhotosFragment();
        curatedFragment.setUrl(Const.CURATEDPHOTO);

        list_fragment.add(lastFragment);
        list_fragment.add(hotFragment);
        list_fragment.add(curatedFragment);
        tab.setTabMode(TabLayout.GRAVITY_CENTER);

        list_title = new ArrayList<>();
        list_title.add("最新");
        list_title.add("热门");
        list_title.add("精选");
        vp.setAdapter(new HomeFragmentPagerAdapter(
                getSupportFragmentManager(), list_fragment, list_title));

        tab.setupWithViewPager(vp);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
