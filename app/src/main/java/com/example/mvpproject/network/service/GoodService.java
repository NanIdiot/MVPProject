package com.example.mvpproject.network.service;


import java.util.List;

import io.reactivex.rxjava3.core.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoodService {

    @GET("https://github.com/edu-lance/edu-lance.github.io/blob/master/goods_list")
    Flowable<Boolean<List<Goods>>> getGoods();

    @GET("https://github.com/edu-lance/edu-lance.github.io/blob/master/goods_detail")
    Flowable<Boolean<List<Goods>>> getGoodsDetail(@Query("goodsId") int goodsId);

}
