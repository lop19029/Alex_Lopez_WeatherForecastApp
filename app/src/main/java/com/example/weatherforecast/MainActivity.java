package com.example.weatherforecast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayAdapter adapter;
    private static final String TAG = "Main Activity";
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.listView = (ListView) findViewById(R.id.forecastListView);
    }

    public void onCurrentTemperature(View view){
        EditText cityName = (EditText) findViewById(R.id.cityName);
        String city = cityName.getText().toString();
        Toast.makeText(this, "Loading temperature...",
                Toast.LENGTH_LONG).show();

        GetWeatherAsync weatherAsync = new GetWeatherAsync(this, city);
        Thread thread = new Thread(weatherAsync);
        thread.start();


    }
    public void onWeatherForecast(View view){
        EditText cityName = (EditText) findViewById(R.id.cityName);
        String city = cityName.getText().toString();

        Toast.makeText(this, "Loading forecast...",
                Toast.LENGTH_LONG).show();

        GetForecastAsync forecastAsync = new GetForecastAsync(this, city);
        Thread thread = new Thread(forecastAsync);
        thread.start();

    }

    void handleWeatherConditionsResult(City city) {
        Log.d("MainActivity", "Back from API on the UI thread with the weather results!");

        // Check for an error
        if (city == null) {
            Log.d("MainActivity", "API results were null");

            // Inform the user
            Toast.makeText(this, "An error occurred when retrieving the weather",
                    Toast.LENGTH_LONG).show();
        } else {
            Log.d("MainActivity", "Conditions: " + city.weatherCondition.measurements);

            // Get the current temperature
            Float temp = city.weatherCondition.getTemperature();

            // Show the temperature to the user
            Toast.makeText(this, "It is currently " + temp + " degrees.",
                    Toast.LENGTH_LONG).show();
        }
}
    void handleWeatherForecastResults(City city) {
        Log.d("MainActivity", "Back from API on the UI thread with the weather results!");

        // Check for an error
        if (city == null) {
            Log.d("MainActivity", "API results were null");

            // Inform the user
            Toast.makeText(this, "An error occurred when retrieving the weather",
                    Toast.LENGTH_LONG).show();
        } else {
            Log.d("MainActivity", "Forecast of: "+city);

            //test data ArrayList value
            System.out.println("This is your array");
            System.out.println(city.weatherForecast.data);

            // Get the forecast items list
            ArrayList<ForecastItem> items = city.weatherForecast.items;


            this.adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, items);
            listView.setAdapter(adapter);
        }
    }
}