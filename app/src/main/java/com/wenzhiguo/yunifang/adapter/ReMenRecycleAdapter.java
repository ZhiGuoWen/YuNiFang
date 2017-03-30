package com.wenzhiguo.yunifang.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.wenzhiguo.yunifang.R;
import com.wenzhiguo.yunifang.intefact.RecyclerOnClick;
import com.wenzhiguo.yunifang.bean.HomeBean;
import com.wenzhiguo.yunifang.viewholder.ReMenRecycleHolder;

import java.util.List;

/**
 * Created by dell on 2017/3/25.
 * recylerview适配器
 */

public class ReMenRecycleAdapter extends RecyclerView.Adapter<ReMenRecycleHolder> {

    private final Context context;
    private final List<HomeBean.DataBean.SubjectsBean> subject;
    private final RecyclerOnClick onClick;
    private ReMenItemRecycleViewAdapter reMenItemRecycleViewAdapter;

    public ReMenRecycleAdapter(Context context, List<HomeBean.DataBean.SubjectsBean> subject, RecyclerOnClick onClick) {
        this.context = context;
        this.subject  = subject;
        this.onClick = onClick;
    }

    @Override
    public ReMenRecycleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate
                (R.layout.remenzhuanti_recycleview_item, parent, false);
        ReMenRecycleHolder reMenRecycleHolder = new ReMenRecycleHolder(inflate);
        return reMenRecycleHolder;
    }

    @Override
    public void onBindViewHolder(ReMenRecycleHolder holder, int position) {
        Glide.with(context).load(subject.get(position).getImage()).into(holder.remen_imageview);
        holder.remen_recycler.setLayoutManager(new LinearLayoutManager
                (context,RecyclerView.HORIZONTAL,false));
        reMenItemRecycleViewAdapter = new ReMenItemRecycleViewAdapter
                (context,subject.get(position).getGoodsList(),onClick,position);
        holder.remen_recycler.setAdapter(reMenItemRecycleViewAdapter);
    }

    @Override
    public int getItemCount() {
        return subject.size();
    }
}
