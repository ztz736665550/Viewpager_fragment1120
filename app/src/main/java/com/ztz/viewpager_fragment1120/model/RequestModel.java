package com.ztz.viewpager_fragment1120.model;

import android.util.Log;

import com.ztz.viewpager_fragment1120.bean.BannerBean;
import com.ztz.viewpager_fragment1120.okhttp.AbstractUiCallBack;
import com.ztz.viewpager_fragment1120.okhttp.OkhttpUtils;

/**
 * Created by TR on 2017/11/29.
 */

public class RequestModel {

    //banner轮播图访问网络
    public void Request(final ModelCallBack modelCallBack) {
        OkhttpUtils.getInstance().asy(null, "https://www.zhaoapi.cn/ad/getAd", new AbstractUiCallBack<BannerBean>() {

            @Override
            public void success(BannerBean bannerBean) {
                Log.i("============", "success: "+bannerBean.getCode());
                modelCallBack.success(bannerBean);

            }

            @Override
            public void failure(Exception e) {
                modelCallBack.failed(e);
                Log.i("==========", "failure: "+e.toString());
            }
        });
    }
    //首页recylerview访问网络

}
