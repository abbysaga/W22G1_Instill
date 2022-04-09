package com.instill.database.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.instill.database.dbmodels.SuggestionsModel;

import java.util.List;

@Dao
public interface SuggestionsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertSuggestions(SuggestionsModel... suggestionsModels);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long[] insertSuggestionsFromList(List<SuggestionsModel> suggestionsModelList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSuggestion(SuggestionsModel suggestionsModel);

    @Query("SELECT * from suggestions")
    List<SuggestionsModel> getAllSuggestions();

    @Query("SELECT * FROM suggestions WHERE skillId IN (:skillIds)")
    List<SuggestionsModel> getSuggestionsForSkills(List<Integer> skillIds);

    @Delete
    int deleteSuggestionsFromList(List<SuggestionsModel> students);

    @Query("DELETE FROM suggestions")
    void deleteAllSuggestions();

    @Query("DELETE FROM suggestions WHERE suggestionId=:StdId")
    int deleteSuggestionWithId(int StdId);

}
