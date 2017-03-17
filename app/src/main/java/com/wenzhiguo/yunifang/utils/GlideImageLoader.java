package com.wenzhiguo.yunifang.utils;


import android.content.Context;
import android.widget.ImageView;

import com.youth.banner.loader.ImageLoader;

/**
 * Created by dell on 2017/3/17.
 */

public class GlideImageLoader extends ImageLoader {

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        com.nostra13.universalimageloader.core.ImageLoader
                .getInstance().displayImage((String) path,imageView);
    }
}
