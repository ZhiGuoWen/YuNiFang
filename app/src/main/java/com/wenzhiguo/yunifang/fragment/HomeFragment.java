package com.wenzhiguo.yunifang.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.wenzhiguo.yunifang.Custom.HomePaint;
import com.wenzhiguo.yunifang.Custom.TitleBar;
import com.wenzhiguo.yunifang.R;
import com.wenzhiguo.yunifang.activity.HomeWebViewActivity;
import com.wenzhiguo.yunifang.activity.MatterActivity;
import com.wenzhiguo.yunifang.activity.MoreActivity;
import com.wenzhiguo.yunifang.adapter.MyListViewAdapter;
import com.wenzhiguo.yunifang.adapter.ReMenRecycleAdapter;
import com.wenzhiguo.yunifang.bean.HomeBean;
import com.wenzhiguo.yunifang.intefact.RecyclerOnClick;
import com.wenzhiguo.yunifang.utils.GlideImageLoader;
import com.wenzhiguo.yunifang.utils.NetUtils;
import com.wenzhiguo.yunifang.utils.OkHttp;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页展示fragment
 */
public class HomeFragment extends Fragment implements OkHttp.getData{
    private PullToRefreshScrollView mPullToScroll;
    private static final int REQUEST_CODE = 0;
    private GridView mButtomGridView;
    private List<String> mImageViewUrl = new ArrayList<>();
    private List<String> mKeepImageViewUrl = new ArrayList<>();
    private List<String> mWebViewUrl = new ArrayList<>();
    private RecyclerView mHomeRecycler;
    private GridView mGridView;
    private HomePaint mHomePaint;
    private View inflate;
    private List<HomeBean.DataBean.DefaultGoodsListBean> defaultGoodsList;
    private List<HomeBean.DataBean.SubjectsBean> subject = null;
    private List<HomeBean.DataBean.ActivityInfoBean.ActivityInfoListBean> activityInfoList;
    private List<HomeBean.DataBean.SubjectsBean.GoodsListBean> goodsList;
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //刷新完成
            Gson gson = new Gson();
            String s = (String) msg.obj;
            HomeBean homeBean = gson.fromJson(s, HomeBean.class);
            //顶部的无限轮播集合
            List<HomeBean.DataBean.Ad1Bean> ad1 = homeBean.getData().getAd1();
            for (int i = 0; i < ad1.size(); i++) {
                mImageViewUrl.add(ad1.get(i).getImage());
                mWebViewUrl.add(ad1.get(i).getAd_type_dynamic_data());
            }
            //本周热销集合
            defaultGoodsList = homeBean.getData().getDefaultGoodsList();
            //优惠活动无线轮播集合
            activityInfoList = homeBean.getData().getActivityInfo().getActivityInfoList();
            for (int i = 0; i < activityInfoList.size(); i++) {
                mKeepImageViewUrl.add(activityInfoList.get(i).getActivityImg());
            }
            //热门下的集合
            subject = homeBean.getData().getSubjects();
            //初始化控件
            initView();
        }
    };
    private TextView mMore;

    /**
     * 主要用来判断网络，没有网去设置页面开数据
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_home, container, false);
        //判断是否连网   如果有网进行请求数据，没有网进行设置页面启动网络
        boolean networkConnected = NetUtils.isNetworkConnected(getActivity());
        if (!networkConnected) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setIcon(R.drawable.ic_launcher);
            builder.setTitle("-- 网络 --");
            builder.setMessage("是否去连网！");
            //否认
            builder.setNegativeButton("退出程序", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    getActivity().finish();
                }
            });
            //确认
            builder.setPositiveButton("确定设置", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(Settings.ACTION_SETTINGS);
                    startActivity(intent);
                }
            });
            builder.show();
        } else {
            OkHttp.setHttp("http://m.yunifang.com/yunifang/mobile/home?" +
                    "random=84831&encode=9dd34239798e8cb22bf99a75d1882447", HomeFragment.this);
        }
        return inflate;
    }

    /**
     * 找控件以及设置设配器等
     */
    private void initView() {
        //more
        mMore = (TextView) inflate.findViewById(R.id.home_textview);
        //监听查看更多
        mMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MoreActivity.class);
                startActivity(intent);
            }
        });
        /*//刷新
        mPullToScroll = (PullToRefreshScrollView) inflate.findViewById(R.id.home_scrollview);
        //设置能够支持刷新模式
        mPullToScroll.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        //上拉监听函数
        mPullToScroll.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ScrollView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {
                //从新请求数据
                OkHttp.setHttp("http://m.yunifang.com/yunifang/mobile/home?" +
                        "random=84831&encode=9dd34239798e8cb22bf99a75d1882447", HomeFragment.this);
                handler.sendEmptyMessageAtTime(0,3000);
                Toast.makeText(getActivity(), "++++++", Toast.LENGTH_SHORT).show();
            }
        });*/
        //热门专题下RecyclerView
        mHomeRecycler = (RecyclerView) inflate.findViewById(R.id.home_recyclerview);
        //设置模式
        mHomeRecycler.setLayoutManager(new LinearLayoutManager
                (getActivity(), RecyclerView.VERTICAL, false));
        ReMenRecycleAdapter mHomeRecyclerAdapter = new ReMenRecycleAdapter
                (getActivity(), subject, new RecyclerOnClick() {
                    @Override
                    public void setOnClickListen(int aPosition,int bPosition) {
                        Intent intent = new Intent(getActivity(), MatterActivity.class);
                        intent.putExtra("imageurl",subject.get(aPosition).getGoodsList().get(bPosition).getGoods_img());
                        intent.putExtra("name",subject.get(aPosition).getGoodsList().get(bPosition).getGoods_name());
                        intent.putExtra("price",subject.get(aPosition).getGoodsList().get(bPosition).getShop_price()+"");
                        intent.putExtra("market",subject.get(aPosition).getGoodsList().get(bPosition).getMarket_price()+"");
                        startActivity(intent);
                    }
                });
        mHomeRecycler.setAdapter(mHomeRecyclerAdapter);
        //自定义标头控件
        TitleBar mTitleBar = (TitleBar) inflate.findViewById(R.id.titlebar);
        //扫一扫
        ImageView mImageView = (ImageView) mTitleBar.findViewById(R.id.title_image);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到扫一扫
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        //自定义返回顶部控件
        mHomePaint = (HomePaint) inflate.findViewById(R.id.backTop);
        //listview控件
        mGridView = (GridView) inflate.findViewById(R.id.home_listview);
        //设置GridView宽的次数
        mGridView.setNumColumns(defaultGoodsList.size());
        //本周热销适配器
        MyListViewAdapter myListViewAdapter = new MyListViewAdapter(getActivity(), defaultGoodsList);
        mGridView.setAdapter(myListViewAdapter);
        //本周热销监听事件
        setGridViewOnClick();
        //顶部无限轮播
        Banner banner = (Banner) inflate.findViewById(R.id.login_linebanner);
        setBanner(banner, mImageViewUrl);
        //监听事件
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Intent intent = new Intent(getActivity(), HomeWebViewActivity.class);
                intent.putExtra("url", mWebViewUrl.get(position));
                startActivity(intent);
            }
        });
        //优惠活动无线轮播
        Banner yBanner = (Banner) inflate.findViewById(R.id.youhui_banner);
        yBanner.setBannerAnimation(Transformer.Tablet);
        //手动轮播
        //yBanner.isAutoPlay(false);
        setBanner(yBanner, mKeepImageViewUrl);
    }

    //本周热销监听事件
    private void setGridViewOnClick() {
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), MatterActivity.class);
                intent.putExtra("imageurl", defaultGoodsList.get(position).getGoods_img());
                intent.putExtra("name", defaultGoodsList.get(position).getGoods_name());
                intent.putExtra("price", defaultGoodsList.get(position).getShop_price() + "");
                intent.putExtra("market", defaultGoodsList.get(position).getMarket_price() + "");
                startActivity(intent);
            }
        });
    }

    /**
     * 无限轮播
     */
    private void setBanner(Banner banner, List<String> list) {
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(list);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    /**
     * 继承的接口返回请求完的数据进行解析
     */
    @Override
    public void ruturn(String str) {
        Message msg = Message.obtain();
        msg.obj = str;
        handler.sendMessage(msg);
    }

    //扫一扫结果
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(getActivity(), "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(getActivity(), "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
