package com.example.weatherforecast;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class ForecastItem {

    @SerializedName("dt_txt")
    String dateAndTime;

    @SerializedName("main")
    Map<String, Float> measurements;

    @SerializedName("weather")
    List<WeatherData> weatherCondition;

    @SerializedName("wind")
    Map<String, Float> windInfo;

    public ForecastItem(String dateAndTime, Map<String, Float> measurements, List<WeatherData> weatherCondition,
                        Map<String, Float> windInfo) {
        this.dateAndTime = dateAndTime;
        this.measurements = measurements;
        this.weatherCondition = weatherCondition;
        this.windInfo = windInfo;
    }
}

