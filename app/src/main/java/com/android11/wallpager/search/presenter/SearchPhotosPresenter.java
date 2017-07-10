package com.android11.wallpager.search.presenter;


import android.text.TextUtils;

import com.android11.wallpager.home.bean.PhotoListBean;
import com.android11.wallpager.search.bean.SearchResultBean;
import com.android11.wallpager.search.iviews.ISearchPhotosView;
import com.android11.wallpager.utils.GsonUtils;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

import static com.android11.wallpager.utils.GsonUtils.getGsonInstance;


/**
 * Created by zhoukang on 2017/5/19.
 */

public class SearchPhotosPresenter {
    private ISearchPhotosView iView;

    public SearchPhotosPresenter(ISearchPhotosView iView) {
        this.iView = iView;
    }

    public void getPhoto(final int type) {
        if (iView == null || iView.getUrl() == null)
            return;
        if (TextUtils.isEmpty(iView.getKetword()))
            return;

        OkHttpUtils
                .get()
                .url(iView.getUrl())
                .addParams("query", iView.getKetword())
                .addParams("client_id", iView.getClientId())
                .addParams("page", iView.getPage())
                .addParams("order_by", iView.getOrderBy())
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int i) {
                        iView.OnError(e.toString());
                    }

                    @Override
                    public void onResponse(String s, int i) {
//                        ArrayList<PhotoListBean> list = getGsonInstance().fromJson(
//                                s, new TypeToken<List<PhotoListBean>>() {
//                                }.getType());
                        SearchResultBean searchResultBean = GsonUtils.getGsonInstance().fromJson(s, SearchResultBean.class);

                        iView.onGetPhotes(searchResultBean, type);
                    }
                });
    }


}
