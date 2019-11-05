package com.example.administrator.viewpager.utils;

import android.app.Application;

/**
 * Created by B05 on 2018/8/28.
 */

public class SApplication extends Application {
    //图片加载，缓存和管理组件
    private static ImageLoaderKit imageLoaderKit;
    @Override
    public void onCreate() {
        super.onCreate();
        imageLoaderKit = new ImageLoaderKit(this, null);
    }
}
