package com.ztz.viewpager_fragment1120;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.ztz.viewpager_fragment1120.adapter.ViewPagerAdapter;
import com.ztz.viewpager_fragment1120.fragment.FragmentHome;
import com.ztz.viewpager_fragment1120.fragment.FragmentMy;
import com.ztz.viewpager_fragment1120.fragment.FragmentShop;
import com.ztz.viewpager_fragment1120.fragment.FragmentVideo;
import com.ztz.viewpager_fragment1120.presenter.RequestPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {

    private ViewPager view_pager_main;
    private RadioGroup radio_group;
    private RequestPresenter presenter;
    private List bannerlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //radiogroup的点击事件
        radio_group.setOnCheckedChangeListener(this);
        ArrayList<Fragment> list = new ArrayList<>();
        FragmentHome fragmentHome = new FragmentHome();
        list.add(fragmentHome);
        list.add(new FragmentVideo());
        list.add(new FragmentShop());
        list.add(new FragmentMy());
        ViewPagerAdapter adapter = new ViewPagerAdapter(list, getSupportFragmentManager());
        view_pager_main.setAdapter(adapter);
        //viewpager的点击事件
        view_pager_main.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //viewpager页面滑动,实现按钮跟随滑动
                radio_group.check(radio_group.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    //按钮
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case R.id.radio_btn_home:
                view_pager_main.setCurrentItem(0,false);
                break;
            case R.id.radio_btn_video:
                view_pager_main.setCurrentItem(1,false);
                break;
            case R.id.radio_btn_shop:
                view_pager_main.setCurrentItem(2,false);
                break;
            case R.id.radio_btn_my:
                view_pager_main.setCurrentItem(3,false);
                break;
                default:

                break;
        }
    }
    //初始化控件
    private void initView() {
        view_pager_main = findViewById(R.id.view_pager_main);
        radio_group = findViewById(R.id.radio_group);
        bannerlist = new ArrayList();
    }
}
