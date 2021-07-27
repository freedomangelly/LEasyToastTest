package com.lightyear.leasytoast.config;

import android.app.Application;

/**
*IToastStrategy
*Toast 处理策略
*author Light Year
*email 674919909@qq.com
* created 2021/7/27
*
*/
public interface IToastStrategy {

    /**
     * 注册策略
     */
    void registerStrategy(Application application);

    /**
     * 绑定样式
     */
    void bindStyle(IToastStyle<?> style);

    /**
     * 创建 Toast
     */
    IToast createToast(Application application);

    /**
     * 显示 Toast
     */
    void showToast(CharSequence text);

    /**
     * 取消 Toast
     */
    void cancelToast();
}