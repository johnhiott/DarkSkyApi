package com.johnhiott.darkskyandroidlib;

import com.johnhiott.darkskyandroidlib.models.Request;
import com.johnhiott.darkskyandroidlib.models.WeatherResponse;

import retrofit.Callback;

public class RequestBuilder {

    private Weather mWeather;

    public RequestBuilder() {
        mWeather = ForecastApi.getInstance().getRestAdapter().create(Weather.class);
    }

    public void getWeather(Request request, Callback<WeatherResponse> callback) {
        mWeather.getWeather(request, request.getQueryParams(), callback);
    }
}