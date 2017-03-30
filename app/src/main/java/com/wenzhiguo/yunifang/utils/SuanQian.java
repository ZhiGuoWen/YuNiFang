package com.wenzhiguo.yunifang.utils;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.wenzhiguo.yunifang.bean.ShoppingBean;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by dell on 2017/3/28.
 */

public class SuanQian {

    private static String format;

    //计算价格
    public static int setPrice(List<ShoppingBean> mShopping,TextView mSum, Button mSettle, CheckBox isCheck) {
        float sum = 0;
        int count = 0;
        for (int i = 0; i < mShopping.size(); i++) {
            //从集合里面拿出是否选中状态，如何选中就计算
            boolean check = mShopping.get(i).isChecked();
            String price = mShopping.get(i).getPrice();
            if (check) {
                float v = Float.parseFloat(price);
                sum = sum + v;
                DecimalFormat decimalFormat = new DecimalFormat(".00");
                //返回两位字符串
                format = decimalFormat.format(sum);
                count++;
            }
        }
        mSum.setText("总价:￥"+format);
        mSettle.setText("结算("+count+")");
        if (count == mShopping.size()){
            isCheck.setChecked(true);
        }else if(count == 0){
            mSum.setText("总价:￥"+0);
        }
        isCheck.setChecked(false);
        return count;
    }
}
