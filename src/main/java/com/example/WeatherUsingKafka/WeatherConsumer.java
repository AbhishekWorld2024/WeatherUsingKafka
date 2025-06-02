package com.example.WeatherUsingKafka;

import com.example.WeatherUsingKafka.WeatherData;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WeatherConsumer {

    @KafkaListener(topics = "weather-data", groupId = "weather-group")
    public void listen(WeatherData data) {
        System.out.println("Consumed: " + data);
    }
}