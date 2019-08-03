package com.example.welcome;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import io.realm.Realm;

public class Myapplication extends Application {//它作为全局的单面对象存储一些系统的信息
                                                //当应用打开后，它会立即执行

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        Realm.init(this);//把realm引入项目中

       // RealmHelper.migration();


    }
}
