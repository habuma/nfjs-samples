package com.example.uberconf2026;

public record WeatherConditions(
    String zipcode,
    String conditions,
    String temperature) {
}
