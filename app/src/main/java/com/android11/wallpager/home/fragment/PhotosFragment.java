package com.android11.wallpager.home.fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android11.wallpager.R;
import com.android11.wallpager.home.adapter.PhotoListAdapter;
import com.android11.wallpager.home.bean.PhotoListBean;
import com.android11.wallpager.home.iviews.IGetPhotosView;
import com.android11.wallpager.home.presenter.GetPhotosPresenter;
import com.android11.wallpager.main.BaseFragment;
import com.android11.wallpager.pic.PicDetailActivity;
import com.android11.wallpager.utils.OperaType;
import com.android11.wallpager.utils.OrderType;
import com.malinskiy.superrecyclerview.OnMoreListener;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class PhotosFragment extends BaseFragment implements PhotoListAdapter.OnItemClickLitener, IGetPhotosView, SwipeRefreshLayout.OnRefreshListener, OnMoreListener {
    @Bind(R.id.listview)
    SuperRecyclerView listview;
    private int page = 1;
    private GetPhotosPresenter getPhotosPresenter;
    private PhotoListAdapter photoListAdapter;
    private ArrayList<PhotoListBean> list = new ArrayList<>();
    private String url;
    private String orderby = OrderType.LATEST;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getPhotosPresenter = new GetPhotosPresenter(this);
        View v = inflater.inflate(R.layout.frag_last, null);

        ButterKnife.bind(this, v);
        photoListAdapter = new PhotoListAdapter(list, getActivity());
        photoListAdapter.setOnItemClickLitener(this);
        listview.setLayoutManager(new LinearLayoutManager(getActivity()));
        listview.setAdapter(photoListAdapter);

        listview.setRefreshListener(this);
        listview.setRefreshing(true);


        getPhotosPresenter.getPhoto(OperaType.REFRESH);
        return v;
    }

    public void setOrderby(String orderby) {
        this.orderby = orderby;
    }

    @Override
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
    public void onGetPhotes(ArrayList<PhotoListBean> rlist, int type) {
        if (listview == null)
            return;

        if (type == OperaType.REFRESH) {
            list.clear();
            listview.setupMoreListener(this, 1);
        }

        listview.setLoadingMore(false);
        listview.setRefreshing(false);
        if(rlist.size()==0)
            listview.removeMoreListener();
        this.list.addAll(rlist);
        photoListAdapter.notifyDataSetChanged();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
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
        Intent godetail = new Intent(getActivity(), PicDetailActivity.class);
        godetail.putExtra("id", list.get(position).getId());
        godetail.putExtra("color", list.get(position).getColor());
        godetail.putExtra("url", list.get(position).getUrls().getRegular());
        godetail.putExtra("headurl", list.get(position).getUser().getProfile_image().getLarge());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(godetail,
                    ActivityOptions
                            .makeSceneTransitionAnimation(getActivity(),
//                                    Pair.create(view.findViewById(R.id.tv_name), "tvname"),
                                    Pair.create(view, "ivpic"),
                                    Pair.create(view.findViewById(R.id.iv_head), "headpic"))
                            .toBundle());
        } else {
            startActivity(godetail);
        }

    }
}
