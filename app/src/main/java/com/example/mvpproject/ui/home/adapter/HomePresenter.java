package com.example.mvpproject.ui.home.adapter;

import com.example.mvpproject.bean.BaseBean;
import com.example.mvpproject.bean.Goods;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HomePresenter implements HomeContract.IHomePresenter{

    private HomeContract.IHomeView homeView;
    private HomeContract.IHomeModel homeModel;

    public HomePresenter(HomeContract.IHomeView homeView) {
        this.homeView = homeView;
        homeModel = new HomeModel();
    }

    @Override
    public void getData() {
        homeModel.getData()
                .subscribeOn(Schedulers.io())
                .observeOn((AndroidSchedulers.mainThread()))
                .subscribe(new Consumer<BaseBean<List<Goods>>>() {
                    @Override
                    public void accept(BaseBean<List<Goods>> listBaseBean) throws Throwable {
                        homeView.getGoodsSuccess(listBaseBean.getData());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        homeView.getGoodsError(throwable);
                    }
                });
    }
}
