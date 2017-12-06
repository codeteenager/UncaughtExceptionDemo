package cn.com.codeteenager.uncaughtexceptiondemo;

import android.content.Context;

/**
 * Created by jiangshuaijie on 2017/12/6.
 */

public class ExceptionCrashHandler implements Thread.UncaughtExceptionHandler {
    private static ExceptionCrashHandler mInstance;
    private Thread.UncaughtExceptionHandler mDefaultExceptionHandler;

    public static ExceptionCrashHandler getInstance() {
        if (mInstance == null) {
            synchronized (ExceptionCrashHandler.class) {
                if (mInstance == null) {
                    mInstance = new ExceptionCrashHandler();
                }
            }
        }
        return mInstance;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        //全局异常
        //写入到本地文件
        //让系统默认处理
        mDefaultExceptionHandler.uncaughtException(t, e);
    }

    private Context mContext;

    public void init(Context context) {
        this.mContext = context;
        //设置全局的异常类
        Thread.setDefaultUncaughtExceptionHandler(this);
        mDefaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    }
}
