package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.service.CommandExecutor;
import com.twu.biblioteca.view.Page;

import static com.twu.biblioteca.controller.Status.*;

/**
 * Created by rzhou on 10/09/2017.
 */
public class CommandRouter {
    private CommandExecutor service;
    private Status statusNow = HOME_PAGE;

    public CommandRouter(CommandExecutor service, Library library) {
        this.service = service;
        service.setLibrary(library);
        service.display(Page.HOME_PAGE);
    }

    public CommandRouter(Library library) {
        service = new CommandExecutor();
        service.setLibrary(library);
        service.display(Page.HOME_PAGE);
    }

    public Status getStatusNow() {
        return statusNow;
    }

    public void commandMapping(String input) {
        switch (statusNow) {

            case HOME_PAGE: {
                switch (input) {
                    case "1":
                        statusNow = HOME_PAGE;
                        service.displayBookList();
                        service.display(Page.HOME_PAGE);
                        break;
                    case "2":
                        statusNow = CHECKOUT_BOOK_PAGE;
                        service.display(Page.CHECKOUT_BOOK_PAGE);
                        break;
                    case "3":
                        statusNow = RETURN_BOOK_PAGE;
                        service.display(Page.RETURN_BOOK_PAGE);
                        break;
                    case "4":
                        statusNow = HOME_PAGE;
                        service.displayMovieList();
                        service.display(Page.HOME_PAGE);
                        break;
                    case "5":
                        statusNow = CHECKOUT_MOVIE_PAGE;
                        service.display(Page.CHECKOUT_MOVIE_PAGE);
                        break;
                    default:
                        service.displayInputError();
                        break;
                }
            }
            break;

            case CHECKOUT_BOOK_PAGE:
                if (input.equals("h")) {
                    statusNow = HOME_PAGE;
                    service.display(Page.HOME_PAGE);
                    break;
                }
                service.checkOutBook(input);
                break;

            case RETURN_BOOK_PAGE:
                if (input.equals("h")) {
                    statusNow = HOME_PAGE;
                    service.display(Page.HOME_PAGE);
                    break;
                }
                service.returnBook(input);
                break;

            case CHECKOUT_MOVIE_PAGE:
                if (input.equals("h")) {
                    statusNow = HOME_PAGE;
                    service.display(Page.HOME_PAGE);
                    break;
                }
                service.checkOutMovie(input);
                break;
        }
    }
}
