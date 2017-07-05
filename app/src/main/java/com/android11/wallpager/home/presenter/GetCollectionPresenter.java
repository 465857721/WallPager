package com.android11.wallpager.home.presenter;


import com.android11.wallpager.home.bean.CollectionBean;
import com.android11.wallpager.home.bean.PhotoListBean;
import com.android11.wallpager.home.iviews.IGetCollectionView;
import com.android11.wallpager.home.iviews.IGetPhotosView;
import com.android11.wallpager.utils.Const;
import com.android11.wallpager.utils.OrderType;
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

public class GetCollectionPresenter {
    private IGetCollectionView iView;

    public GetCollectionPresenter(IGetCollectionView iView) {
        this.iView = iView;
    }

    public void getPhoto(final int type) {
        if (iView == null )
            return;
        OkHttpUtils
                .get()
                .url(Const.COLLECTIONS)
                .addParams("client_id", iView.getClientId())
                .addParams("page", iView.getPage())
                .addParams("order_by", OrderType.LATEST)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int i) {
                        iView.OnError(e.toString());
                    }

                    @Override
                    public void onResponse(String s, int i) {
                        ArrayList<CollectionBean> list = getGsonInstance().fromJson(
                                s, new TypeToken<List<CollectionBean>>() {
                                }.getType());
                        iView.onGetPhotes(list, type);
                    }
                });
    }


}
