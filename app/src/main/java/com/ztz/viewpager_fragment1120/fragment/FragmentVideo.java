package com.ztz.viewpager_fragment1120.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ztz.viewpager_fragment1120.R;

/**
 * Created by TR on 2017/11/20.
 */

public class FragmentVideo extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_layout, container, false);

        return view;
    }
}
