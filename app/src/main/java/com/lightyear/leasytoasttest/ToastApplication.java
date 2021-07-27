package com.lightyear.leasytoasttest;

import android.app.Application;

import com.lightyear.leasytoast.ToastUtils;
import com.lightyear.leasytoast.applications.ToastInterceptor;


/**
*ToastApplication
* Applicaton需要初始化案例
*author Light Year
*email 674919909@qq.com
* created 2021/7/27
*
*/
public final class ToastApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // 设置 Toast 拦截器
        ToastUtils.setInterceptor(new ToastInterceptor());
        // 初始化 Toast 框架
        ToastUtils.init(this);
    }
}