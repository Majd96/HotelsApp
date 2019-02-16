package com.example.majdbaniodeh.yamsafertask.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RootJsonResult {

    @SerializedName("accommodations")
    ArrayList<Accommodation> accommodationList;

    public ArrayList<Accommodation> getAccommodationList() {
        return accommodationList;
    }
}
