package com.instill.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.instill.database.daos.CoursesDao;
import com.instill.database.daos.SkillsDao;
import com.instill.database.daos.SuggestionsDao;
import com.instill.database.dbmodels.Converters;
import com.instill.database.dbmodels.Courses;
import com.instill.database.dbmodels.SkillsModel;
import com.instill.database.dbmodels.SuggestionsModel;

@Database(entities = {SuggestionsModel.class, Courses.class, SkillsModel.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class SkillEnhancerDatabase extends RoomDatabase {

    public abstract CoursesDao coursesDao();

    public abstract SkillsDao skillsModelDao();

    public abstract SuggestionsDao suggestionsDao();

}