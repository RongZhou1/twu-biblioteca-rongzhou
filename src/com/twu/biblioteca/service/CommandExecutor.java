package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Customer;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.Notice;
import com.twu.biblioteca.view.Page;

/**
 * Created by rzhou on 10/09/2017.
 */
public class CommandExecutor {
    private final String bookListHeader = "Name    Author    PublishYear\n";
    private final String splitLine = "--------------------------------------\n";
    private final String bookItem = "%s    %s    %s\n";

    private Customer customer = new Customer();
    private Library library = new Library();
    private Notice notice;
    private Page page;

    public void setLibrary(Library library) {
        this.library.setAvailableBooks(library.getAvailableBooks());
        this.library.setLendingBooks(library.getLendingBooks());
    }

    public String displayInputError() {
        System.out.println(notice.errorInput);
        return notice.errorInput;
    }

    public String buildBookList() {
        String bookList = bookListHeader + splitLine;
        for (int i = 0; i < library.getAvailableBooks().size(); i++) {
            Book book = library.getAvailableBooks().get(i);
            bookList += buildBookItem(book.getName(), book.getAuthor(), book.getPublishedYear());
        }
        bookList += splitLine;

        System.out.println(bookList);
        return bookList;
    }


    public String checkoutBook(String name) {
        String str;
        if (customer.checkOutBook(name, library)) {
            str = notice.checkkoutBookSuccess + page.CHECKOUT_PAGE;
        } else {
            str = notice.checkoutBookFail + page.CHECKOUT_PAGE;
        }
        System.out.println(str);
        return str;

    }

    public String returnBook(String name) {
        String str;
        if (customer.returnBook(name, library)) {
            str = notice.returnBookSuccess + page.RETURN_PAGE;
        } else {
            str = notice.returnBookFail + page.RETURN_PAGE;
        }
        System.out.println(str);
        return str;
    }

    private String buildBookItem(String name, String author, int publishedYear) {
        return String.format(bookItem, name, author, publishedYear);
    }
}
