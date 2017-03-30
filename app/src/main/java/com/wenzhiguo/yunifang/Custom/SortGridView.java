package com.wenzhiguo.yunifang.Custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by dell on 2017/3/27.
 */

public class SortGridView extends GridView {

    public SortGridView(Context context) {
        super(context);
    }

    public SortGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SortGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec=MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
