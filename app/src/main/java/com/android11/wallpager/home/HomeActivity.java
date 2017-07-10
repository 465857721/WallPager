package com.android11.wallpager.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.android11.wallpager.R;
import com.android11.wallpager.about.AboutActivity;
import com.android11.wallpager.home.adapter.HomeFragmentPagerAdapter;
import com.android11.wallpager.home.fragment.CollectionFragment;
import com.android11.wallpager.home.fragment.PhotosFragment;
import com.android11.wallpager.main.BaseActivity;
import com.android11.wallpager.search.SearchActivity;
import com.android11.wallpager.setting.SettingActivity;
import com.android11.wallpager.utils.Const;
import com.android11.wallpager.utils.OrderType;
import com.android11.wallpager.utils.Tools;
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

    @Override
    protected void setStatusBar() {
//        super.setStatusBar();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Unsplash&摄影&壁纸");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        StatusBarUtil.setColorForDrawerLayout(this, drawer, ContextCompat.getColor(this, R.color.colorPrimaryDark));

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //初始 fragment

        PhotosFragment lastFragment = new PhotosFragment();
        lastFragment.setUrl(Const.LASTPHOTO);
        PhotosFragment curatedFragment = new PhotosFragment();
        curatedFragment.setUrl(Const.CURATEDPHOTO);

        CollectionFragment collectionFragment = new CollectionFragment();
//        collectionFragment.setUrl(Const.LASTPHOTO2);
//        hotFragment.setOrderby(OrderType.POPULAR);


        list_fragment.add(lastFragment);
        list_fragment.add(curatedFragment);
        list_fragment.add(collectionFragment);

        tab.setTabMode(TabLayout.GRAVITY_CENTER);

        list_title = new ArrayList<>();
        list_title.add("最新");
        list_title.add("精选");
        list_title.add("选集");
        vp.setAdapter(new HomeFragmentPagerAdapter(
                getSupportFragmentManager(), list_fragment, list_title));

        tab.setupWithViewPager(vp);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.search:
                Intent goSearch = new Intent(this, SearchActivity.class);
                startActivity(goSearch);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_setting:
                Intent setIntent = new Intent(this, SettingActivity.class);
                startActivity(setIntent);
                break;
            case R.id.nav_about:
                Intent aboutIntent = new Intent(this, AboutActivity.class);
                startActivity(aboutIntent);
                break;
            case R.id.nav_send:
                joinQQGroup();
                break;
            case R.id.nav_comment:
                Tools.goMarket(this);
                break;

        }
        return true;
    }

    public boolean joinQQGroup() {
        Intent intent = new Intent();
        intent.setData(Uri.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26k%3D" + "a7kpL7ND9wz0t8XiqUt7"));
        // 此Flag可根据具体产品需要自定义，如设置，则在加群界面按返回，返回手Q主界面，不设置，按返回会返回到呼起产品界面    //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        try {
            startActivity(intent);
            return true;
        } catch (Exception e) {
            Tools.toastInBottom(this, "未安装手Q或安装的版本不支持");
            return false;
        }
    }

}
