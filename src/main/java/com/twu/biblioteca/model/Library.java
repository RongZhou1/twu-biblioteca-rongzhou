package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rzhou on 10/09/2017.
 */
public class Library {
    private List<Book> availableBooks;
    private List<Book> lendingBooks;

    public Library() {
        this.availableBooks = new ArrayList<Book>();
        this.lendingBooks = new ArrayList<Book>();
    }

    public Library(List<Book> books) {
        this.availableBooks = new ArrayList<Book>();
        this.lendingBooks = new ArrayList<Book>();
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

    public int findBookByName(int choice, String name) {
        if (choice == 1) {
            for (int i = 0; i < availableBooks.size(); i++) {
                if (availableBooks.get(i).getName().equals(name)) {
                    return i;
                }
            }
            return -1;
        } else if (choice == 2) {
            for (int i = 0; i < lendingBooks.size(); i++) {
                if (lendingBooks.get(i).getName().equals(name)) {
                    return i;
                }
            }
            return -1;
        }
        return -1;
    }

    public boolean takeOutBook(String name) {
        int index = findBookByName(1, name);
        if (index == -1) {
            return false;
        }
        lendingBooks.add(availableBooks.get(index));
        availableBooks.remove(index);
        return true;
    }

    public boolean putBackBook(String name) {
        int index = findBookByName(2, name);
        if (index == -1) {
            return false;
        }
        availableBooks.add(lendingBooks.get(index));
        lendingBooks.remove(index);
        return true;
    }
}
