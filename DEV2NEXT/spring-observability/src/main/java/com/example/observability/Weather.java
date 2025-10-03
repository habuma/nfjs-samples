package com.example.observability;

public record Weather(String zipcode, String conditions, int temperatureInFahrenheit) {
}
