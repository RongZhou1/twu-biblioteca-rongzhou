package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Customer;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Movie;
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
        this.library.setMovies(library.getMovies());
    }

    public String displayInputError() {
        System.out.print(Notice.errorInput);
        return Notice.errorInput;
    }

    public String displayBookList() {

        String bookListHeader = "Name\tAuthor\tPublishYear\n";
        String splitLine = "--------------------------------------\n";
        StringBuilder bookList = new StringBuilder(splitLine + bookListHeader + splitLine);

        for (int i = 0; i < library.getAvailableBooks().size(); i++) {
            Book book = library.getAvailableBooks().get(i);
            bookList.append(buildBookItem(book.getName(), book.getAuthor(), book.getPublishedYear()));
        }
        bookList.append(splitLine);

        System.out.print(bookList);
        return bookList.toString();
    }


    public String checkOutBook(String name) {
        String str;
        if (customer.checkOutBook(name, library)) {
            str = Notice.checkOutBookSuccess + Page.CHECKOUT_BOOK_PAGE;
        } else {
            str = Notice.checkOutBookFail + Page.CHECKOUT_BOOK_PAGE;
        }
        System.out.print(str);
        return str;
    }

    public String checkOutMovie(String name) {
        String str;
        if (customer.checkOutMovie(name, library)) {
            str = Notice.checkOutMovieSuccess + Page.CHECKOUT_MOVIE_PAGE;
        } else {
            str = Notice.checkOutMovieFail + Page.CHECKOUT_MOVIE_PAGE;
        }
        System.out.print(str);
        return str;
    }

    public String returnBook(String name) {
        String str;
        if (customer.returnBook(name, library)) {
            str = Notice.returnBookSuccess + Page.RETURN_BOOK_PAGE;
        } else {
            str = Notice.returnBookFail + Page.RETURN_BOOK_PAGE;
        }
        System.out.print(str);
        return str;
    }

    public String displayMovieList() {

        String movieListHeader = "Name\tYear\tDirector\tRating\n";
        String splitLine = "--------------------------------------\n";
        StringBuilder movieList = new StringBuilder(splitLine + movieListHeader + splitLine);

        for (int i = 0; i < library.getMovies().size(); i++) {
            Movie movie = library.getMovies().get(i);
            movieList.append(buildMovieItem(movie.getName(), movie.getYear(), movie.getDirector(), movie.getRating()));
        }
        movieList.append(splitLine);

        System.out.print(movieList);
        return movieList.toString();
    }

    private String buildBookItem(String name, String author, int publishedYear) {
        String bookItem = "%s|\t%s|\t%s\n";
        return String.format(bookItem, name, author, publishedYear);
    }

    private String buildMovieItem(String name, int year, String director, int rating) {
        String movieItem = "%s|\t%s|\t%s|\t%s\n";
        String str;
        if (rating == 0) {
            str = String.format(movieItem, name, year, director, "unrated");
        } else {
            str = String.format(movieItem, name, year, director, rating);
        }
        return str;
    }

    public String display(String displayContent) {
        System.out.print(displayContent);
        return displayContent;
    }
}
