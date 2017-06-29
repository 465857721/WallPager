package com.android11.wallpager.home.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android11.wallpager.R;
import com.android11.wallpager.home.bean.PhotoListBean;
import com.android11.wallpager.home.iviews.IGetPhotosView;
import com.android11.wallpager.main.BaseFragment;

import java.util.ArrayList;


public class HotFragment extends BaseFragment implements IGetPhotosView{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.empty, null);

        return v;
    }


    @Override
    public String getUrl() {
        return null;
    }

    @Override
    public String getPage() {
        return null;
    }

    @Override
    public String getOrderBy() {
        return null;
    }

    @Override
    public void onGetPhotes(ArrayList<PhotoListBean> list, int type) {

    }


}
