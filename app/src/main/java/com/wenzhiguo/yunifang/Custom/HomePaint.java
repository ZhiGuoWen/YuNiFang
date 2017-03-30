package com.wenzhiguo.yunifang.Custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by dell on 2017/3/19.
 * 自定义画首页的圆圈点击能够返回到顶部
 */

public class HomePaint extends ImageView {
    private Paint paint ;
    public HomePaint(Context context) {
        super(context);
    }

    public HomePaint(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStrokeWidth(5);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(40,35,30,paint);
        paint.setColor(Color.YELLOW);
        canvas.drawLine(40,20,25,35,paint);
        canvas.drawLine(40,20,55,35,paint);
        canvas.drawLine(40,20,40,55,paint);

    }
}
