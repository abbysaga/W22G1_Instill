package com.instill.models;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Project implements Serializable {

    public String title, description;

    @NonNull
    @Override
    public String toString() {
        return "Worked on Project: " + title + "\nDescription: " + description;
    }

}