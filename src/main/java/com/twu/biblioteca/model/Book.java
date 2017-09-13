package com.twu.biblioteca.model;

/**
 * Created by rzhou on 10/09/2017.
 */
public class Book {
    private String name;
    private String author;
    private int publishedYear;

    public Book(String name, String author, int publishedYear) {
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }
}
