package com.aibei.lixue.lixueandroids.samples.mertialDesign.drawerLayout.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aibei.lixue.lixueandroids.R;

/**
 * Created by Administrator on 2016/8/23.
 */
public class FragmentThree extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frame_three,container);
        return view;
    }
}
