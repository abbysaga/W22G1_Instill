package com.instill.models;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class PersonalDetails implements Serializable {

    public String firstName, middleName, lastName, emailAddress, linkedInLink, addressLine1, country, province, phoneNumber;

    @NonNull
    @Override
    public String toString() {
        return "Name: " + firstName + " " + middleName + " " + lastName +
                "\nEmail Address: " + emailAddress +
                "\nLinkedIn: " + linkedInLink +
                "\nAddress: " + addressLine1 + ", " + province + ", " + country +
                "\nPhoneNumber=" + phoneNumber;
    }

}
