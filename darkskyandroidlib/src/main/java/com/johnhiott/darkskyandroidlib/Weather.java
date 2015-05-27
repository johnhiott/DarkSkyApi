package com.johnhiott.darkskyandroidlib;

import com.johnhiott.darkskyandroidlib.models.Request;
import com.johnhiott.darkskyandroidlib.models.WeatherResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface Weather {

    @GET("/{request}")
    void listRepos(@Path("request") Request params, Callback<WeatherResponse> cb);

}
