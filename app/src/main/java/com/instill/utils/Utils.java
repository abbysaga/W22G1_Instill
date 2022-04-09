package com.instill.utils;

import android.os.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utils {

    public static final String AppFolderPath = Environment.getExternalStorageDirectory() + "/Instill";

    public static void checkAndCreateFolder() {
        try {
            File dir = new File(AppFolderPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
