package com.instill.database.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.instill.database.dbmodels.Courses;

import java.util.List;

@Dao
public interface CoursesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertCourses(Courses... courses);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long[] insertCoursesFromList(List<Courses> coursesList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCourse(Courses course);

    @Query("SELECT * from courses")
    public List<Courses> getAllCourses();

    @Delete
    int deleteOneCourse(Courses student);

    @Query("DELETE FROM courses")
    void deleteAllCourses();

    @Query("DELETE FROM courses WHERE courseId=:courseId")
    int deleteCoursesWithId(int courseId);

}
