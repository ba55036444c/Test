package com.example.test.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;


/**
 * 监听网络变化的广播
 */
public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (!NetworkUtils.isConnected()) {
            LogUtils.i("xx", "aaa");
        } else {
            LogUtils.i("xx", "ccc");
        }
    }

}
