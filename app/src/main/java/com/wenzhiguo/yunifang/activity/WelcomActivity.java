package com.wenzhiguo.yunifang.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wenzhiguo.yunifang.R;

/**
 * 引导页面和欢迎页面
 */
public class WelcomActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TextView mTextView;
    private RelativeLayout mRela;
    private int[] mTu = new int[]{R.drawable.guidance_1, R.drawable.guidance_2
            , R.drawable.guidance_3, R.drawable.guidance_4,
            R.drawable.guidance_5,R.drawable.ldy};
    private SharedPreferences sp;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Intent intent = new Intent(WelcomActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        //找控件方法
        initView();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTextView = (TextView) findViewById(R.id.welcome_text);
        mRela = (RelativeLayout) findViewById(R.id.activity_welcom);
        //记录是否是第一次加载
        sp = getSharedPreferences("wenzhiguo", MODE_PRIVATE);
        String isOne = sp.getString("isOne", "0");
        //如果第一次加载有引导页，不是第一次加载一张图片
        if ("0".equals(isOne)) {
            setViewPager();
            SharedPreferences.Editor edit = sp.edit();
            edit.putString("isOne","1");
            edit.commit();
        }else {
            ImageView mImage = new ImageView(WelcomActivity.this);
            mImage.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            mImage.setScaleType(ImageView.ScaleType.FIT_XY);
            mImage.setImageResource(R.drawable.ldy);
            mRela.addView(mImage);
            //发送跳转延迟3秒
            handler.sendEmptyMessageDelayed(0,3000);
        }
    }

    private void setViewPager() {
        //设置适配器viewpager
        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return mTu.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView mImage = new ImageView(WelcomActivity.this);
                mImage.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                mImage.setScaleType(ImageView.ScaleType.FIT_XY);
                mImage.setImageResource(mTu[position]);
                mViewPager.addView(mImage);
                return mImage;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                mViewPager.removeView((View) object);
            }
        });
        //设置监听事件viewpager
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == mTu.length-1) {
                    //显示textview
                    mTextView.setVisibility(View.VISIBLE);
                    //发送跳转延迟3秒
                    handler.sendEmptyMessageDelayed(0,3000);
                    mTextView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(WelcomActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                            handler.removeMessages(0);
                        }
                    });
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}