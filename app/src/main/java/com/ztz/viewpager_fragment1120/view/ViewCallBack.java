package com.ztz.viewpager_fragment1120.view;

import com.ztz.viewpager_fragment1120.bean.BannerBean;

/**
 * Created by TR on 2017/11/29.
 */

public interface ViewCallBack {
    void success(BannerBean bannerBean);
    void failed(Exception e);
}
