package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.Notice;
import com.twu.biblioteca.view.Page;
import org.junit.Before;
import org.junit.Test;

import static com.twu.biblioteca.LibraryFixture.buildLibrary;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


/**
 * Created by rzhou on 12/09/2017.
 */
public class CommandExecutorTest {

    private CommandExecutor service = new CommandExecutor();

    @Before
    public void setUp() throws Exception {
        Library library = buildLibrary();
        service.setLibrary(library);
    }

    @Test
    public void should_display_input_error() throws Exception {
        String result = "Select a valid option!\n";
        assertThat(service.displayInputError(), is(result));
    }

    @Test
    public void should_list_all_available_books() throws Exception {
        String result = "--------------------------------------\n"
                + "Name\tAuthor\tPublishYear\n"
                + "--------------------------------------\n"
                + "Refactoring|\tMartin Fowler|\t2015\n"
                + "Thinking in Java|\tBruce Eckel|\t2017\n"
                + "Clean Code|\tRobert C. Martin|\t2010\n"
                + "--------------------------------------\n";
        assertThat(service.displayBookList(), is(result));
    }

    @Test
    public void should_list_all_movies() throws Exception {
        String result = "--------------------------------------\n"
                + "Name\tYear\tDirector\tRating\n"
                + "--------------------------------------\n"
                + "Titanic|\t1997|\tJames Cameron|\t8\n"
                + "Forrest Gump|\t1993|\tRobert Zemeckis|\t9\n"
                + "The Terminator|\t1984|\tJames Cameron|\tunrated\n"
                + "--------------------------------------\n";
        assertThat(service.displayMovieList(), is(result));
    }

    @Test
    public void should_display_checkout_success() throws Exception {
        service.login("123-4444", "123456");
        assertThat(service.checkOutBook("Refactoring"), is(Notice.checkOutBookSuccess + Page.CHECKOUT_BOOK_PAGE));
    }

    @Test
    public void should_display_checkout_fail() throws Exception {
        service.login("123-4444", "123456");
        assertThat(service.checkOutBook("Python"), is(Notice.checkOutBookFail + Page.CHECKOUT_BOOK_PAGE));
    }

    @Test
    public void should_display_return_book_success() throws Exception {
        service.login("123-4444", "123456");
        assertThat(service.returnBook("Effective Java"), is(Notice.returnBookSuccess + Page.RETURN_BOOK_PAGE));
    }

    @Test
    public void should_display_return_book_fail() throws Exception {
        service.login("123-4444", "123456");
        assertThat(service.returnBook("Python"), is(Notice.returnBookFail + Page.RETURN_BOOK_PAGE));
    }

    @Test
    public void should_display_return_movie_success() throws Exception {
        service.login("123-4444", "123456");
        assertThat(service.checkOutMovie("Titanic"), is(Notice.checkOutMovieSuccess + Page.CHECKOUT_MOVIE_PAGE));
    }

    @Test
    public void should_display_return_movie_fail() throws Exception {
        service.login("123-4444", "123456");
        assertThat(service.checkOutMovie("Avatar"), is(Notice.checkOutMovieFail + Page.CHECKOUT_MOVIE_PAGE));
    }

    @Test
    public void should_display_user_info() throws Exception {
        String result = "--------------------------------------\n"
                + "Name: Jack\n"
                + "Email: Jack@twu.com\n"
                + "Address: ThoughtWorks University\n"
                + "Phone: 12345678900\n"
                + "--------------------------------------\n";
        service.login("123-4444", "123456");
        assertThat(service.displayUserInfo(), is(result));
    }

    @Test
    public void should_log_in_successfully_given_correct_library_number_and_password() throws Exception {
        assertTrue(service.login("123-4444", "123456"));
    }

    @Test
    public void should_log_in_failed_given_incorrect_library_number() throws Exception {
        assertFalse(service.login("123-4", "123456"));
    }

    @Test
    public void should_log_in_failed_given_incorrect_password() throws Exception {
        assertFalse(service.login("123-4444", "000"));
    }
}