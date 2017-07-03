package com.android11.wallpager.pic.presenter;


import com.android11.wallpager.pic.bean.PicDetailBean;
import com.android11.wallpager.pic.iviews.IGetPhotoDetailView;
import com.android11.wallpager.utils.Const;
import com.android11.wallpager.utils.GsonUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;


/**
 * Created by zhoukang on 2017/5/19.
 */

public class GetPhotoDetailPresenter {
    private IGetPhotoDetailView iView;

    public GetPhotoDetailPresenter(IGetPhotoDetailView iView) {
        this.iView = iView;
    }

    public void getPhoto() {
        OkHttpUtils
                .get()
                .url(Const.PHOTODETAIL + iView.getPhotoID())
                .addParams("client_id", iView.getClientId())

                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int i) {
                        iView.OnError(e.toString());
                    }

                    @Override
                    public void onResponse(String s, int i) {
                        PicDetailBean bean = GsonUtils.getGsonInstance().fromJson(s, PicDetailBean.class);
                        iView.onGetPhoteDetail(bean);
                    }
                });
    }


}
