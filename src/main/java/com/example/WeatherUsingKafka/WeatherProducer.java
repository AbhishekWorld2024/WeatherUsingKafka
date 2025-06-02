package com.example.WeatherUsingKafka;

import com.example.WeatherUsingKafka.WeatherData;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherProducer {

    @Autowired
    private KafkaTemplate<String, WeatherData> kafkaTemplate;

    @Autowired
    private RestTemplate restTemplate;

    private final String API_KEY = "6840ef6c41f9b2f78e017fb9ee622550";

    // Fetch weather for a single city, send to Kafka, and return WeatherData
    public WeatherData fetchAndSendWeatherForCity(String city) {
        try {
            String url = String.format(
                    "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric",
                    city, API_KEY);

            ResponseEntity<JsonNode> response = restTemplate.getForEntity(url, JsonNode.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                JsonNode json = response.getBody();
                double temperature = json.get("main").get("temp").asDouble();
                long timestamp = System.currentTimeMillis();

                WeatherData data = new WeatherData(city, temperature, timestamp);

                // Send to Kafka
                kafkaTemplate.send("weather-data", data);
                System.out.println("Real-time Weather Sent: " + data);

                // Return the data
                return data;
            }
        } catch (Exception e) {
            System.err.println("Error fetching weather for " + city + ": " + e.getMessage());
        }
        return null;
    }
}
