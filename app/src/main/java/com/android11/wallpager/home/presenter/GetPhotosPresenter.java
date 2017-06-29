package com.android11.wallpager.home.presenter;


import android.util.Log;

import com.android11.wallpager.home.bean.PhotoListBean;
import com.android11.wallpager.home.iviews.IGetPhotosView;
import com.android11.wallpager.utils.Const;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

import static com.android11.wallpager.utils.GsonUtils.getGsonInstance;
import static com.umeng.analytics.pro.x.i;


/**
 * Created by zhoukang on 2017/5/19.
 */

public class GetPhotosPresenter {
    private IGetPhotosView iView;

    public GetPhotosPresenter(IGetPhotosView iView) {
        this.iView = iView;
    }

    public void getPhoto(final int type) {
        OkHttpUtils
                .get()
                .url(iView.getUrl())
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
                        ArrayList<PhotoListBean> list = getGsonInstance().fromJson(
                                s, new TypeToken<List<PhotoListBean>>() {
                        }.getType());
                        iView.onGetPhotes(list,type);
                    }
                });
    }


}
