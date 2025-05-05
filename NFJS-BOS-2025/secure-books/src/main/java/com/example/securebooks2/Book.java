package com.example.securebooks2;

import org.springframework.data.annotation.Id;

public record Book(
    @Id Long id,
    String isbn,
    String title,
    String author,
    String reader) {}
