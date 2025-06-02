package com.example.WeatherUsingKafka;

import com.example.WeatherUsingKafka.WeatherData;
import com.example.WeatherUsingKafka.WeatherProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    private WeatherProducer weatherProducer;

    @GetMapping("/weather/{city}")
    public ResponseEntity<?> getWeatherByCity(@PathVariable String city) {
        WeatherData data = weatherProducer.fetchAndSendWeatherForCity(city);
        if (data != null) {
            return ResponseEntity.ok(data);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Weather data not found for city: " + city);
        }
    }
}
