package com.example.pxwzoukao422.utils;

import android.database.sqlite.SQLiteDatabase;

import com.example.pxwzoukao422.api.Api;
import com.example.pxwzoukao422.app.App;
import com.example.pxwzoukao422.db.DaoMaster;
import com.example.pxwzoukao422.db.DaoSession;

public class GrennDaoUtils {

    public static GrennDaoUtils intance;
    private final DaoSession daoSession;

    private GrennDaoUtils(){
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(App.context, "user.db");
        SQLiteDatabase writableDatabase = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(writableDatabase);
        daoSession = daoMaster.newSession();
    }

    public static GrennDaoUtils getIntance() {
        if (intance == null) {
            synchronized (GrennDaoUtils.class){
                if (intance == null) {
                     intance=new GrennDaoUtils();
                }
            }
        }
        return intance;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
