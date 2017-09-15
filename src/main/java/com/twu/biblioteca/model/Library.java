package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by rzhou on 10/09/2017.
 */
public class Library {
    private List<Book> availableBooks = new ArrayList<Book>();
    private List<Book> lendingBooks = new ArrayList<Book>();
    private List<Movie> movies = new ArrayList<Movie>();

    public Library() {
    }

    public Library(List<Book> books) {
        this.availableBooks.addAll(books);
    }

    public void setLendingBooks(List<Book> lendingBooks) {
        this.lendingBooks.addAll(lendingBooks);
    }

    public List<Book> getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(List<Book> availableBooks) {
        this.availableBooks.addAll(availableBooks);
    }

    public List<Book> getLendingBooks() {
        return lendingBooks;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies.addAll(movies);
    }

    public boolean takeOutBook(String name) {
        boolean result = false;
        int index = findBookByName(1, name);
        if (index != -1) {
            result = true;
            lendingBooks.add(availableBooks.get(index));
            availableBooks.remove(index);
        }
        return result;
    }

    public boolean putBackBook(String name) {
        boolean result = false;
        int index = findBookByName(2, name);
        if (index != -1) {
            result = true;
            availableBooks.add(lendingBooks.get(index));
            lendingBooks.remove(index);
        }
        return result;
    }

    public boolean takeOutMovie(String name) {
        boolean result = false;
        int index = findMovieByName(name);
        if (index != -1) {
            result = true;
        }
        return result;
    }

    private int findMovieByName(String name) {
        int index = -1;
        for (int i = 0; i < movies.size(); i++) {
            if (Objects.equals(movies.get(i).getName(), name)) {
                index = i;
            }
        }
        return index;
    }


    private int findBookByName(int choice, String name) {
        int index = -1;
        if (choice == 1) {
            for (int i = 0; i < availableBooks.size(); i++) {
                if (availableBooks.get(i).getName().equals(name)) {
                    index = i;
                }
            }
        } else if (choice == 2) {
            for (int i = 0; i < lendingBooks.size(); i++) {
                if (lendingBooks.get(i).getName().equals(name)) {
                    index = i;
                }
            }
        }
        return index;
    }
}
