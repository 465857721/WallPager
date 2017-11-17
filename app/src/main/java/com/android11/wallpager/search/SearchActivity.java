package com.android11.wallpager.search;


import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.android11.wallpager.R;
import com.android11.wallpager.home.adapter.PhotoListAdapter;
import com.android11.wallpager.home.bean.PhotoListBean;
import com.android11.wallpager.main.BaseActivity;
import com.android11.wallpager.pic.PicDetailActivity;
import com.android11.wallpager.search.bean.SearchResultBean;
import com.android11.wallpager.search.iviews.ISearchPhotosView;
import com.android11.wallpager.search.presenter.SearchPhotosPresenter;
import com.android11.wallpager.utils.Const;
import com.android11.wallpager.utils.OperaType;
import com.android11.wallpager.utils.OrderType;
import com.android11.wallpager.utils.Tools;
import com.malinskiy.superrecyclerview.OnMoreListener;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SearchActivity extends BaseActivity implements TextView.OnEditorActionListener, ISearchPhotosView, PhotoListAdapter.OnItemClickLitener, SwipeRefreshLayout.OnRefreshListener, OnMoreListener {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.et_keyword)
    EditText etKeyword;
    @BindView(R.id.listview)
    SuperRecyclerView listview;
    private int page = 1;
    private SearchPhotosPresenter getPhotosPresenter;
    private PhotoListAdapter photoListAdapter;
    private ArrayList<PhotoListBean> list = new ArrayList<>();
    private String url;
    private String orderby = OrderType.LATEST;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        initViw();
        getPhotosPresenter = new SearchPhotosPresenter(this);
        photoListAdapter = new PhotoListAdapter(list, this);
        photoListAdapter.setOnItemClickLitener(this);
        listview.setLayoutManager(new LinearLayoutManager(this));
        listview.setAdapter(photoListAdapter);

//        listview.setRefreshListener(this);
//        listview.setRefreshing(true);

        etKeyword.setOnEditorActionListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.clear:
                etKeyword.setText("");
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(etKeyword, InputMethodManager.SHOW_FORCED);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initViw() {
        setSupportActionBar(mToolbar);
        //显示那个箭头
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    @Override
    public String getUrl() {
        return Const.SEARCH_PHOTOS;
    }


    @Override
    public String getPage() {
        return "" + page;
    }

    @Override
    public String getOrderBy() {
        return orderby;
    }

    @Override
    public void onGetPhotes(SearchResultBean data, int type) {
        if (listview == null)
            return;
        ArrayList<PhotoListBean> rlist = data.getResults();
        if (type == OperaType.REFRESH) {
            list.clear();
            Tools.toastInBottom(this, "搜索到" + data.getTotal() + "个结果");
        }
        listview.setLoadingMore(false);
        listview.setRefreshing(false);
        this.list.addAll(rlist);
        photoListAdapter.notifyDataSetChanged();

        if (this.list.size() < data.getTotal()) {
            listview.setupMoreListener(this, 1);
        } else {
            listview.removeMoreListener();
        }

    }

    @Override
    public String getKetword() {
        return etKeyword.getText().toString();
    }


    @Override
    public void OnError(String s) {
        super.OnError(s);
        if (listview == null)
            return;
        listview.setLoadingMore(false);
        listview.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        page = 1;
        getPhotosPresenter.getPhoto(OperaType.REFRESH);

    }

    @Override
    public void onMoreAsked(int i, int i1, int i2) {
        page++;
        getPhotosPresenter.getPhoto(OperaType.LOADMORE);

    }

    @Override
    public void onItemClick(View view, int position) {
        Intent godetail = new Intent(this, PicDetailActivity.class);
        godetail.putExtra("id", list.get(position).getId());
        godetail.putExtra("color", list.get(position).getColor());
        godetail.putExtra("url", list.get(position).getUrls().getRegular());
        godetail.putExtra("headurl", list.get(position).getUser().getProfile_image().getLarge());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(godetail,
                    ActivityOptions
                            .makeSceneTransitionAnimation(this,
//                                    Pair.create(view.findViewById(R.id.tv_name), "tvname"),
                                    Pair.create(view, "ivpic"),
                                    Pair.create(view.findViewById(R.id.iv_head), "headpic"))
                            .toBundle());
        } else {
            startActivity(godetail);
        }

    }


    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (TextUtils.isEmpty(etKeyword.getText().toString())) {
            Tools.toastInBottom(this, "请输入搜索内容");
            return true;
        }
        listview.setRefreshing(true);
        getPhotosPresenter.getPhoto(OperaType.REFRESH);
        Tools.hideSoftInput(this);
        return true;
    }
}
