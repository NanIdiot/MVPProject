package com.example.mvpproject.ui.detail;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.mvpproject.R;
import com.example.mvpproject.bean.GoodDetail;
import com.example.mvpproject.ui.base.BaseActivity;

public class GoodDetailActivity extends BaseActivity implements View.OnClickListener, GoodsDetailContract.IGoodsDetailView {

    public static final String GOODS_ID = "goods_id";
    private GoodsDetailPresenter goodsDetailPresenter;
    private Toolbar toolbar;
    private TextView detailContent;

    @Override
    protected void initViews() {
        toolbar = find(R.id.detail_toolbar);
        toolbar.setNavigationOnClickListener(this);
        detailContent = find(R.id.detail_content);
        int goodsId = getIntent().getIntExtra(GOODS_ID, 0);
        goodsDetailPresenter = new GoodsDetailPresenter(this);
        goodsDetailPresenter.getGoodsDetail(goodsId);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_goods_detail;
    }

    @Override
    public void onClick(View view) {
         finish();
    }

    @Override
    public void getGoodsDetailSuccess(GoodDetail goodDetail) {
        toolbar.setTitle(goodDetail.getName());
        detailContent.setText(goodDetail.getDescription());

    }

    @Override
    public void getGoodsDetailError(Throwable throwable) {
        Toast.makeText(this, "获取商品详情失败", Toast.LENGTH_SHORT).show();
    }
}
