package com.example.uberbooksclient;

public record Book(
    Long id,
    String isbn,
    String title,
    String author) {
}
