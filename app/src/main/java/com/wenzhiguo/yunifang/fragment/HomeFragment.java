package com.wenzhiguo.yunifang.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.wenzhiguo.yunifang.R;
import com.wenzhiguo.yunifang.bean.HomeBean;
import com.wenzhiguo.yunifang.utils.OkHttp;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页展示fragment
 */
public class HomeFragment extends Fragment implements OkHttp.getData {
    private List<String> mImageViewUrl = new ArrayList<>();
    private View inflate;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                Gson gson = new Gson();
                HomeBean homeBean = gson.fromJson((String) msg.obj, HomeBean.class);
                List<HomeBean.DataBean.Ad1Bean> ad1 = homeBean.getData().getAd1();
                for (int i = 0; i < ad1.size(); i++) {
                    mImageViewUrl.add(ad1.get(i).getImage());
                }
            }

        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_home, container, false);
        //请求数据
        OkHttp.setHttp("http://m.yunifang.com/yunifang/mobile/home?" +
                "random=84831&encode=9dd34239798e8cb22bf99a75d1882447", HomeFragment.this);
       // initView();
        return inflate;
    }

    /*private void initView() {
        TitleBar titleBar = (TitleBar) inflate.findViewById(R.id.titlebar);
        Banner banner=(Banner)inflate.findViewById(R.id.login_linebanner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(mImageViewUrl);
        //监听事件
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(getActivity(), ""+position , Toast.LENGTH_SHORT).show();
            }
        });
        //banner设置方法全部调用完毕时最后调用
        banner.start();

    }*/

    /**
     * 继承的接口返回请求完的数据进行解析
     */
    @Override
    public void ruturn(String str) {
        Message msg = Message.obtain();
        msg.obj = str;
        msg.what = 0;
        handler.sendMessage(msg);
    }
}
