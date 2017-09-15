package com.twu.biblioteca.model;


import org.junit.Before;
import org.junit.Test;

import static com.twu.biblioteca.LibraryFixture.buildLibrary;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by rzhou on 10/09/2017.
 */
public class LibraryTest {
    private Library library;

    @Before
    public void setUp() throws Exception {
        library = buildLibrary();
    }

    @Test
    public void should_return_true_when_take_out_book_successfully() throws Exception {
        assertTrue(library.takeOutBook("Refactoring"));
        assertThat(library.getAvailableBooks().size(), is(2));
        assertThat(library.getLendingBooks().size(), is(3));
    }

    @Test
    public void should_return_false_when_take_out_unavailable_book() throws Exception {
        assertFalse(library.takeOutBook("Python"));
        assertThat(library.getAvailableBooks().size(), is(3));
        assertThat(library.getLendingBooks().size(), is(2));
    }

    @Test
    public void should_return_true_when_put_back_book_successfully() throws Exception {
        assertTrue(library.putBackBook("Effective Java"));
        assertThat(library.getAvailableBooks().size(), is(4));
        assertThat(library.getLendingBooks().size(), is(1));
    }

    @Test
    public void should_return_false_when_put_back_book_unsuccessfully() throws Exception {
        assertFalse(library.putBackBook("Python"));
        assertThat(library.getAvailableBooks().size(), is(3));
        assertThat(library.getLendingBooks().size(), is(2));
    }

    @Test
    public void should_return_true_when_take_out_movie_successfully() throws Exception {
        assertTrue(library.takeOutMovie("The Terminator"));
        assertThat(library.getMovies().size(), is(3));
    }

    @Test
    public void should_return_false_when_take_out_movie_unsuccessfully() throws Exception {
        assertFalse(library.takeOutMovie("Avatar"));
        assertThat(library.getMovies().size(), is(3));
    }
}
