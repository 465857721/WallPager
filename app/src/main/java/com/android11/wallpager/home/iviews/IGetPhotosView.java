package com.android11.wallpager.home.iviews;

import com.android11.wallpager.home.bean.PhotoListBean;
import com.android11.wallpager.main.iviews.IBaseView;

import java.util.ArrayList;

/**
 * Created by zhoukang on 2017/6/29.
 */

public interface IGetPhotosView extends IBaseView{
    String getUrl();
    String getPage();
    String getOrderBy();
    void onGetPhotes(ArrayList<PhotoListBean> list,int type);

}
