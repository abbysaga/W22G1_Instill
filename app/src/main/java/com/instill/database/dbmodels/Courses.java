package com.instill.database.dbmodels;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "courses")
public class Courses {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "courseId")
    public int courseId;

    @ColumnInfo(name = "coursename")
    private String courseName;

    public Courses() {
    }

    public Courses(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

}
