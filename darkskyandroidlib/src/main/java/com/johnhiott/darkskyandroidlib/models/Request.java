package com.johnhiott.darkskyandroidlib.models;

public class Request {

    private String mLat;
    private String mLng;
    private String mTime;
    private boolean mUseTime = false;

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

    private boolean useTime() {
        return "".equals(mTime);
    }

    @Override
    public String toString() {
        String params = mLat + "," + mLng;
        return  useTime() ?  params + "," + mTime : params;
    }
}
