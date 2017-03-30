package com.wenzhiguo.yunifang.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wenzhiguo.yunifang.Custom.TitleBar;
import com.wenzhiguo.yunifang.R;
import com.wenzhiguo.yunifang.activity.MainActivity;
import com.wenzhiguo.yunifang.adapter.ShoppingAdapter;
import com.wenzhiguo.yunifang.bean.ShoppingBean;
import com.wenzhiguo.yunifang.intefact.CheckBoxOnClick;
import com.wenzhiguo.yunifang.utils.SuanQian;

import org.litepal.crud.DataSupport;

import java.util.HashSet;
import java.util.List;
/**
 * 购物展示fragment
 */
public class ShoppingFragment extends Fragment implements View.OnClickListener,CheckBoxOnClick{
    public HashSet<Integer> position = new HashSet<>();
    private int compilte = 1;
    private View inflate;
    private TitleBar mTitle;
    private TextView mEdit;
    private LinearLayout mLinePrice;
    private TextView mGuang;
    private HomeFragment homeFragment;
    private List<ShoppingBean> mShopping;
    private RelativeLayout mShoppingRelative;
    private RecyclerView mRecyclerView;
    private ShoppingAdapter shoppingAdapter;
    private CheckBox mAllChecked;
    private TextView mSum;
    private Button mSettle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_shopping, container, false);
        //控件
        initView();
        //从数据库取数据
        mShopping = DataSupport.findAll(ShoppingBean.class);
        if (mShopping!=null){
            mShoppingRelative.setVisibility(View.GONE);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayout.VERTICAL,false));
            setRecyclerView(mShopping);
        }else {
            mRecyclerView.setVisibility(View.GONE);
        }
        return inflate;
    }

    private void initView() {
        //recyclerview控件
        mRecyclerView = (RecyclerView) inflate.findViewById(R.id.shopping_recycler);
        //标头
        mTitle = (TitleBar) inflate.findViewById(R.id.shopping_editer);
        //编辑
        mEdit = (TextView) mTitle.findViewById(R.id.title_search);
        //此隐藏控件
        mLinePrice = (LinearLayout) inflate.findViewById(R.id.shopping_line_price);
        //逛一逛
        mGuang = (TextView) inflate.findViewById(R.id.shopping_relative_guang);
        //全选
        mAllChecked = (CheckBox) inflate.findViewById(R.id.all_checked);
        //总价格
        mSum = (TextView) inflate.findViewById(R.id.shopping_sum);
        //结算
        mSettle = (Button) inflate.findViewById(R.id.shopp_btn);
        //中间图片隐藏控件
        mShoppingRelative = (RelativeLayout) inflate.findViewById(R.id.shoping_relative);
        mEdit.setOnClickListener(this);
        mGuang.setOnClickListener(this);
        mAllChecked.setOnClickListener(this);
        mSettle.setOnClickListener(this);
    }

    private void setRecyclerView(List<ShoppingBean> list){
        shoppingAdapter = new ShoppingAdapter(getActivity(), list, mSum,
                mSettle, mAllChecked,this);
        mRecyclerView.setAdapter(shoppingAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //逛一逛,点击逛一逛返回首页去添加
            case R.id.shopping_relative_guang:
                MainActivity activity = (MainActivity) getActivity();
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                }
                activity.setFragment(homeFragment, "homeFragment");
                activity.setBackgroup(0);
                break;
            //编辑
            case R.id.title_search:
                if (compilte%2==1) {
                    mEdit.setText("完成");
                    mSettle.setText("删除("+SuanQian.setPrice(mShopping, mSum, mSettle, mAllChecked)+")");
                    mSettle.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //遍历集合，从集合里边拿出下标，从集合里面删除
                            //i必须是1因为数据库从1开始拿出
                            // SQLiteException: no such column: 0 (code 1):
                            // while compiling: DELETE FROM shoppingbean WHERE [0]
                            //for (int i =0; i < position.size(); i++) {
                               /* ShoppingBean shop=new ShoppingBean();
                                shop.delete(ShoppingBean.class,i+1);
                                List<ShoppingBean> all = DataSupport.findAll(ShoppingBean.class);
                                setRecyclerView(all);*/
                            for (Integer i:position) {
                                mShopping.remove(i);
                                mSettle.setText("删除("+0+")");
                                mSum.setText("总价格:￥0");
                                Log.d("Message", "-------------------------------"+(i));
                            }
                            shoppingAdapter.notifyDataSetChanged();
                        }
                    });
                    compilte++;
                }else {
                    mEdit.setText("编辑");
                    mSettle.setText("结算("+SuanQian.setPrice(mShopping, mSum, mSettle, mAllChecked)+")");
                    compilte--;
                }
                break;
            //全选
            case R.id.all_checked:
                for (int i = 0; i < mShopping.size(); i++) {
                    //从集合里面拿出是否选中状态，如果是没选中就给设置选中，否则就给设置没选中
                    mShopping.get(i).setChecked(true);
                }
                //刷新适配器
                shoppingAdapter.notifyDataSetChanged();
                //再计算价格
                SuanQian.setPrice(mShopping, mSum, mSettle, mAllChecked);
                break;
            //结算
            case R.id.shopp_btn:

                break;
        }
    }

    @Override
    public void checkBoxClick(HashSet<Integer> position) {
        this.position = position;
    }
}
