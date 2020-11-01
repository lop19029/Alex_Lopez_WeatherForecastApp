package com.example.weatherforecast;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class WeatherForecast {
    ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();

    @SerializedName("list")
    ArrayList<ForecastItem> items;

    public WeatherForecast(ArrayList<ForecastItem> forecastItems) {
        this.items = forecastItems;
    }
    public void setForecastData(){
        ArrayList<String> temp;

        data = new ArrayList<>();
        //Loops through the ArrayList<ForecastItems> items
        for(ForecastItem f: items){

         try {
             //Brings data
             String date = f.dateAndTime;
             String temp_min = String.valueOf(f.measurements.get("temp_min"));
             String temp_max = String.valueOf(f.measurements.get("temp_max"));

             //Creates an ArrayList<String> with the data
             temp = new ArrayList<String>();
             temp.add(date);
             temp.add(temp_min);
             temp.add(temp_max);

             //tests that everything was got correctly
             System.out.println("INFORMATION");
             System.out.println(date);
             System.out.println(temp_min);
             System.out.println(temp_max);
             System.out.println(temp);

             //Adds data to ArrayList<ArrayList<String>> data
             data.add(temp);
         }
         catch (Exception e) {
             Log.d("TAG", "setForecastData: " + e.getMessage());
         }
        }
    }
    }



