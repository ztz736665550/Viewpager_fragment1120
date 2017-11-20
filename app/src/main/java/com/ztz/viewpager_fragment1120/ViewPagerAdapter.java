package com.ztz.viewpager_fragment1120;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by TR on 2017/11/20.
 */

class ViewPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> list;
    FragmentManager fm;
    public ViewPagerAdapter(ArrayList<Fragment> list, FragmentManager fm) {
        super(fm);
        this.list = list;
        this.fm = fm;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }
    //这个方法要注释
    /*@Override
    public boolean isViewFromObject(View view, Object object) {
        boolean b = view == object;
        return b;
    }*/
}
