package com.johnhiott.darkskyandroidlib.models;

import android.util.Log;

public class Request {

    public static final String UNITS = "units";
    public static final String SI_UNITS = "si";
    public static final String US_UNITS = "us";

    private String mLat;
    private String mLng;
    private String mTime;

    public String getLat() {
        return mLat;
    }

    public void setLat(String lat) {
        mLat = lat;
    }

    public String getLng() {
        return mLng;
    }

    public void setLng(String lng) {
        mLng = lng;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        mTime = time;
    }

    private Boolean useTime() {
        return mTime != null && !mTime.equals("");
    }

    @Override
    public String toString() {
        String params = mLat + "," + mLng;
        Log.d("JOJO", useTime().toString());
        return  useTime() ?  params + "," + mTime : params;
    }
}
