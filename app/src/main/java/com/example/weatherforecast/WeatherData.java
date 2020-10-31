package com.example.weatherforecast;

import com.google.gson.annotations.SerializedName;

public class WeatherData {
    @SerializedName("main")
    String skyCondition;

    @SerializedName("description")
    String skyDescription;

    public WeatherData(String skyCondition, String skyDescription){
        this.skyCondition = skyCondition;
        this.skyDescription = skyDescription;
    }

}
