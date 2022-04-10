package com.instill.models;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Experience implements Serializable {

    public String companyName, jobTitle, startDate, endDate, jobDescription;

    @NonNull
    @Override
    public String toString() {
        return "Company: " + companyName +
                "\nJob: " + jobTitle +
                "\nFrom: " + startDate + " to " + endDate +
                "\nDescription: " + jobDescription;
    }
}