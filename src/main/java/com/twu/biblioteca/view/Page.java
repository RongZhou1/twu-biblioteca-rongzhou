package com.twu.biblioteca.view;

/**
 * Created by rzhou on 12/09/2017.
 */
public class Page {
    public static final String HOME_PAGE = "1. List Available Books\n"
            + "2. Check-out Book\n"
            + "3. Return Book\n"
            + "4. List all Movies\n"
            + "5. Check-out Movie\n"
            + "6. User Information\n"
            + "Please input your choice(1-5) or \"q\" to quit:\n";

    private static final String returnHomePage = "or \"h\" to return to home page:\n";

    public static final String CHECKOUT_BOOK_PAGE = "Please input the book name you want to check out "
            + returnHomePage;

    public static final String RETURN_BOOK_PAGE = "Please input the book name you want to return "
            + returnHomePage;

    public static final String CHECKOUT_MOVIE_PAGE = "Please input the movie name you want to check out"
            + returnHomePage;
}
