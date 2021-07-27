package com.lightyear.leasytoasttest;

import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.Gravity;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.lightyear.leasytoast.ToastUtils;
import com.lightyear.leasytoast.style.BlackToastStyle;
import com.lightyear.leasytoast.style.WhiteToastStyle;

import java.util.Locale;

/**
*ToastActivity
* 使用Toast案例
*author Light Year
*email 674919909@qq.com
* created 2021/7/27
*
*/
public final class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
    }

    public void show1(View v) {
        Locale locale=getSysPreferredLocale();
        Log.i("jackie",","+locale.toString());
        ToastUtils.show("我是普通的 Toast");
    }

    @SuppressWarnings("AlibabaAvoidManuallyCreateThread")
    public void show2(View v) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                ToastUtils.show("我是子线程中弹出的吐司");
            }
        }).start();
    }

    public void show3(View v) {
        ToastUtils.setStyle(new WhiteToastStyle());
        ToastUtils.show("动态切换白色吐司样式成功");
    }

    public void show4(View v) {
        ToastUtils.setStyle(new BlackToastStyle());
        ToastUtils.show("动态切换黑色吐司样式成功");
    }

    public void show5(View v) {
        ToastUtils.setView(R.layout.toast_custom_view);
        ToastUtils.setGravity(Gravity.CENTER);
        ToastUtils.show("自定义 Toast 布局");
    }

    public void show6(View v) {
//        if (XXPermissions.isGranted(this, Permission.NOTIFICATION_SERVICE)) {
//
//            Snackbar.make(getWindow().getDecorView(), "正在准备跳转到手机桌面，请注意有极少数机型无法在后台显示 Toast", Snackbar.LENGTH_SHORT).show();
//
//            v.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    Intent intent = new Intent(Intent.ACTION_MAIN);
//                    intent.addCategory(Intent.CATEGORY_HOME);
//                    startActivity(intent);
//                }
//            }, 2000);
//
//            v.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
//                        ToastUtils.show("我是在后台显示的 Toast（在 Android 11 上只能跟随系统 Toast 样式）");
//                    } else {
//                        ToastUtils.show("我是在后台显示的 Toast");
//                    }
//                }
//            }, 3000);
//
//        } else {
//
//            ToastUtils.show("在后台显示 Toast 需要先获取通知栏权限");
//            v.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    XXPermissions.startPermissionActivity(ToastActivity.this, Permission.NOTIFICATION_SERVICE);
//                }
//            }, 2000);
//        }
    }

    public void show7(View v) {
//        new XToast<>(ToastActivity.this)
//                .setDuration(1000)
//                .setView(ToastUtils.getStyle().createView(getApplication()))
//                .setAnimStyle(android.R.style.Animation_Translucent)
//                .setText(android.R.id.message, "就问你溜不溜")
//                .setGravity(Gravity.BOTTOM)
//                .setYOffset((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics()))
//                .show();
    }

    public Locale getSysPreferredLocale() {
        Locale locale;
        //7.0以下直接获取系统默认语言
        if (Build.VERSION.SDK_INT < 24) {
            // 等同于context.getResources().getConfiguration().locale;
            locale = Locale.getDefault();
            // 7.0以上获取系统首选语言
        } else {
            LocaleList defaultLocaleList = LocaleList.getDefault();
            StringBuffer sb0 = new StringBuffer();
            for (int i = 0; i < defaultLocaleList.size(); i++) {
                sb0.append(defaultLocaleList.get(i));
                sb0.append(",");
            }
            Log.d("jackie", "LocaleList.getDefault()        : " + sb0.toString());

            LocaleList list = getResources().getConfiguration().getLocales();
            StringBuffer sb1 = new StringBuffer();
            for (int i = 0; i < list.size(); i++) {
                sb1.append(list.get(i));
                sb1.append(",");
            }
            Log.d("jackie", "Configuration.getLocales()     : " + sb1.toString());

            LocaleList adjustedDefaultLocaleList = LocaleList.getAdjustedDefault();
            StringBuffer sb2 = new StringBuffer();
            for (int i = 0; i < adjustedDefaultLocaleList.size(); i++) {
                sb2.append(adjustedDefaultLocaleList.get(i));
                sb2.append(",");
            }
            Log.d("jackie", "LocaleList.getAdjustedDefault(): " + sb2.toString());

            locale = defaultLocaleList.get(0);
        }
        return locale;
    }
}