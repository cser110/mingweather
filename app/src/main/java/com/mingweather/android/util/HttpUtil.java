package com.mingweather.android.util;

import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2018/9/17.
 */

public class HttpUtil {
    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
