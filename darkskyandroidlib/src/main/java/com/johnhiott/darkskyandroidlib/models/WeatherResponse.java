package com.johnhiott.darkskyandroidlib.models;

import java.util.List;

public class WeatherResponse {

    private double latitude;
    private double longitude;
    private String timezone;
    private String offset;
    private DataPoint currently;
    private DataBlock minutely;
    private DataBlock hourly;
    private DataBlock daily;

    private List<AlertPoint> alerts;

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

    public List<AlertPoint> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<AlertPoint> alerts) {
        this.alerts = alerts;
    }
}
