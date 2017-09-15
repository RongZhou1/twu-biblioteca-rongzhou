package com.twu.biblioteca.model;

import org.junit.Before;
import org.junit.Test;

import static com.twu.biblioteca.LibraryFixture.buildLibrary;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by rzhou on 10/09/2017.
 */
public class CustomerTest {
    private Library library;
    private Customer customer;

    @Before
    public void setUp() throws Exception {
        library = buildLibrary();
        customer = new Customer();
    }

    @Test
    public void should_return_true_when_check_out_book_successfully() throws Exception {
        assertTrue(customer.checkOutBook("Refactoring", library));
    }

    @Test
    public void should_return_false_when_check_out_book_unsuccessfully() throws Exception {
        assertFalse(customer.checkOutBook("Python", library));
    }

    @Test
    public void should_return_true_when_put_back_book_successfully() throws Exception {
        assertTrue(customer.returnBook("Knowledge Concept Maps", library));
    }

    @Test
    public void should_return_true_when_put_back_book_unsuccessfully() throws Exception {
        assertFalse(customer.returnBook("Python", library));
    }

    @Test
    public void should_return_true_when_check_out_movie_successfully() throws Exception {
        assertTrue(customer.checkOutMovie("Titanic", library));
    }

    @Test
    public void should_return_false_when_check_out_movie_unsuccessfully() throws Exception {
        assertFalse(customer.checkOutMovie("Avatar", library));
    }
}
