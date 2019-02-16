package com.example.majdbaniodeh.yamsafertask.model;

import com.google.gson.annotations.SerializedName;

public class Rate {

    @SerializedName("base_rate")
    private double baseRate;

    @SerializedName("is_prepaid")
    private boolean isPrepaid;

    public double getBaseRate() {
        return baseRate;
    }

    public boolean isPrepaid() {
        return isPrepaid;
    }
}
