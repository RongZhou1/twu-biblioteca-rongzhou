package com.twu.biblioteca.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rzhou on 10/09/2017.
 */
public class CustomerTest {
    private Library library;
    private Customer customer;

    @Before
    public void setUp() throws Exception {
        Book book1 = new Book("Refactoring", "Martin Fowler", 2015);
        Book book2 = new Book("Thinking in Java", "Bruce Eckel", 2017);
        Book book3 = new Book("Clean Code", "Robert C. Martin", 2010);

        library = new Library(Arrays.asList(book1, book2, book3));

        Book book4 = new Book("Knowledge Concept Maps", "Joseph D. Novak", 2016);
        Book book5 = new Book("Effective Java", "Joshua Bloch ", 2009);

        library.setLendingBooks(Arrays.asList(book4, book5));

        customer = new Customer();
    }

    @Test
    public void should_return_true_when_check_out_book_successfully() throws Exception {
        assertThat(customer.checkOutBook("Refactoring", library), is(true));
    }

    @Test
    public void should_return_false_when_check_out_book_unsuccessfully() throws Exception {
        assertThat(customer.checkOutBook("Python", library), is(false));
    }

    @Test
    public void should_return_true_when_put_back_book_successfully() throws Exception {
        assertThat(customer.returnBook("Knowledge Concept Maps", library), is(true));
    }

    @Test
    public void should_return_true_when_put_back_book_unsuccessfully() throws Exception {
        assertThat(customer.returnBook("Python", library), is(false));
    }
}
