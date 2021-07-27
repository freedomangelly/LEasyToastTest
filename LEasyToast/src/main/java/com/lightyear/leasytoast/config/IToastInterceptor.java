package com.lightyear.leasytoast.config;

/**
*IToastInterceptor
*Toast 拦截器接口
*author Light Year
*email 674919909@qq.com
* created 2021/7/27
*
*/
public interface IToastInterceptor {

    /**
     * 根据显示的文本决定是否拦截该 Toast
     */
    boolean intercept(CharSequence text);
}