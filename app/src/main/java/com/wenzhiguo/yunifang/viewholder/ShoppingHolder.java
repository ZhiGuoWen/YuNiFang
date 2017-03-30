package com.wenzhiguo.yunifang.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wenzhiguo.yunifang.R;

/**
 * Created by dell on 2017/3/28.
 */

public class ShoppingHolder extends RecyclerView.ViewHolder {

    public final ImageView mImageView;
    public final TextView mName;
    public final TextView mPrice;
    public final TextView mConut;
    public final CheckBox mCheck;
    public final RelativeLayout mRelate;

    public ShoppingHolder(View itemView) {
        super(itemView);
        mRelate = (RelativeLayout)itemView.findViewById(R.id.shop_relative);
        mImageView = (ImageView) itemView.findViewById(R.id.shopcat_item_img);
        mCheck = (CheckBox) itemView.findViewById(R.id.shopcat_item_box);
        mName = (TextView) itemView.findViewById(R.id.shopcat_item_name);
        mPrice = (TextView) itemView.findViewById(R.id.shopcat_item_price);
        mConut = (TextView) itemView.findViewById(R.id.shopcat_item_count);
    }
}
