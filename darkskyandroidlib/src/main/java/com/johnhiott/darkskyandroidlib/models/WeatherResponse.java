package com.johnhiott.darkskyandroidlib.models;

import com.google.gson.annotations.SerializedName;

public class WeatherResponse {

    @SerializedName("latitude")
    private String mLatitude;

    public String getLatitude() {
        return mLatitude;
    }
}
