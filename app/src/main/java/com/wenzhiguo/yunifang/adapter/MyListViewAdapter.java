package com.wenzhiguo.yunifang.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wenzhiguo.yunifang.R;
import com.wenzhiguo.yunifang.bean.HomeBean;

import java.util.List;

/**
 * Created by dell on 2017/3/18.
 * 本周热销适配器以及优化
 */

public class MyListViewAdapter extends BaseAdapter {
    private Context context;
    private List<HomeBean.DataBean.DefaultGoodsListBean> defaultGoodsList;

    public MyListViewAdapter(Context context,
                             List<HomeBean.DataBean.DefaultGoodsListBean> defaultGoodsList) {
        this.context = context;
        this.defaultGoodsList = defaultGoodsList;
    }

    @Override
    public int getCount() {
        return defaultGoodsList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder vh;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.mylistviewadapter, null);
            vh = new viewHolder();
            vh.image = (ImageView) convertView.findViewById(R.id.adapter_imageview);
            vh.price = (TextView) convertView.findViewById(R.id.adapter_price);
            vh.title = (TextView) convertView.findViewById(R.id.adapter_title);
            vh.drop_price = (TextView) convertView.findViewById(R.id.adapter_dropprice);
            convertView.setTag(vh);
        } else {
            vh = (viewHolder) convertView.getTag();
        }
        //给控件赋值
        Glide.with(context).load(defaultGoodsList.get(position).getGoods_img()).into(vh.image);
        vh.price.setText("￥" + defaultGoodsList.get(position).getShop_price());
        vh.drop_price.setText("￥" + defaultGoodsList.get(position).getMarket_price());
        vh.title.setText(defaultGoodsList.get(position).getGoods_name());
        //中划线
        vh.drop_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        return convertView;
    }
    //优化
    class viewHolder {
        ImageView image;
        TextView title, price, drop_price;
    }
}
