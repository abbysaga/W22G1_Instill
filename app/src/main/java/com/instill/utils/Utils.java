package com.instill.utils;

import android.os.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utils {

    public static final String AppFolderPath = Environment.getExternalStorageDirectory() + "/Instill";

    public static final int EDUCATION = 0;
    public static final int EXPERIENCE = 1;
    public static final int SKILLS = 2;
    public static final int PROJECTS = 3;

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

    public static List<File> getAllAppPDFFiles() {
        List<File> fileList = new ArrayList<>();
        String pdfPattern = ".pdf";
        File dir = new File(AppFolderPath);
        File[] filesList = dir.listFiles();
        if (filesList != null) {
            for (File file : filesList) {
                if (!file.isDirectory() && file.getName().endsWith(pdfPattern)) {
                    fileList.add(file);
                }
            }
        }
        return fileList;
    }

    public static String showLastModified(long lastModified) {
        Date d = new Date(lastModified);
        return d.toString();
    }

}
