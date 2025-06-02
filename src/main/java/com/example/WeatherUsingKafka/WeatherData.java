package com.example.WeatherUsingKafka;

public class WeatherData {

    private String City;
    private double temperature;
    private long timestamp;

    // No-arg constructor needed for Jackson deserialization
    public WeatherData() {
    }

    // Constructor that initializes all fields
    public WeatherData(String city, double temperature, long timestamp) {
        this.City = city;
        this.temperature = temperature;
        this.timestamp = timestamp;
    }

    // Getters and setters
    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        this.City = city;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "City='" + City + '\'' +
                ", temperature=" + temperature +
                ", timestamp=" + timestamp +
                '}';
    }
}
