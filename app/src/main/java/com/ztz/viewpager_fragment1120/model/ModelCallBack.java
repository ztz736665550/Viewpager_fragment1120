package com.ztz.viewpager_fragment1120.model;

import com.ztz.viewpager_fragment1120.bean.BannerBean;

/**
 * Created by TR on 2017/11/29.
 */

public interface ModelCallBack {
    void success(BannerBean bannerBean);
    void failed(Exception e);
}
