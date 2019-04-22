package com.example.pxwzoukao422.app;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

import com.example.pxwzoukao422.utils.GrennDaoUtils;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

public class App extends Application {

    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=this;

        DiskCacheConfig build = DiskCacheConfig.newBuilder(this)
                .setMaxCacheSize(10*1024*1024)
                .setBaseDirectoryPath(Environment.getExternalStorageDirectory())
                .build();

        ImagePipelineConfig build1 = ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(build)
                .build();

        Fresco.initialize(this,build1);
        GrennDaoUtils.getIntance().getDaoSession();
    }
}
