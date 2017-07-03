package com.android11.wallpager.pic.iviews;

import com.android11.wallpager.home.bean.PhotoListBean;
import com.android11.wallpager.main.iviews.IBaseView;
import com.android11.wallpager.pic.bean.PicDetailBean;

import java.util.ArrayList;

/**
 * Created by zhoukang on 2017/6/29.
 */

public interface IGetPhotoDetailView extends IBaseView{
    String getPhotoID();

    void onGetPhoteDetail(PicDetailBean bean);

}
