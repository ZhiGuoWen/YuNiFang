package com.wenzhiguo.yunifang.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.wenzhiguo.yunifang.R;

/**
 * Created by dell on 2017/3/25.
 * recyclerview优化
 */

public class ReMenRecycleHolder extends RecyclerView.ViewHolder {

    public final ImageView remen_imageview;
    public final RecyclerView remen_recycler;

    public ReMenRecycleHolder(View itemView) {
        super(itemView);
        remen_imageview = (ImageView) itemView.findViewById(R.id.remen_img);
        remen_recycler = (RecyclerView) itemView.findViewById(R.id.remen_recycleView);
    }
}
