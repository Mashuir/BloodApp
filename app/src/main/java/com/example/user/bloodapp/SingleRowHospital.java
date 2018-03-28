package com.example.user.bloodapp;

/**
 * Created by User on 3/26/2018.
 */

public class SingleRowHospital {
    private String name;
    private String phoneNumber;

    public SingleRowHospital(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
