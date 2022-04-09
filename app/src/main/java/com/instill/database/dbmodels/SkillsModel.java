package com.instill.database.dbmodels;

import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "skills",
        foreignKeys = @ForeignKey(entity = Courses.class, parentColumns = "courseId", childColumns = "courseId", onDelete = ForeignKey.CASCADE))
public class SkillsModel implements Serializable {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "skillId")
    public int skillId;

    @ColumnInfo(name = "courseId")
    private int courseId;

    @ColumnInfo(name = "skillname")
    private String skillName;

    @ColumnInfo(name = "skilllevel", defaultValue = "Expert")
    private String level;

    public SkillsModel() {
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
        if (TextUtils.isEmpty(level)) level = "Expert";
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @NonNull
    @Override
    public String toString() {
        return "Skill:" + skillName + "\n At Level:" + level;
    }

}
