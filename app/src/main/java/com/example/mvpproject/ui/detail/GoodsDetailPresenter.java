package com.example.mvpproject.ui.detail;


import com.example.mvpproject.bean.BaseBean;
import com.example.mvpproject.bean.GoodDetail;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class GoodsDetailPresenter implements GoodsDetailContract.IGoodsDetailPresenter {
    private final GoodsDetailContract.IGoodsDetailView goodsDetailView;
    GoodsDetailContract.IGoodsDetailModel goodsDetailModel;

    public GoodsDetailPresenter(GoodsDetailContract.IGoodsDetailView goodsDetailView) {
        goodsDetailModel = new GoodsDetailModel();
        this.goodsDetailView = goodsDetailView;
    }

    @Override
    public void getGoodsDetail(int goodsId) {
        goodsDetailModel.getGoodsDetail(goodsId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseBean<GoodDetail>>() {
                    @Override
                    public void accept(BaseBean<GoodDetail> goodDetailBaseBean) throws Throwable {
                        goodsDetailView.getGoodsDetailSuccess(goodDetailBaseBean.getData());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        goodsDetailView.getGoodsDetailError(throwable);
                    }
                });

    }
}
