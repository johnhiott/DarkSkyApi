package com.johnhiott.darkskyandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.johnhiott.darkskyandroidlib.RequestBuilder;
import com.johnhiott.darkskyandroidlib.models.Request;
import com.johnhiott.darkskyandroidlib.models.WeatherResponse;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestBuilder weather = new RequestBuilder();

        Request request = new Request();
        request.setLat("32.00");
        request.setLng("-81.00");
        request.setUnits(Request.Units.US);
        request.setLanguage(Request.Language.PIG_LATIN);

        weather.getWeather(request, new Callback<WeatherResponse>() {
            @Override
            public void success(WeatherResponse weatherResponse, Response response) {
                Log.d(TAG, "Temp: " + weatherResponse.getCurrently().getTemperature());
                Log.d(TAG, "Summary: " + weatherResponse.getCurrently().getSummary());
                Log.d(TAG, "Hourly Sum: " + weatherResponse.getHourly().getSummary());

            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Log.d(TAG, "Error while calling: " + retrofitError.getUrl());
                Log.d(TAG, retrofitError.toString());
            }
        });
    }
}
