package com.wenzhiguo.yunifang.activity;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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

import com.uuzuche.lib_zxing.activity.ZXingLibrary;
import com.wenzhiguo.yunifang.R;
import com.wenzhiguo.yunifang.fragment.HomeFragment;
import com.wenzhiguo.yunifang.fragment.PersonalFragment;
import com.wenzhiguo.yunifang.fragment.ShoppingFragment;
import com.wenzhiguo.yunifang.fragment.SortFragment;

import org.litepal.tablemanager.Connector;

import static com.wenzhiguo.yunifang.R.id.home_line;

/**
 * 主要加载底部导航栏，跟fragment切换
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
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
    private FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //扫一扫
        ZXingLibrary.initDisplayOpinion(this);
        setContentView(R.layout.activity_main);
        //创建数据库
        SQLiteDatabase database = Connector.getDatabase();
        supportFragmentManager = getSupportFragmentManager();
        initView();
        if (homeFragment == null) {
            homeFragment = new HomeFragment();
        }
        setFragment(homeFragment, "homeFragment");
    }
    /**
     * 找控件
     */
    private void initView() {
        relativeLayout = (RelativeLayout) findViewById(R.id.activity_main);
        framelayout = (FrameLayout) findViewById(R.id.framelayout);
        //LinearLayout
        home = (LinearLayout) findViewById(home_line);
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

    /**
     * 当按下第一次返回键的时候，一次一次返回栈里面的一层一层返回，
     * 当放回到首页给个提示不退出，5秒之内再按直接退出程序
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //退出当前回退栈里面的个数
            int backStackEntryCount = supportFragmentManager.getBackStackEntryCount();
            if (backStackEntryCount > 1) {
                supportFragmentManager.popBackStackImmediate();
                FragmentManager.BackStackEntry back = supportFragmentManager.getBackStackEntryAt(
                        supportFragmentManager.getBackStackEntryCount() - 1);
                //获取当前栈顶fragment标记值
                String name = back.getName();
                if (name.equals("homeFragment")){
                    setBackgroup(0);
                }else if(name.equals("shoppingFragment")){
                    setBackgroup(2);
                }else if (name.equals("sortFragment")){
                    setBackgroup(1);
                }else if (name.equals("personalFragment")){
                    setBackgroup(3);
                }
            } else {
                if ((System.currentTimeMillis() - mExitTime) > 5000) {
                    // 如果两次按键时间间隔大于2000毫秒，则不退出
                    Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                    mExitTime = System.currentTimeMillis();// 更新mExitTime
                } else {
                    System.exit(0);// 否则退出程序
                }
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 设置选中背景颜色
     */
    public void setBackgroup(int a) {
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

    /**
     * 设置选中开启事务切换fragment
     */
    public void setFragment(Fragment f, String tag) {
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        if (fragment != null) {
            transaction.hide(fragment);
        }
        if (!f.isAdded()) {
            transaction.replace(R.id.framelayout, f, tag);
        }
        transaction.addToBackStack(tag);
        transaction.show(f);
        transaction.commit();
        fragment = f;
    }
    /**
     * 设置监听事件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case home_line:
                setBackgroup(0);
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                }
                setFragment(homeFragment, "homeFragment");
                break;
            case R.id.video_line:
                setBackgroup(1);
                if (sortFragment == null) {
                    sortFragment = new SortFragment();
                }
                setFragment(sortFragment, "sortFragment");
                break;
            case R.id.care_line:
                setBackgroup(2);
                if (shoppingFragment == null) {
                    shoppingFragment = new ShoppingFragment();
                }
                setFragment(shoppingFragment, "shoppingFragment");
                break;
            case R.id.login_line:
                setBackgroup(3);
                if (personalFragment == null) {
                    personalFragment = new PersonalFragment();
                }
                setFragment(personalFragment, "personalFragment");
                break;
        }
    }
}
