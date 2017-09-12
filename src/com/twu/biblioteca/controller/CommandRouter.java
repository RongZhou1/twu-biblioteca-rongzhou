package com.twu.biblioteca.controller;

import com.twu.biblioteca.service.CommandExecutor;

/**
 * Created by rzhou on 10/09/2017.
 */
public class CommandRouter {
    CommandExecutor service = new CommandExecutor();
    Status statusNow = Status.HOME_PAGE;

    public void commandMapping(String input) {
        switch (statusNow) {

            case HOME_PAGE: {
                switch (input) {
                    case "1":
                        statusNow = Status.BOOK_LIST_PAGE;
                        break;
                    case "2":
                        statusNow = statusNow.CHECKOUT_BOOK_PAGE;
                        break;
                    case "3":
                        statusNow = statusNow.RETURN_BOOK_PAGE;
                        break;
                    default:
                        service.displayInputError();
                        break;
                }
            }
            break;

            case BOOK_LIST_PAGE: {
                if (input == "h") {
                    statusNow = Status.HOME_PAGE;
                }
                service.buildBookList();
            }
            break;

            case CHECKOUT_BOOK_PAGE:
                if (input == "h") {
                    statusNow = Status.HOME_PAGE;
                }
                service.checkoutBook(input);
                break;

            case RETURN_BOOK_PAGE:
                if (input == "h") {
                    statusNow = statusNow.HOME_PAGE;
                }
                service.returnBook(input);
                break;
        }
    }
}
