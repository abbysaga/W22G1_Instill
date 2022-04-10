package com.instill.models;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class EducationDetails implements Serializable {

    public String degree, university, grade, year;

    @NonNull
    @Override
    public String toString() {
        return "University: " + university +
                "\nDegree: " + degree +
                "\nGrade: " + grade + "in Year" + year;
    }

}
