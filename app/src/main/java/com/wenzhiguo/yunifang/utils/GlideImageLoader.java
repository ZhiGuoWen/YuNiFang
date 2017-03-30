package com.wenzhiguo.yunifang.utils;


import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by dell on 2017/3/17.
 * 使用banner加载无线轮播实现图片，
 * 如果使用imageview加载时，图片后面有一小截出现后面一张图片
 */

public class GlideImageLoader extends ImageLoader {

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path).into(imageView);
    }
}
