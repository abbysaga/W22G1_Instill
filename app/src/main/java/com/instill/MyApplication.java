package com.instill;

import android.app.Application;

import com.instill.database.SkillEnhancerDatabase;
import com.instill.utils.DataBaseUtil;
import com.instill.utils.Utils;

public class MyApplication extends Application {

    SkillEnhancerDatabase skillEnhancerDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.AppFolderPath = getFilesDir() + "/Instill";
        skillEnhancerDatabase = DataBaseUtil.getDatabaseInstance(this);
    }

}
