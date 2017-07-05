package com.android11.wallpager.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android11.wallpager.R;
import com.android11.wallpager.collection.CollectionActivity;
import com.android11.wallpager.home.adapter.CollectionListAdapter;
import com.android11.wallpager.home.bean.CollectionBean;
import com.android11.wallpager.home.iviews.IGetCollectionView;
import com.android11.wallpager.home.presenter.GetCollectionPresenter;
import com.android11.wallpager.main.BaseFragment;
import com.android11.wallpager.utils.OperaType;
import com.malinskiy.superrecyclerview.OnMoreListener;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class CollectionFragment extends BaseFragment implements
        IGetCollectionView,
        CollectionListAdapter.OnItemClickLitener,
        SwipeRefreshLayout.OnRefreshListener, OnMoreListener {

    @Bind(R.id.listview)
    SuperRecyclerView listview;
    private int page = 1;

    private GetCollectionPresenter getPhotosPresenter;
    private CollectionListAdapter photoListAdapter;
    private ArrayList<CollectionBean> list = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_collection, null);
        ButterKnife.bind(this, v);

        getPhotosPresenter = new GetCollectionPresenter(this);
        photoListAdapter = new CollectionListAdapter(list, getActivity());
        photoListAdapter.setOnItemClickLitener(this);
        listview.setLayoutManager(new LinearLayoutManager(getActivity()));
        listview.setAdapter(photoListAdapter);

        listview.setRefreshListener(this);
        listview.setRefreshing(true);


        getPhotosPresenter.getPhoto(OperaType.REFRESH);
        return v;
    }


    @Override
    public String getPage() {
        return "" + page;
    }


    @Override
    public void onGetPhotes(ArrayList<CollectionBean> rlist, int type) {
        if (listview == null)
            return;

        if (type == OperaType.REFRESH) {
            list.clear();
            listview.setupMoreListener(this, 1);
        }

        listview.setLoadingMore(false);
        listview.setRefreshing(false);
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
        Intent godetail = new Intent(getActivity(), CollectionActivity.class);
        godetail.putExtra("id", list.get(position).getId() + "");
        godetail.putExtra("title", list.get(position).getTitle());
        startActivity(godetail);
    }
}
