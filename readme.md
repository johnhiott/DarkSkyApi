Dark Sky API Android Wrapper
------------------

[![Build Status](https://travis-ci.org/johnhiott/DarkSkyApi.png?branch=master)](https://travis-ci.org/johnhiott/DarkSkyApi)


#####Install

 - 	Add the following to your `build.gradle`:

```java
repositories {
	    maven { url "https://jitpack.io" }
}

dependencies {
	    compile 'com.github.johnhiott:DarkSkyApi:v0.1.5'
}

```

#####Get API ready
```java
@Override
public void onCreate() {
    super.onCreate();
    ForecastApi.create("replaceWithYourApiKey");
}
```


#####Making a request
```java


RequestBuilder weather = new RequestBuilder();

Request request = new Request();
request.setLat("32.00");
request.setLng("-81.00");
request.setUnits(Request.Units.US);
request.setLanguage(Request.Language.PIG_LATIN);
request.addExcludeBlock(Request.Block.CURRENTLY);

weather.getWeather(request, new Callback<WeatherResponse>() {
    @Override
    public void success(WeatherResponse weatherResponse, Response response) {
        //Do something
    }

    @Override
    public void failure(RetrofitError retrofitError) {
        Log.d(TAG, "Error while calling: " + retrofitError.getUrl());
    }
});


```

#####Proguard Configuration

```
# DarkSkyApi models
-keep class com.johnhiott.darkskyandroidlib.models.**{ *; }

# Retrofit 1.X for our DarkSkyApi

-keep class com.squareup.okhttp.** { *; }
-keep class retrofit.** { *; }
-keep interface com.squareup.okhttp.** { *; }

-dontwarn com.squareup.okhttp.**
-dontwarn okio.**
-dontwarn retrofit.**
-dontwarn rx.**
```


[Original API docs here](https://developer.forecast.io/docs/v2)
