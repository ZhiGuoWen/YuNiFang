package com.wenzhiguo.yunifang;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.x;

/**
 * 软件已开启初始化一些数据
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
        ImageLoaderConfiguration cuf = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(cuf);
    }
}
