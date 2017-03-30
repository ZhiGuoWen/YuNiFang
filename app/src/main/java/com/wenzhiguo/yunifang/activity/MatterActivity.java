package com.wenzhiguo.yunifang.activity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.wenzhiguo.yunifang.Custom.TitleBar;
import com.wenzhiguo.yunifang.R;
import com.wenzhiguo.yunifang.bean.ShoppingBean;

/**
 * 详情页面
 */
public class MatterActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView mImageView;
    private TextView mName;
    private TextView mPrice;
    private TextView mMarket;
    private TextView mMoney;
    private TextView mCart;
    private String imageurl;
    private String name;
    private String price;
    private String market;
    private TitleBar mTitle;
    private ImageView mFinsh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matter);
        //创建数据库
      //  SQLiteDatabase database = Connector.getDatabase();
        //接收值
        Intent intent = getIntent();
        imageurl = intent.getStringExtra("imageurl");
        name = intent.getStringExtra("name");
        price = intent.getStringExtra("price");
        market = intent.getStringExtra("market");
        //找控件
        initView();
        //给控件赋值
        initData();

    }

    private void initData() {
        Glide.with(this).load(imageurl).into(mImageView);
        mName.setText(name);
        mMarket.setText("￥"+market);
        mPrice.setText("￥"+price);
    }

    private void initView() {
        mImageView = (ImageView) findViewById(R.id.shangpin_image);
        mName = (TextView) findViewById(R.id.shangpin_name);
        mCart = (TextView) findViewById(R.id.shangpin_cart);
        mMoney = (TextView) findViewById(R.id.shangpin_money);
        mPrice = (TextView) findViewById(R.id.shangpin_newprice);
        mMarket = (TextView) findViewById(R.id.shangpin_jiuprice);
        mMarket.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        mTitle = (TitleBar) findViewById(R.id.xiangqing_title);
        mFinsh = (ImageView) mTitle.findViewById(R.id.title_image);
        mFinsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mCart.setOnClickListener(this);
        mMoney.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //添加到购物车
            case R.id.shangpin_cart:
                ShoppingBean shoppingBean = new ShoppingBean();
                shoppingBean.setImageViewUrl(imageurl);
                shoppingBean.setMarkPrice(market);
                shoppingBean.setPrice(price);
                shoppingBean.setTitle(name);
                shoppingBean.save();
                if (shoppingBean.save()) {
                    Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
                }
                break;
            //立即支付
            case R.id.shangpin_money:

                break;
        }
    }
}
