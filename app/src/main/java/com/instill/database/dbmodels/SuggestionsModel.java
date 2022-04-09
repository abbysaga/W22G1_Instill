package com.instill.database.dbmodels;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "suggestions",
        foreignKeys = @ForeignKey(entity = SkillsModel.class, parentColumns = "skillId", childColumns = "skillId", onDelete = ForeignKey.CASCADE))
public class SuggestionsModel {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "suggestionId")
    public int suggestionId;

    @ColumnInfo(name = "skillId")
    private int skillId;

    @ColumnInfo(name = "skillLinks")
    private ArrayList<String> skillLinks;

    public SuggestionsModel() {
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public ArrayList<String> getSkillLinks() {
        return skillLinks;
    }

    public void setSkillLinks(ArrayList<String> skillLinks) {
        this.skillLinks = skillLinks;
    }

}
