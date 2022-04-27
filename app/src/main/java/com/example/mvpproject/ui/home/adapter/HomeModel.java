package com.example.mvpproject.ui.home.adapter;

import com.example.mvpproject.bean.BaseBean;
import com.example.mvpproject.bean.Goods;
import com.example.mvpproject.network.RetrofitClient;
import com.example.mvpproject.network.service.GoodService;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

public class HomeModel implements HomeContract.IHomeModel{
    //从网络获取
    @Override
    public Flowable<BaseBean<List<Goods>>> getData() {
        return RetrofitClient.getInstance().getService(GoodService.class)
                .getGoods();
    }
}
