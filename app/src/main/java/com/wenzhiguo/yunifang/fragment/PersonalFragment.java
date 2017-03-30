package com.wenzhiguo.yunifang.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.tencent.connect.UserInfo;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import com.wenzhiguo.yunifang.Custom.TitleBar;
import com.wenzhiguo.yunifang.R;
import com.wenzhiguo.yunifang.activity.MapActivity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 个人展示fragment
 */
public class PersonalFragment extends Fragment implements View.OnClickListener {
    private IUiListener userInfoListener;
    private View inflate;
    private LinearLayout login;
    private TextView mLoginName;
    private ImageView mLoginImage;
    private static final String TAG = "MainActivity";
    private static final String APP_ID = "1105602574";//官方获取的APPID
    //获取权限列表。所有权限为 all
    private static String SCOPE = "all";
    private Tencent mTencent;
    private IUiListener loginListener;
    private UserInfo mUserInfo;
    private TitleBar mMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_personal, container, false);
        //找控件
        initView();
        //初始化QQ登录
        initQqLogin();
        return inflate;
    }

    private void initView() {
        login = (LinearLayout) inflate.findViewById(R.id.line_login);
        mLoginName = (TextView) inflate.findViewById(R.id.login_name);
        mLoginImage = (ImageView) inflate.findViewById(R.id.login_image);
        mMap = (TitleBar) inflate.findViewById(R.id.personal_map);
        login.setOnClickListener(this);
        mMap.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.line_login:
                mTencent.login(this, SCOPE, loginListener);
                break;
            case R.id.personal_map:
                Intent intent = new Intent(getActivity(),MapActivity.class);
                startActivity(intent);
                break;
        }
    }

    //初始化QQ登录分享的需要的资源
    private void initQqLogin() {
        try {
            mTencent = Tencent.createInstance(APP_ID, getActivity());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //创建QQ登录回调接口
        loginListener = new IUiListener() {
            @Override
            public void onComplete(Object o) {

                //登录成功后回调该方法
                Toast.makeText(getActivity(), "登录成功", Toast.LENGTH_SHORT).show();
                SharedPreferences spf = getActivity().getSharedPreferences("myheading", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = spf.edit();
                edit.putBoolean("islogin", true);
                edit.commit();

                //设置openid，如果不设置这一步的话无法获取用户信息
                JSONObject jo = (JSONObject) o;
                String openID;
                try {
                    openID = jo.getString("openid");
                    String accessToken = jo.getString("access_token");
                    String expires = jo.getString("expires_in");
                    mTencent.setOpenId(openID);
                    mTencent.setAccessToken(accessToken, expires);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(UiError uiError) {
                //登录失败后回调该方法
                Toast.makeText(getActivity(), "登录失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
                //取消登录后回调该方法
                Toast.makeText(getActivity(), "取消登录", Toast.LENGTH_SHORT).show();
            }
        };
        //获取用户信息的回调接口
        userInfoListener = new IUiListener() {
            @Override
            public void onComplete(Object o) {
                JSONObject jo = (JSONObject) o;
                try {
                    JSONObject info = (JSONObject) o;
                    //获取用户具体信息
                    String nickName = info.getString("nickname");
                    String figureurl_qq_2 = info.getString("figureurl_qq_2");
                    //隐藏图片  gone与invisible的区别gone只是隐藏，invisible隐藏而且占位位置
                    //QQ回调信息赋值
                    mLoginName.setText(nickName);
                    Glide.with(getActivity()).load(figureurl_qq_2).into(mLoginImage);
                    SharedPreferences sp = getActivity().getSharedPreferences("myheading", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit1 = sp.edit();
                    edit1.putString("qqname", nickName);
                    edit1.putString("qqimg", figureurl_qq_2);
                    edit1.commit();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(UiError uiError) {

            }

            @Override
            public void onCancel() {

            }
        };
    }

    //获取用户信息
    private void getUserInfo() {
        UserInfo info = new UserInfo(getActivity(), mTencent.getQQToken());
        info.getUserInfo(userInfoListener);
    }

    //在调用Login的Activity或者Fragment中重写onActivityResult方法
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
       /* if (requestCode == Constants.REQUEST_LOGIN) {
            Tencent.onActivityResultData(requestCode, resultCode, data, mIUiListener);
        }
        super.onActivityResult(requestCode, resultCode, data);*/
        Tencent.handleResultData(data, loginListener);
        //获取用户信息
        getUserInfo();
    }
}
