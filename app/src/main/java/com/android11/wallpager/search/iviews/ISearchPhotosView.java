package com.android11.wallpager.search.iviews;

import com.android11.wallpager.home.bean.PhotoListBean;
import com.android11.wallpager.main.iviews.IBaseView;
import com.android11.wallpager.search.bean.SearchResultBean;

import java.util.ArrayList;

/**
 * Created by zhoukang on 2017/6/29.
 */

public interface ISearchPhotosView extends IBaseView{
    String getUrl();
    String getPage();
    String getOrderBy();
    void onGetPhotes(SearchResultBean data, int type);
    String getKetword();

}
