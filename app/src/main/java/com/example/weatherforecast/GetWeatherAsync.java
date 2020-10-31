package com.example.weatherforecast;

import android.util.Log;

public class GetWeatherAsync implements Runnable{
    private static final String TAG = GetWeatherAsync.class.getSimpleName();
    private MainActivity activity;
    private String city;

    public GetWeatherAsync(MainActivity activity, String city){
        this.activity = activity;
        this.city = city;
    }
    @Override
    public void run() {
        Log.i(TAG, "getting the temperature for that city on a background thread");

        City city = new City(this.city);
        city.setWeatherCondition();
        activity.runOnUiThread( new Runnable(){

            @Override
            public void run() {
                activity.handleWeatherConditionsResult(city);
            }
        });

    }
}
