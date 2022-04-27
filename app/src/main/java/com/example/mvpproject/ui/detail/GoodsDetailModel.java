package com.example.mvpproject.ui.detail;

import com.example.mvpproject.bean.BaseBean;
import com.example.mvpproject.bean.GoodDetail;
import com.example.mvpproject.network.RetrofitClient;
import com.example.mvpproject.network.service.GoodService;

import io.reactivex.rxjava3.core.Flowable;

public class GoodsDetailModel implements GoodsDetailContract.IGoodsDetailModel {
    @Override
    public Flowable<BaseBean<GoodDetail>> getGoodsDetail(int goodsid) {
        return RetrofitClient.getInstance().getService(GoodService.class)
                .getGoodsDetail(goodsid);
    }
}
