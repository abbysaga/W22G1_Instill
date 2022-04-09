package com.instill;

import android.app.Application;

import com.instill.database.SkillEnhancerDatabase;
import com.instill.utils.DataBaseUtil;

public class MyApplication extends Application {

    SkillEnhancerDatabase skillEnhancerDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        skillEnhancerDatabase = DataBaseUtil.getDatabaseInstance(this);
    }

}
