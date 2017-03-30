package com.wenzhiguo.yunifang.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.wenzhiguo.yunifang.R;
import com.wenzhiguo.yunifang.intefact.RecyclerOnClick;
import com.wenzhiguo.yunifang.bean.HomeBean;
import com.wenzhiguo.yunifang.viewholder.ReMenItemRecycleViewHolder;

import java.util.List;

/**
 * Created by dell on 2017/3/25.
 * recylerview适配器字条目
 */

public class ReMenItemRecycleViewAdapter extends RecyclerView.Adapter<ReMenItemRecycleViewHolder> {
    private final Context context;
    private final List<HomeBean.DataBean.SubjectsBean.GoodsListBean> goodsList;
    private final int aPosition;
    private ReMenItemRecycleViewHolder reMenItemRecycleViewHolder;
    private final RecyclerOnClick onClick;
    public ReMenItemRecycleViewAdapter(Context context,
                                       List<HomeBean.DataBean.SubjectsBean.GoodsListBean> goodsList,
                                       RecyclerOnClick onClick,
                                       int aPosition) {
        this.context = context;
        this.goodsList = goodsList;
        this.onClick = onClick;
        this.aPosition = aPosition;
    }

    @Override
    public ReMenItemRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate
                (R.layout.remen_item_recycleview_item, parent, false);
        reMenItemRecycleViewHolder = new ReMenItemRecycleViewHolder(inflate);
        return reMenItemRecycleViewHolder;
    }

    @Override
    public void onBindViewHolder(ReMenItemRecycleViewHolder holder, final int position) {
        Glide.with(context)
                .load(goodsList.get(position).getGoods_img())
                .into(holder.remen_item_img);
        holder.remen_item_name.setText(goodsList.get(position).getGoods_name());
        holder.remen_item_price.setText("￥"+goodsList.get(position).getShop_price());
        holder.remen_item_market_price.setText("￥"+goodsList.get(position).getMarket_price());
        holder.remen_item_market_price.getPaint().setFlags
                (Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        holder.rela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.setOnClickListen(aPosition,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return goodsList.size();
    }
}
