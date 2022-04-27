package com.example.mvpproject.network.service;


import com.example.mvpproject.bean.BaseBean;
import com.example.mvpproject.bean.GoodDetail;
import com.example.mvpproject.bean.Goods;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoodService {

    // test
    @GET("edu-lance/edu-lance.github.io/master/goods_list")
    Flowable<BaseBean<List<Goods>>> getGoods();

    @GET("edu-lance/edu-lance.github.io/master/goods_detail")
    Flowable<BaseBean<GoodDetail>> getGoodsDetail(@Query("goodsId") int goodsId);

}
