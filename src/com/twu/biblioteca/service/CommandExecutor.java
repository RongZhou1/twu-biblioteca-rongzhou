package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;

import java.util.List;

/**
 * Created by rzhou on 10/09/2017.
 */
public class CommandExecutor {
    private final String errorInput = "Select a valid option!\n";
    private final String bookListHeader = "Name    Author    PublishYear\n";
    private final String splitLine = "--------------------------------------\n";
    private final String bookItem = "%s    %s    %s\n";

    private Library library = new Library();

    public void setLibrary(Library library) {
        this.library.setAvailableBooks(library.getAvailableBooks());
        this.library.setLendingBooks(library.getLendingBooks());
    }

    public String displayInputError() {
        return errorInput;
    }

    public String buildBookList() {
        String bookList = bookListHeader + splitLine;
        for (int i = 0; i < library.getAvailableBooks().size(); i++) {
            Book book = library.getAvailableBooks().get(i);
            bookList += buildBookItem(book.getName(), book.getAuthor(), book.getPublishedYear());
        }
        bookList += splitLine;
        return bookList;
    }

    private String buildBookItem(String name, String author, int publishedYear) {
        return String.format(bookItem, name, author, publishedYear);
    }
}
