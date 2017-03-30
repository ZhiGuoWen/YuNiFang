package com.wenzhiguo.yunifang.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wenzhiguo.yunifang.R;

/**
 * Created by dell on 2017/3/25.
 * 优化recyclerview子条目优化
 */

public class ReMenItemRecycleViewHolder extends RecyclerView.ViewHolder {

    public final ImageView remen_item_img;
    public final TextView remen_item_name;
    public final TextView remen_item_price;
    public final TextView remen_item_market_price;
    public final RelativeLayout rela;

    public ReMenItemRecycleViewHolder(View itemView) {
        super(itemView);
        rela = (RelativeLayout) itemView.findViewById(R.id.recycler_re);
        remen_item_img = (ImageView) itemView.findViewById(R.id.remen_item_img);
        remen_item_name = (TextView) itemView.findViewById(R.id.remen_item_name);
        remen_item_price = (TextView) itemView.findViewById(R.id.remen_item_price);
        remen_item_market_price = (TextView) itemView.findViewById(R.id.remen_item_market_price);
    }
}
