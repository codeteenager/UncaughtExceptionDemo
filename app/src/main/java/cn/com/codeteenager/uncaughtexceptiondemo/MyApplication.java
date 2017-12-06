package cn.com.codeteenager.uncaughtexceptiondemo;

import android.app.Application;

/**
 * Created by jiangshuaijie on 2017/12/6.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //设置全局异常捕获类
        ExceptionCrashHandler.getInstance().init(this);
    }
}
