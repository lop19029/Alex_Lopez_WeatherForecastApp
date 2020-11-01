package com.example.weatherforecast;

import com.google.gson.Gson;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class City {
    String name;
    WeatherConditions weatherCondition;
    WeatherForecast weatherForecast;
    String CHARSET = "UTF-8";


    public City(String name) {
        this.name = name;
        }

    public void setWeatherCondition() {

        try {
            //Sets the URL encoding the city name
            String url = "https://api.openweathermap.org/data/2.5/weather";
            String query = String.format("q=%s&apiKey=c560ccf5adc89fe21af0e8dbbadbaf6c&units=imperial",
                    URLEncoder.encode(name, CHARSET));

            //Requests for and reads URL's input
            URLConnection connection = new URL(url + "?" + query + "&format=json").openConnection();
            connection.setRequestProperty("Accept-Charset", CHARSET);
            InputStream response = connection.getInputStream();
            Scanner scanner = new Scanner(response);
            String responseBody = scanner.useDelimiter("\\A").next();

            //Parses the Json
            Gson gson = new Gson();
            this.weatherCondition = gson.fromJson(responseBody, WeatherConditions.class);


        } catch (UnsupportedEncodingException | MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setWeatherForecast(){

        try {


            //Sets the URL encoding the city name
            String url = "https://api.openweathermap.org/data/2.5/forecast";
            String query = String.format("q=%s&apiKey=c560ccf5adc89fe21af0e8dbbadbaf6c&units=imperial",
                    URLEncoder.encode(name, CHARSET));

            //Requests for and reads (in a different way) URL's input
            URLConnection connection = new URL(url+"?"+query+"&format=json").openConnection();
            connection.setRequestProperty("Accept-Charset", CHARSET);
            InputStream response = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(response));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while( (line = reader.readLine()) != null){
                stringBuilder.append(line);
            }

            //Parses the Json
            Gson gson = new Gson();
            this.weatherForecast = gson.fromJson(stringBuilder.toString(), WeatherForecast.class);

        } catch (UnsupportedEncodingException | MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
