package com.example.weatherforecast;

import android.util.Log;

public class GetForecastAsync implements Runnable{
    private static final String TAG = GetForecastAsync.class.getSimpleName();
    private MainActivity activity;
    private String city;

    public GetForecastAsync(MainActivity activity, String city){
        this.activity = activity;
        this.city = city;
        System.out.println("City loaded successfully");
    }
    @Override
    public void run() {
        Log.i(TAG, "getting the forecast for that city on a background thread");

        City city = new City(this.city);
        city.setWeatherForecast();
        city.weatherForecast.setForecastData();
        activity.runOnUiThread( new Runnable(){

            @Override
            public void run() {
                activity.handleWeatherForecastResults(city);
            }
        });

    }
}
