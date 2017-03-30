package com.wenzhiguo.yunifang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.wenzhiguo.yunifang.R;
import com.wenzhiguo.yunifang.activity.MatterActivity;
import com.wenzhiguo.yunifang.adapter.SortAdapter;
import com.wenzhiguo.yunifang.bean.SortBean;
import com.wenzhiguo.yunifang.utils.OkHttp;

import java.util.ArrayList;
import java.util.List;

/**
 * 分类展示fragment
 */
public class SortFragment extends Fragment implements OkHttp.getData{

    private View inflate;
    private GridView mSortGridView;
    private ArrayList<String> mGridView = new ArrayList<>();
    private List<SortBean.DataBean.GoodsBriefBean> goodsBrief;
    private GridView mHotGridView;
    private Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String s =(String) msg.obj;
            Gson gson = new Gson();
            SortBean sortBean = gson.fromJson(s, SortBean.class);
            goodsBrief = sortBean.getData().getGoodsBrief();
            SortAdapter sortAdapter = new SortAdapter(getActivity(), goodsBrief);
            mHotGridView.setAdapter(sortAdapter);
            //监听事件
            mHotGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getActivity(), MatterActivity.class);
                    intent.putExtra("imageurl",goodsBrief.get(position).getGoods_img());
                    intent.putExtra("name",goodsBrief.get(position).getGoods_name());
                    intent.putExtra("price",goodsBrief.get(position).getShop_price()+"");
                    intent.putExtra("market",goodsBrief.get(position).getMarket_price()+"");
                    startActivity(intent);
                }
            });
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_sort, container, false);
        //控件
        initView();
        //请求数据
        OkHttp.setHttp("http://m.yunifang.com/yunifang/mobile/category/list?" +
                "random=96333&encode=bf3386e14fe5bb0bcef234baebca2414",SortFragment.this);
        return inflate;
    }

    private void initView() {
        //热销商品
        mHotGridView = (GridView) inflate.findViewById(R.id.sort_hotgridview);
        //热门分类
        mSortGridView = (GridView) inflate.findViewById(R.id.sort_gridview);
        //添加数据
        mGridView.add("补水保湿");
        mGridView.add("美白提亮");
        mGridView.add("石灰套装");
        mGridView.add("贴士面膜");
        mGridView.add("控油祛痘");
        mGridView.add("洁面乳");
        mSortGridView.setAdapter(new MyAdapter(mGridView));
    }
    //返回请求数据
    @Override
    public void ruturn(String str) {
        Message msg = Message.obtain();
        msg.obj = str;
        handler.sendMessage(msg);
    }

    //热门分类适配器
    class MyAdapter extends BaseAdapter {

        private final ArrayList<String> mGridView;

        public MyAdapter(ArrayList<String> mGridView) {
            this.mGridView = mGridView;
        }

        @Override
        public int getCount() {
            return mGridView.size();
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
            convertView = View.inflate(getActivity(), R.layout.sortgridviewitem, null);
            TextView title = (TextView) convertView.findViewById(R.id.sortitem_title);
            title.setText(mGridView.get(position));
            return convertView;
        }
    }
}
