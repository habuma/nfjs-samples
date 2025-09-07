package com.example.springbooks;

public record Book(
    Long id,
    String isbn,
    String title,
    String author) {
}
