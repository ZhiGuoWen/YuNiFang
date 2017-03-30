package com.wenzhiguo.yunifang.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.wenzhiguo.yunifang.Custom.TitleBar;
import com.wenzhiguo.yunifang.R;
import com.wenzhiguo.yunifang.adapter.SortAdapter;
import com.wenzhiguo.yunifang.bean.SortBean;
import com.wenzhiguo.yunifang.utils.OkHttp;

import java.util.List;

/**
 * 更多商品
 */
public class MoreActivity extends AppCompatActivity implements OkHttp.getData{
    private List<SortBean.DataBean.GoodsBriefBean> goodsBrief;
    private GridView mGridView;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String s =(String) msg.obj;
            Gson gson = new Gson();
            SortBean sortBean = gson.fromJson(s, SortBean.class);
            goodsBrief = sortBean.getData().getGoodsBrief();
            SortAdapter sortAdapter = new SortAdapter(MoreActivity.this, goodsBrief);
            mGridView.setAdapter(sortAdapter);
            //监听事件
            mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(MoreActivity.this, MatterActivity.class);
                    intent.putExtra("imageurl",goodsBrief.get(position).getGoods_img());
                    intent.putExtra("name",goodsBrief.get(position).getGoods_name());
                    intent.putExtra("price",goodsBrief.get(position).getShop_price()+"");
                    intent.putExtra("market",goodsBrief.get(position).getMarket_price()+"");
                    startActivity(intent);
                }
            });
        }
    };
    private ImageView mFinsh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        //控件
        TitleBar mTitleBar = (TitleBar) findViewById(R.id.more_title);
        mFinsh = (ImageView) mTitleBar.findViewById(R.id.title_image);
        mFinsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mGridView = (GridView) findViewById(R.id.more_gridview);
        //请求数据
        OkHttp.setHttp("http://m.yunifang.com/yunifang/mobile/category/list?" +
                "random=96333&encode=bf3386e14fe5bb0bcef234baebca2414",this);
    }

    @Override
    public void ruturn(String str) {
        Message msg = Message.obtain();
        msg.obj = str;
        handler.sendMessage(msg);
    }
}
