package com.example.mvpproject.ui.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {

    private View contentView;

    protected abstract void initViews();

    protected abstract int getLayoutId();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //fragment中没有findviewbyid 需要通过inflate来找到view
        contentView = inflater.inflate(getLayoutId(), container, false);
        initViews();
        return contentView;
    }
    protected <T extends View> T find(@IdRes int id){
        return contentView.findViewById(id);
    }

}
