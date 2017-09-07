package com.kodilla.stream.immutable;

/**
 * Created by PR on 23.07.2017.
 */
public final class Book {
    private final String title;
    private final String author;
    private final int yearOfPublication;

    public Book(final String title, final String author,
                final int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

}