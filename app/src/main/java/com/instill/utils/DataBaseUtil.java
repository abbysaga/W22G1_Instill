package com.instill.utils;

import android.content.Context;

import androidx.room.Room;

import com.instill.database.SkillEnhancerDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataBaseUtil {

    private static SkillEnhancerDatabase skillEnhancerDatabase;
    private static Context context;

    public static synchronized SkillEnhancerDatabase getDatabaseInstance(Context context) {
        DataBaseUtil.context = context.getApplicationContext();
        if (skillEnhancerDatabase == null)
            skillEnhancerDatabase = Room.databaseBuilder(context.getApplicationContext(), SkillEnhancerDatabase.class, "SkillEnhancer.db").
                    allowMainThreadQueries().build();
        return skillEnhancerDatabase;
    }

    public static void prepareMockData() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            try {
//                we are checking if database already have data
                if (skillEnhancerDatabase.coursesDao().getAllCourses().isEmpty())
                    skillEnhancerDatabase.coursesDao().insertCoursesFromList(DummyData.getDummyCourses());
                if (skillEnhancerDatabase.skillsModelDao().getAllSkills().isEmpty())
                    skillEnhancerDatabase.skillsModelDao().insertSkillsFromList(DummyData.getDummySkills());
                if (skillEnhancerDatabase.suggestionsDao().getAllSuggestions().isEmpty())
                    skillEnhancerDatabase.suggestionsDao().insertSuggestionsFromList(DummyData.getDummySuggestions());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    public static void insertDummyCourses() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            try {
                if (skillEnhancerDatabase.coursesDao().getAllCourses().isEmpty())
                    skillEnhancerDatabase.coursesDao().insertCoursesFromList(DummyData.getDummyCourses());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    public static void insertDummySkills() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            try {
                if (!skillEnhancerDatabase.skillsModelDao().getAllSkills().isEmpty())
                    return;
                skillEnhancerDatabase.skillsModelDao().insertSkillsFromList(DummyData.getDummySkills());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    public static void insertDummySuggestions() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            try {
                if (!skillEnhancerDatabase.suggestionsDao().getAllSuggestions().isEmpty())
                    return;
                skillEnhancerDatabase.suggestionsDao().insertSuggestionsFromList(DummyData.getDummySuggestions());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

}
