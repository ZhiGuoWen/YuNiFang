package com.wenzhiguo.yunifang.Custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wenzhiguo.yunifang.R;

/**
 * Created by dell on 2017/3/16.
 * 自定义控件标头
 */

public class TitleBar extends RelativeLayout {
    public TitleBar(Context context) {
        super(context);
    }

    public TitleBar(final Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.titlebar_item, this, true);

        ImageView image = (ImageView) view.findViewById(R.id.title_image);
        TextView text = (TextView) view.findViewById(R.id.title_text);
        TextView search = (TextView) view.findViewById(R.id.title_search);

        TypedArray typedArray = context.getResources().obtainAttributes(attrs, R.styleable.TitleBar);
        if (typedArray != null) {
            //search
            int colors = typedArray.getColor(R.styleable.TitleBar_mTextSearchBackgroup, Color.WHITE);
            search.setBackgroundColor(colors);
            int colorsc = typedArray.getColor(R.styleable.TitleBar_mSearchBackgroup, Color.WHITE);
            search.setBackgroundColor(colorsc);
            String strings = typedArray.getString(R.styleable.TitleBar_mTextSearch);
            search.setText(strings);
            float dimensionsize = typedArray.getDimension(R.styleable.TitleBar_mTextSearchSize, 20);
            search.setTextSize(dimensionsize);
            int pading =(int)typedArray.getDimension(R.styleable.TitleBar_mTextSearchPadding, 20);
            search.setPadding(pading,pading,pading,pading);
            //imageview
            Drawable drawable = typedArray.getDrawable(R.styleable.TitleBar_img_imageView);
            image.setImageDrawable(drawable);
            //textview
            String string = typedArray.getString(R.styleable.TitleBar_mText);
            text.setText(string);
            int colort = typedArray.getColor(R.styleable.TitleBar_mTextBackgroup, Color.WHITE);
            text.setBackgroundColor(colort);
            int colortr = typedArray.getColor(R.styleable.TitleBar_mBackgroup, Color.WHITE);
            text.setBackgroundColor(colortr);
            float dimension = typedArray.getDimension(R.styleable.TitleBar_mTextSize, 20);
            search.setTextSize(dimension);
        }
        typedArray.recycle();
    }
}
