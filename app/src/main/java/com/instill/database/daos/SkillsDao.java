package com.instill.database.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.instill.database.dbmodels.SkillsModel;

import java.util.List;

@Dao
public interface SkillsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    @Update
    Long[] insertSkillsFromList(List<SkillsModel> skillsModelList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSkills(SkillsModel skillsModel);

    @Query("SELECT * from skills WHERE courseId=:courseId")
    List<SkillsModel> getAllSkillsForCourse(int courseId);

    @Query("SELECT * from skills")
    List<SkillsModel> getAllSkills();

    @Query("SELECT * FROM skills WHERE skillId IN (:skillsModelList)")
    List<SkillsModel> getSkillsWithIds(List<Integer> skillsModelList);

    @Query("DELETE FROM skills")
    void deleteAllSkill();

    @Query("DELETE FROM skills WHERE courseId=:courseId")
    int deleteSkillWithCourseId(int courseId);

    @Query("DELETE FROM skills WHERE skillId=:skillId")
    int deleteSkillWithId(int skillId);

}
