package com.johnhiott.darkskyandroidlib.models;

public class WeatherResponse {

    private double latitude;
    private double longitude;
    private String timezone;
    private String offset;
    private DataPoint currently;
    private DataBlock minutely;
    private DataBlock hourly;
    private DataBlock daily;

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getOffset() {
        return offset;
    }

    public DataPoint getCurrently() {
        return currently;
    }

    public DataBlock getMinutely() {
        return minutely;
    }

    public DataBlock getHourly() {
        return hourly;
    }

    public DataBlock getDaily() {
        return daily;
    }
}
