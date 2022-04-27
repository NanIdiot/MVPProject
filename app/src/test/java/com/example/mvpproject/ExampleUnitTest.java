package com.example.mvpproject;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.mvpproject.bean.BaseBean;
import com.example.mvpproject.bean.Goods;
import com.example.mvpproject.network.RetrofitClient;
import com.example.mvpproject.network.service.GoodService;

import java.util.List;

import io.reactivex.rxjava3.functions.Consumer;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);

        GoodService goodsService = RetrofitClient.getInstance().getService(GoodService.class);
        goodsService.getGoods().subscribe(new Consumer<BaseBean<List<Goods>>>() {
            @Override
            public void accept(BaseBean<List<Goods>> listBaseBean) throws Throwable {
                System.out.println(listBaseBean);
            }
        });
        while (true);
    }

}