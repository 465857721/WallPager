package com.android11.wallpager.home.iviews;

import com.android11.wallpager.home.bean.CollectionBean;
import com.android11.wallpager.home.bean.PhotoListBean;
import com.android11.wallpager.main.iviews.IBaseView;

import java.util.ArrayList;

/**
 * Created by zhoukang on 2017/6/29.
 */

public interface IGetCollectionView extends IBaseView{

    String getPage();
    void onGetPhotes(ArrayList<CollectionBean> list, int type);

}
