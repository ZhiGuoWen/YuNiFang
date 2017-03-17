package com.wenzhiguo.yunifang.utils;


import java.io.IOException;

import okhttp3.Callback;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by dell on 2017/3/16.
 * 请求数据,调用此方法返回
 */

public class OkHttp {

    private static String htmlstr;
    public static void setHttp(String a, final getData data){
        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //创建一个Request
        final Request request = new Request.Builder()
                .url(a)
                .build();
        //new call
        okhttp3.Call call = mOkHttpClient.newCall(request);
        //请求加入调度
        call.enqueue(new Callback(){


            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                htmlstr = response.body().string();
                data.ruturn(htmlstr);
            }
        });
    }
    public static interface getData{
        void ruturn(String str);
    }
}
