package com.twu.biblioteca.model;

/**
 * Created by rzhou on 10/09/2017.
 */
public class Customer {

    public boolean checkOutBook(String name, Library library) {
        return library.takeOutBook(name);
    }

    public boolean returnBook(String name, Library library) {
        return library.putBackBook(name);
    }
}
