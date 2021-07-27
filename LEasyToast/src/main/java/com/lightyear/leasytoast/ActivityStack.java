package com.lightyear.leasytoast;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
*ActivityStack
*ctivity 生命周期监控
*author Light Year
*email 674919909@qq.com
* created 2021/7/27
*
*/
final class ActivityStack implements Application.ActivityLifecycleCallbacks {

    /**
     * 注册
     */
    static ActivityStack register(Application application) {
        ActivityStack lifecycle = new ActivityStack();
        application.registerActivityLifecycleCallbacks(lifecycle);
        return lifecycle;
    }

    /** 前台 Activity 对象 */
    private Activity mForegroundActivity;

    public Activity getForegroundActivity() {
        return mForegroundActivity;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {}

    @Override
    public void onActivityStarted(Activity activity) {}

    @Override
    public void onActivityResumed(Activity activity) {
        mForegroundActivity = activity;
    }

    @Override
    public void onActivityPaused(Activity activity) {
        if (mForegroundActivity != activity) {
            return;
        }
        mForegroundActivity = null;
    }

    @Override
    public void onActivityStopped(Activity activity) {}

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {}

    @Override
    public void onActivityDestroyed(Activity activity) {}
}