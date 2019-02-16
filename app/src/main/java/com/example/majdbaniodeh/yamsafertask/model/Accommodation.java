package com.example.majdbaniodeh.yamsafertask.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Accommodation implements Parcelable {

    public static final Creator<Accommodation> CREATOR = new Creator<Accommodation>() {
        @Override
        public Accommodation createFromParcel(Parcel in) {
            return new Accommodation(in);
        }

        @Override
        public Accommodation[] newArray(int size) {
            return new Accommodation[size];
        }
    };
    @SerializedName("name")
    private String name;
    @SerializedName("images")
    private ArrayList<String> images;
    @SerializedName("rates")
    private ArrayList<Rate> ratesList;

    protected Accommodation(Parcel in) {
        name = in.readString();
        images = in.createStringArrayList();
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public ArrayList<Rate> getRatesList() {
        return ratesList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeStringList(images);
    }
}
