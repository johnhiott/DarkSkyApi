package com.johnhiott.darkskyandroid;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MenuItem;

import com.johnhiott.darkskyandroidlib.ForecastApi;
import com.johnhiott.darkskyandroidlib.Weather;
import com.johnhiott.darkskyandroidlib.models.Request;
import com.johnhiott.darkskyandroidlib.models.WeatherResponse;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = "MainActivity";

    @InjectView(R.id.main_view_pager) ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        mViewPager.setAdapter(mPagerAdapter);

        Weather weather;
        weather = ForecastApi.getInstance().getRestAdapter().create(Weather.class);

        Request request = new Request();
        request.setLat("32.00");
        request.setLng("-81.00");

        weather.getWeather(request, new Callback<WeatherResponse>() {
            @Override
            public void success(WeatherResponse weatherResponse, Response response) {
                Log.d(TAG, "Successfully called: " + response.getUrl());
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Log.d(TAG, "Error while calling: " + retrofitError.getUrl());
                Log.d(TAG, retrofitError.toString());
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadSavedPlaces() {

    }

    private PagerAdapter mPagerAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
        @Override
        public Fragment getItem(int position) {
            return null;
        }

        @Override
        public int getCount() {
            return 0;
        }
    };

}
