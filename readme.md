Dark Sky API Android Wrapper
------------------


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


[Original API docs here](https://developer.forecast.io/docs/v2)
