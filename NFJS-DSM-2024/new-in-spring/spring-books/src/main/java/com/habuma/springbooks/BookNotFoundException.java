package com.habuma.springbooks;


public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String isbn) {
        super("No such book: " + isbn);
    }
}
