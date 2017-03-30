package com.wenzhiguo.yunifang.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.wenzhiguo.yunifang.R;

/**
 * 无限轮播点击跳转查看当前页详细信息
 */
public class HomeWebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_web_view);
        //接受传值
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        //找控件
        WebView web = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = web.getSettings();
        //支持js交互
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setJavaScriptEnabled(true);
        //加载路径
        web.loadUrl(url);
        //设置本地链接加载
        web.setWebViewClient(new WebViewClient());
    }
}
