package com.ztz.viewpager_fragment1120.presenter;

import android.util.Log;

import com.ztz.viewpager_fragment1120.bean.BannerBean;
import com.ztz.viewpager_fragment1120.model.ModelCallBack;
import com.ztz.viewpager_fragment1120.model.RequestModel;
import com.ztz.viewpager_fragment1120.view.ViewCallBack;

/**
 * Created by TR on 2017/11/29.
 */

public class RequestPresenter {

    private ViewCallBack viewCallBack;
    private final RequestModel model;

    public RequestPresenter(ViewCallBack viewCallBack) {
        this.viewCallBack = viewCallBack;
        this.model = new RequestModel();
    }

    public void RequestData(){
        model.Request(new ModelCallBack() {
            @Override
            public void success(BannerBean bannerBean) {
                viewCallBack.success(bannerBean);
            }

            @Override
            public void failed(Exception e) {
                viewCallBack.failed(e);
            }
        });
    }

}
