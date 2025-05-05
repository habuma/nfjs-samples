package com.example.springbooksmongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record Book(
    @Id String id,
    String isbn,
    String title,
    String author) {
}
