package com.example.weatherforecast;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class WeatherConditions {

    @SerializedName("main")
    Map<String,Float> measurements;

    public WeatherConditions(Map<String, Float> map){
        this.measurements= map;
    }

    public float getTemperature(){
        float temperature = this.measurements.get("temp");
        return temperature;
    }

}
