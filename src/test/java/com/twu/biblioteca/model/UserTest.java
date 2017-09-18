package com.twu.biblioteca.model;

import org.junit.Before;
import org.junit.Test;

import static com.twu.biblioteca.LibraryFixture.buildLibrary;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by rzhou on 10/09/2017.
 */
public class UserTest {
    private Library library;
    private User user;

    @Before
    public void setUp() throws Exception {
        library = buildLibrary();
        user = new User();
    }

    @Test
    public void should_return_true_when_check_out_book_successfully() throws Exception {
        assertTrue(user.checkOutBook("Refactoring", library));
    }

    @Test
    public void should_return_false_when_check_out_book_unsuccessfully() throws Exception {
        assertFalse(user.checkOutBook("Python", library));
    }

    @Test
    public void should_return_true_when_put_back_book_successfully() throws Exception {
        assertTrue(user.returnBook("Knowledge Concept Maps", library));
    }

    @Test
    public void should_return_true_when_put_back_book_unsuccessfully() throws Exception {
        assertFalse(user.returnBook("Python", library));
    }

    @Test
    public void should_return_true_when_check_out_movie_successfully() throws Exception {
        assertTrue(user.checkOutMovie("Titanic", library));
    }

    @Test
    public void should_return_false_when_check_out_movie_unsuccessfully() throws Exception {
        assertFalse(user.checkOutMovie("Avatar", library));
    }
}
