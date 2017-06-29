package com.android11.wallpager.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.android11.wallpager.main.iviews.IBaseView;
import com.android11.wallpager.utils.Const;
import com.android11.wallpager.utils.SharePreferenceUtil;
import com.android11.wallpager.utils.Tools;


public class BaseFragment extends Fragment implements IBaseView {
    public SharePreferenceUtil spu;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        spu = new SharePreferenceUtil(getActivity(), "wall");
    }


    @Override
    public void OnError(String s) {
        Tools.toastInBottom(getActivity(), s);
    }

    @Override
    public String getClientId() {
        return Const.CLIENT_ID;
    }
}
