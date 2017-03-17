package com.wenzhiguo.yunifang.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wenzhiguo.yunifang.R;
import com.wenzhiguo.yunifang.fragment.HomeFragment;
import com.wenzhiguo.yunifang.fragment.PersonalFragment;
import com.wenzhiguo.yunifang.fragment.ShoppingFragment;
import com.wenzhiguo.yunifang.fragment.SortFragment;

/**
 * 主要加载底部导航栏
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private long mExitTime = 0;
    //LinearLayout
    private FrameLayout framelayout;
    private LinearLayout home;
    private LinearLayout video;
    private LinearLayout care;
    private LinearLayout login;
    //ImageView
    private ImageView home_image;
    private ImageView video_image;
    private ImageView care_image;
    private ImageView login_image;
    //TextView
    private TextView home_text;
    private TextView video_text;
    private TextView care_text;
    private TextView login_text;
    //数组
    int[] bai = {R.drawable.bottom_tab_home_normal, R.drawable.bottom_tab_classify_normal, R.drawable.bottom_tab_shopping_normal, R.drawable.bottom_tab_user_normal};
    int[] hong = {R.drawable.bottom_tab_home_selected, R.drawable.bottom_tab_classify_selected, R.drawable.bottom_tab_shopping_selected, R.drawable.bottom_tab_user_selected};
    ImageView[] imageview;
    TextView[] textview;
    private ActionBar supportActionBar;
    //Fragment
    HomeFragment homeFragment;
    SortFragment sortFragment;
    ShoppingFragment shoppingFragment;
    PersonalFragment personalFragment;
    Fragment fragment;
    private RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        if (homeFragment == null) {
            homeFragment = new HomeFragment();
        }
        setFragment(homeFragment);
    }

    private void initView() {
        relativeLayout = (RelativeLayout) findViewById(R.id.activity_main);
        framelayout = (FrameLayout) findViewById(R.id.framelayout);
        //LinearLayout
        home = (LinearLayout) findViewById(R.id.home_line);
        video = (LinearLayout) findViewById(R.id.video_line);
        care = (LinearLayout) findViewById(R.id.care_line);
        login = (LinearLayout) findViewById(R.id.login_line);
        //ImageView
        home_image = (ImageView) findViewById(R.id.home_image);
        video_image = (ImageView) findViewById(R.id.video_image);
        care_image = (ImageView) findViewById(R.id.care_image);
        login_image = (ImageView) findViewById(R.id.login_image);
        //TextView
        home_text = (TextView) findViewById(R.id.home_text);
        video_text = (TextView) findViewById(R.id.video_text);
        care_text = (TextView) findViewById(R.id.care_text);
        login_text = (TextView) findViewById(R.id.login_text);
        //监听
        home.setOnClickListener(this);
        video.setOnClickListener(this);
        care.setOnClickListener(this);
        login.setOnClickListener(this);
        //数组
        imageview = new ImageView[]{home_image, video_image, care_image, login_image};
        textview = new TextView[]{home_text, video_text, care_text, login_text};
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 5000) {
                // 如果两次按键时间间隔大于2000毫秒，则不退出
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();// 更新mExitTime
            } else {
                System.exit(0);// 否则退出程序
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home_line:
                setBackgroup(0);
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                }
                setFragment(homeFragment);
                break;
            case R.id.video_line:
                setBackgroup(1);
                if (sortFragment == null) {
                    sortFragment = new SortFragment();
                }
                setFragment(sortFragment);
                break;
            case R.id.care_line:
                setBackgroup(2);
                if (shoppingFragment == null) {
                    shoppingFragment = new ShoppingFragment();
                }
                setFragment(shoppingFragment);
                break;
            case R.id.login_line:
                setBackgroup(3);
                if (personalFragment == null) {
                    personalFragment = new PersonalFragment();
                }
                setFragment(personalFragment);
                break;
        }
    }
    private void setBackgroup(int a) {
        for (int i = 0; i < bai.length; i++) {
            if (a == i) {
                imageview[a].setImageResource(hong[a]);
                textview[a].setTextColor(Color.RED);
            } else {
                imageview[i].setImageResource(bai[i]);
                textview[i].setTextColor(Color.BLACK);
            }
        }
    }

    private void setFragment(Fragment f) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragment != null) {
            transaction.hide(fragment);
        }
        if (!f.isAdded()) {
            transaction.add(R.id.framelayout, f);
        }
        transaction.show(f);
        transaction.commit();
        fragment = f;
    }
}
