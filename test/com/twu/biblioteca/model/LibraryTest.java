package com.twu.biblioteca.model;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rzhou on 10/09/2017.
 */
public class LibraryTest {
    private Library library;

    @Before
    public void setUp() throws Exception {
        Book book1 = new Book("Refactoring", "Martin Fowler", 2015);
        Book book2 = new Book("Thinking in Java", "Bruce Eckel", 2017);
        Book book3 = new Book("Clean Code", "Robert C. Martin", 2010);

        library = new Library(Arrays.asList(book1, book2, book3));

        Book book4 = new Book("Knowledge Concept Maps", "Joseph D. Novak", 2016);
        Book book5 = new Book("Effective Java", "Joshua Bloch ", 2009);

        library.setLendingBooks(Arrays.asList(book4, book5));
    }

    @Test
    public void should_return_index_when_find_available_book_by_name() throws Exception {
        assertThat(library.findBookByName(1, "Refactoring"), is(0));
    }

    @Test
    public void should_return_minus_1_when_find_unavailable_book_in_available_list() throws Exception {
        assertThat(library.findBookByName(1, "Head First Java"), is(-1));
    }

    @Test
    public void should_return_index_when_find_lending_book_by_name() throws Exception {
        assertThat(library.findBookByName(2, "Effective Java"), is(1));
    }

    @Test
    public void should_return_minus_1_when_find_not_lending_book_in_lending_list() throws Exception {
        assertThat(library.findBookByName(2, "C++ Primer"), is(-1));
    }

    @Test
    public void should_return_true_when_take_out_book_successfully() throws Exception {
        assertThat(library.takeOutBook("Refactoring"), is(true));
        assertThat(library.getAvailableBooks().size(), is(2));
        assertThat(library.getLendingBooks().size(), is(3));
        assertThat(library.findBookByName(1, "Refactoring"), is(-1));
        assertThat(library.findBookByName(2, "Refactoring") != -1, is(true));
    }

    @Test
    public void should_return_false_when_take_out_unavailable_book() throws Exception {
        assertThat(library.takeOutBook("Python"), is(false));
        assertThat(library.getAvailableBooks().size(), is(3));
        assertThat(library.getLendingBooks().size(), is(2));
    }

    @Test
    public void should_return_true_when_put_back_book_successfully() throws Exception {
        assertThat(library.putBackBook("Effective Java"), is(true));
        assertThat(library.getAvailableBooks().size(), is(4));
        assertThat(library.getLendingBooks().size(), is(1));
        assertThat(library.findBookByName(1, "Effective Java") != -1, is(true));
        assertThat(library.findBookByName(2, "Effective Java"), is(-1));
    }

    @Test
    public void should_return_false_when_put_back_unsuccessfully() throws Exception {
        assertThat(library.putBackBook("Python"), is(false));
        assertThat(library.getAvailableBooks().size(), is(3));
        assertThat(library.getLendingBooks().size(), is(2));
    }

}
