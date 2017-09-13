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

    private Customer customer = new Customer();
    private Library library = new Library();

    public void setLibrary(Library library) {
        this.library.setAvailableBooks(library.getAvailableBooks());
        this.library.setLendingBooks(library.getLendingBooks());
    }

    public String displayInputError() {
        System.out.print(Notice.errorInput);
        return Notice.errorInput;
    }

    public String displayBookList() {

        String bookListHeader = "Name    Author    PublishYear\n";
        String splitLine = "--------------------------------------\n";
        String bookList = splitLine + bookListHeader + splitLine;

        for (int i = 0; i < library.getAvailableBooks().size(); i++) {
            Book book = library.getAvailableBooks().get(i);
            bookList += buildBookItem(book.getName(), book.getAuthor(), book.getPublishedYear());
        }
        bookList += splitLine;

        System.out.print(bookList);
        return bookList;
    }


    public String checkoutBook(String name) {
        String str;
        if (customer.checkOutBook(name, library)) {
            str = Notice.checkkoutBookSuccess + Page.CHECKOUT_PAGE;
        } else {
            str = Notice.checkoutBookFail + Page.CHECKOUT_PAGE;
        }
        System.out.print(str);
        return str;

    }

    public String returnBook(String name) {
        String str;
        if (customer.returnBook(name, library)) {
            str = Notice.returnBookSuccess + Page.RETURN_PAGE;
        } else {
            str = Notice.returnBookFail + Page.RETURN_PAGE;
        }
        System.out.print(str);
        return str;
    }

    private String buildBookItem(String name, String author, int publishedYear) {
        String bookItem = "%s    %s    %s\n";
        return String.format(bookItem, name, author, publishedYear);
    }

    public String display(String displayContent) {
        System.out.print(displayContent);
        return displayContent;
    }
}
