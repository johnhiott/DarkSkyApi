package com.johnhiott.darkskyandroidlib;

import com.johnhiott.darkskyandroidlib.models.Request;
import com.johnhiott.darkskyandroidlib.models.WeatherResponse;

import java.util.Map;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.QueryMap;

public interface Weather {

    @GET("/{request}")
    void getWeather(@Path("request") Request params, Callback<WeatherResponse> cb);

    @GET("/{request}")
    void getWeather(@Path("request") Request params, @QueryMap Map<String,String> query, Callback<WeatherResponse> cb);

}
