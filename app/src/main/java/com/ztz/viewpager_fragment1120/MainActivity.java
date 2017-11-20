package com.ztz.viewpager_fragment1120;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ztz.viewpager_fragment1120.fragment.fragmentHome;
import com.ztz.viewpager_fragment1120.fragment.fragmentMy;
import com.ztz.viewpager_fragment1120.fragment.fragmentShop;
import com.ztz.viewpager_fragment1120.fragment.fragmentVideo;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioButton radio_btn_my;
    private RadioButton radio_btn_shop;
    private RadioButton radio_btn_home;
    private RadioButton radio_btn_video;
    private ViewPager view_pager_main;
    private RadioGroup radio_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //radiogroup的点击事件
        radio_group.setOnCheckedChangeListener(this);
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new fragmentHome());
        list.add(new fragmentVideo());
        list.add(new fragmentShop());
        list.add(new fragmentMy());
        ViewPagerAdapter adapter = new ViewPagerAdapter(list, getSupportFragmentManager());
        view_pager_main.setAdapter(adapter);
        //viewpager的点击事件
        view_pager_main.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //viewpager页面滑动,实现按钮跟随滑动
                radio_group.check(radio_group.getChildAt(position).getId());
            }

            @Override
            public void onPageSelected(int position) {

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
    private void initView() {
        view_pager_main = findViewById(R.id.view_pager_main);
        radio_btn_home = findViewById(R.id.radio_btn_home);
        radio_btn_video = findViewById(R.id.radio_btn_video);
        radio_btn_shop = findViewById(R.id.radio_btn_shop);
        radio_btn_my = findViewById(R.id.radio_btn_my);
        radio_group = findViewById(R.id.radio_group);

    }

}
