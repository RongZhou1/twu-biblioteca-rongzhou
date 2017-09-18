package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.service.CommandExecutor;
import com.twu.biblioteca.view.Notice;
import com.twu.biblioteca.view.Page;

import java.util.Objects;
import java.util.Scanner;

import static com.twu.biblioteca.controller.Status.*;

/**
 * Created by rzhou on 10/09/2017.
 */
public class CommandRouter {
    private CommandExecutor service;
    private Status statusNow = HOME_PAGE;
    private int count = 0;
    private String libraryNumber = "";

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
                        if (service.isLogined()) {
                            statusNow = CHECKOUT_BOOK_PAGE;
                            service.display(Page.CHECKOUT_BOOK_PAGE);
                        } else {
                            statusNow = LOGIN_PAGE;
                            service.display(Page.LOGIN_PAGE);
                        }
                        break;
                    case "3":
                        if (service.isLogined()) {
                            statusNow = RETURN_BOOK_PAGE;
                            service.display(Page.RETURN_BOOK_PAGE);
                        } else {
                            statusNow = LOGIN_PAGE;
                            service.display(Page.LOGIN_PAGE);
                        }
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
                    case "6":
                        if (service.isLogined()) {
                            statusNow = HOME_PAGE;
                            service.displayUserInfo();
                            service.display(Page.HOME_PAGE);
                        } else {
                            statusNow = LOGIN_PAGE;
                            service.display(Page.LOGIN_PAGE);
                        }
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
            case LOGIN_PAGE:
                if (input.equals("h")) {
                    statusNow = HOME_PAGE;
                    service.display(Page.HOME_PAGE);
                    break;
                }
                if (count == 0) {
                    libraryNumber = input;
                    count++;
                } else {
                    String password = input;
                    if (service.login(libraryNumber, password)) {
                        statusNow = HOME_PAGE;
                        service.display(Notice.loginSuccess + Page.HOME_PAGE);
                    } else {
                        service.display(Notice.loginFail + Page.LOGIN_PAGE);
                        count = 0;
                    }
                }

                break;
        }
    }
}
