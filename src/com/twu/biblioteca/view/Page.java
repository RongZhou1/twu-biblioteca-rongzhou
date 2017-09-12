package com.twu.biblioteca.view;

/**
 * Created by rzhou on 12/09/2017.
 */
public class Page {
    public static String HOME_PAGE = "1. List Available Books\n"
            + "2.Check-out Book\n"
            + "3.Return Book\n"
            + "Please input your choice(1-3) or \"q\" to quit:\n";

    private static String returnHomePage = "or \"h\" to return to home page:\n";

    public static String CHECKOUT_PAGE = "Please input the book name you want to checkout "
            + returnHomePage;

    public static String RETURN_PAGE = "Please input the book name you want to return "
            + returnHomePage;

}
