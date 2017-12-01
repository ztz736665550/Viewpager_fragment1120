package com.ztz.viewpager_fragment1120.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;
import com.xys.libzxing.zxing.activity.CaptureActivity;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;
import com.ztz.viewpager_fragment1120.R;
import com.ztz.viewpager_fragment1120.adapter.MyRecyclerAdapterHome;
import com.ztz.viewpager_fragment1120.bean.BannerBean;
import com.ztz.viewpager_fragment1120.presenter.RequestPresenter;
import com.ztz.viewpager_fragment1120.view.ViewCallBack;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;


/**
 * Created by TR on 2017/11/20.
 */

public class FragmentHome extends Fragment implements ViewCallBack{

    private RadioButton radio_btn_sys;
    private RadioButton radio_btn_xiaoxi;
    private EditText edit_text_sousuo;
    private Banner banner_view;
    private List<String> bannerlist = new ArrayList<>();
    private SpringView springview_home;
    private RecyclerView recycler_home;
    private MyRecyclerAdapterHome recyclerAdapterHome;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_layout, container, false);
        //获取控件
        radio_btn_sys = view.findViewById(R.id.radio_btn_sys);
        radio_btn_xiaoxi = view.findViewById(R.id.radio_btn_xiaoxi);
        edit_text_sousuo = view.findViewById(R.id.edit_text_sousuo);
        banner_view = view.findViewById(R.id.banner_view);
        springview_home = view.findViewById(R.id.springview_home);
        recycler_home = view.findViewById(R.id.recycler_home);

        //刷新
        springview_home.setHeader(new DefaultHeader(getContext()));
        springview_home.setFooter(new DefaultFooter(getContext()));
        //刷新的监听
        springview_home.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                //刷新
                Toast.makeText(getContext(),"刷新",Toast.LENGTH_SHORT).show();
                //停止刷新
                springview_home.onFinishFreshAndLoad();
            }

            @Override
            public void onLoadmore() {
                //加载
                //停止加载
                Toast.makeText(getContext(),"加载",Toast.LENGTH_SHORT).show();
                springview_home.onFinishFreshAndLoad();
            }
        });
        //recycler_home设置布局管理者
        recycler_home.setItemAnimator(new DefaultItemAnimator());
        recycler_home.setLayoutManager(new GridLayoutManager(getContext(),2));
        recycler_home.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        //与presenter通信
        RequestPresenter presenter = new RequestPresenter(this);
        presenter.RequestData();
        return view;
    }

    //二维码的回传值
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String result = bundle.getString("result");
            Toast.makeText(getContext(),result.toString(),Toast.LENGTH_SHORT).show();
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(getContext(),"扫描出错",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void success(BannerBean bannerBean) {
        //banner轮播图
        List<BannerBean.DataBean> list = bannerBean.getData();
        bannerlist.add(list.get(0).getIcon());
        bannerlist.add(list.get(1).getIcon());
        bannerlist.add(list.get(2).getIcon());
        bannerlist.add(list.get(3).getIcon());
        //设置集合
        banner_view.setImageLoader(new ImageLoaderBanner());
        banner_view.setImages(bannerlist);
        //banner执行完方法之后调用
        banner_view.start();
        //recyclerview的适配器
        List<BannerBean.MiaoshaBean.ListBeanX> data = bannerBean.getMiaosha().getList();
        //List<BannerBean.DataBean> data = bannerBean.getData();
        recyclerAdapterHome = new MyRecyclerAdapterHome(this,data);
        recycler_home.setAdapter(recyclerAdapterHome);

    }

    @Override
    public void failed(Exception e) {
        Log.i("=====", "failed: "+e.toString());
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //扫描二维码
        radio_btn_sys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击扫一扫时,开始扫描二维码
                Intent intent = new Intent(getActivity(),CaptureActivity.class);
                startActivityForResult(intent,-1);
            }
        });
    }

    public class ImageLoaderBanner extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            //Glide设置图片的简单用法
            Glide.with(context).load(path).into(imageView);
        }
    }
}
