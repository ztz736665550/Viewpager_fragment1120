package com.ztz.viewpager_fragment1120.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ztz.viewpager_fragment1120.R;
import com.ztz.viewpager_fragment1120.bean.BannerBean;
import com.ztz.viewpager_fragment1120.fragment.FragmentHome;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ztz on 2017/12/1.
 */

public class MyRecyclerAdapterHome extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private FragmentHome fragmentHome;
    private List<BannerBean.MiaoshaBean.ListBeanX> data;
    public MyRecyclerAdapterHome(FragmentHome fragmentHome, List<BannerBean.MiaoshaBean.ListBeanX> data) {
        this.fragmentHome = fragmentHome;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(fragmentHome.getContext(), R.layout.recycler_home_layout, null);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        viewHolder holder1 = (viewHolder) holder;
        holder1.textTitle.setText(data.get(position).getTitle());
        holder1.textPrice.setText("￥"+data.get(position).getPrice()+"");
        String[] split = data.get(position).getImages().split("\\|");
        DraweeController draweeController01 = Fresco.newDraweeControllerBuilder()
                .setUri(split[0])
                .build();
        DraweeController draweeController02 = Fresco.newDraweeControllerBuilder()
                .setUri(split[1])
                .build();
        holder1.simpleDraweeleft.setController(draweeController01);
        holder1.simpleDraweeright.setController(draweeController02);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    static class viewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.text_title)
        TextView textTitle;
        @BindView(R.id.simpleDraweeleft)
        SimpleDraweeView simpleDraweeleft;
        @BindView(R.id.simpleDraweeright)
        SimpleDraweeView simpleDraweeright;
        @BindView(R.id.text_price)
        TextView textPrice;

        viewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
