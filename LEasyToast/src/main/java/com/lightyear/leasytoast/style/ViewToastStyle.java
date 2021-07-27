package com.lightyear.leasytoast.style;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import com.lightyear.leasytoast.config.IToastStyle;


/**
*ViewToastStyle
*Toast View 包装样式实现
*author Light Year
*email 674919909@qq.com
* created 2021/7/27
*
*/
public class ViewToastStyle implements IToastStyle<View> {

    private final int mLayoutId;
    private final IToastStyle<?> mStyle;

    public ViewToastStyle(int id, IToastStyle<?> style) {
        mLayoutId = id;
        mStyle = style;
    }

    @Override
    public View createView(Context context) {
        return LayoutInflater.from(context).inflate(mLayoutId, null);
    }

    @Override
    public int getGravity() {
        if (mStyle == null) {
            return Gravity.CENTER;
        }
        return mStyle.getGravity();
    }

    @Override
    public int getXOffset() {
        if (mStyle == null) {
            return 0;
        }
        return mStyle.getXOffset();
    }

    @Override
    public int getYOffset() {
        if (mStyle == null) {
            return 0;
        }
        return mStyle.getYOffset();
    }

    @Override
    public float getHorizontalMargin() {
        if (mStyle == null) {
            return 0;
        }
        return mStyle.getHorizontalMargin();
    }

    @Override
    public float getVerticalMargin() {
        if (mStyle == null) {
            return 0;
        }
        return mStyle.getVerticalMargin();
    }
}