package com.lightyear.leasytoast.config;

import android.content.Context;
import android.view.Gravity;
import android.view.View;

/**
*IToastStyle
*默认样式接口
*author Light Year
*email 674919909@qq.com
* created 2021/7/27
*
*/
public interface IToastStyle<V extends View> {

    /**
     * 创建 Toast 视图
     */
    V createView(Context context);

    /**
     * 获取 Toast 显示重心
     */
    default int getGravity() {
        return Gravity.CENTER;
    }

    /**
     * 获取 Toast 水平偏移
     */
    default int getXOffset() {
        return 0;
    }

    /**
     * 获取 Toast 垂直偏移
     */
    default int getYOffset() {
        return 0;
    }

    /**
     * 获取 Toast 水平间距
     */
    default float getHorizontalMargin() {
        return 0;
    }

    /**
     * 获取 Toast 垂直间距
     */
    default float getVerticalMargin() {
        return 0;
    }
}