package com.wenzhiguo.yunifang.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wenzhiguo.yunifang.R;
import com.wenzhiguo.yunifang.bean.ShoppingBean;
import com.wenzhiguo.yunifang.intefact.CheckBoxOnClick;
import com.wenzhiguo.yunifang.utils.SuanQian;
import com.wenzhiguo.yunifang.viewholder.ShoppingHolder;

import java.util.HashSet;
import java.util.List;

/**
 * Created by dell on 2017/3/28.
 * 购物车适配器
 */

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingHolder> {
    private final Context connect;
    private final List<ShoppingBean> mShopping;
    private final TextView mSum;
    private final Button mSettle;
    private final CheckBox isCheck;
    private final CheckBoxOnClick onClick;
    private HashSet<Integer> int1 = new HashSet<>();

    public ShoppingAdapter(Context context, List<ShoppingBean> mShopping,
                           TextView mSum, Button mSettle, CheckBox isCheck, CheckBoxOnClick onClick) {
        this.connect = context;
        this.onClick = onClick;
        this.mShopping = mShopping;
        this.mSum = mSum;
        this.mSettle = mSettle;
        this.isCheck = isCheck;
    }

    @Override
    public ShoppingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(connect).inflate(R.layout.shopcat_item, parent, false);
        ShoppingHolder shoppingHolder = new ShoppingHolder(inflate);
        return shoppingHolder;
    }

    @Override
    public void onBindViewHolder(final ShoppingHolder holder, final int position) {
        Glide.with(connect).load(mShopping.get(position).getImageViewUrl()).into(holder.mImageView);
        holder.mName.setText(mShopping.get(position).getTitle());
        holder.mPrice.setText("价格:￥" + mShopping.get(position).getPrice());
        holder.mCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断一下当前是否选中
                boolean checked = holder.mCheck.isChecked();
                //设置给集合赋值
                mShopping.get(position).setChecked(checked);
                //重新设置价格
                SuanQian.setPrice(mShopping, mSum, mSettle, isCheck);
                //如果当前选中添加到集合里面
                if (checked) {
                    int1.add(position);
                }else {
                    int1.remove(position);
                }
                Log.d("Message", "商品下标数据库" + int1.toString());
                onClick.checkBoxClick(int1);
            }
        });
        //设置是否选中
        holder.mCheck.setChecked(mShopping.get(position).isChecked());
    }

    @Override
    public int getItemCount() {
        return mShopping.size();
    }

}
