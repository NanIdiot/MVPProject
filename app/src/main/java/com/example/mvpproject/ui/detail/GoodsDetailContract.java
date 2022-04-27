package com.example.mvpproject.ui.detail;

import com.example.mvpproject.bean.BaseBean;
import com.example.mvpproject.bean.GoodDetail;
import com.example.mvpproject.bean.Goods;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

public interface GoodsDetailContract {

    interface IGoodsDetailPresenter{
        void getGoodsDetail(int goodsId);
    }

    interface IGoodsDetailModel{
        Flowable<BaseBean<GoodDetail>> getGoodsDetail(int goodsid);
    }

    interface IGoodsDetailView{
        void getGoodsDetailSuccess(GoodDetail goodDetail);

        void getGoodsDetailError(Throwable throwable);
    }


}
