package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.Notice;
import com.twu.biblioteca.view.Page;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created by rzhou on 12/09/2017.
 */
public class CommandExecutorTest {

    Library library;
    CommandExecutor service = new CommandExecutor();

    @Before
    public void setUp() throws Exception {
        library = new Library();

        Book book1 = new Book("Refactoring", "Martin Fowler", 2015);
        Book book2 = new Book("Thinking in Java", "Bruce Eckel", 2017);
        Book book3 = new Book("Clean Code", "Robert C. Martin", 2010);

        library = new Library(Arrays.asList(book1, book2, book3));

        Book book4 = new Book("Knowledge Concept Maps", "Joseph D. Novak", 2016);
        Book book5 = new Book("Effective Java", "Joshua Bloch ", 2009);

        library.setLendingBooks(Arrays.asList(book4, book5));
        service.setLibrary(library);
    }

    @Test
    public void should_display_input_error() throws Exception {
        String result = "Select a valid option!\n";
        assertThat(service.displayInputError(), is(result));
    }

    @Test
    public void should_list_all_available_book() throws Exception {
        String result = "Name    Author    PublishYear\n"
                + "--------------------------------------\n"
                + "Refactoring    Martin Fowler    2015\n"
                + "Thinking in Java    Bruce Eckel    2017\n"
                + "Clean Code    Robert C. Martin    2010\n"
                + "--------------------------------------\n";
        assertThat(service.displayBookList(), is(result));
    }

    @Test
    public void should_display_checkout_success() throws Exception {
        assertThat(service.checkoutBook("Refactoring"), is(Notice.checkkoutBookSuccess + Page.CHECKOUT_PAGE));
    }

    @Test
    public void should_display_checkout_fail() throws Exception {
        assertThat(service.checkoutBook("Python"), is(Notice.checkoutBookFail + Page.CHECKOUT_PAGE));
    }

    @Test
    public void should_display_return_book_success() throws Exception {
        assertThat(service.returnBook("Effective Java"), is(Notice.returnBookSuccess + Page.RETURN_PAGE));
    }

    @Test
    public void should_display_return_book_fail() throws Exception {
        assertThat(service.returnBook("Python"), is(Notice.returnBookFail + Page.RETURN_PAGE));
    }
}