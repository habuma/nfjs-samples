package com.habuma.booksclient;

public record Book(
    Long id,
    String isbn,
    String title,
    String author) {
}
