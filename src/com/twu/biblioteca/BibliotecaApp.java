package com.twu.biblioteca;

import com.twu.biblioteca.controller.CommandRouter;
import com.twu.biblioteca.controller.Status;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.service.CommandExecutor;

import java.util.Arrays;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        Library library;
        CommandExecutor service = new CommandExecutor();

        Book book1 = new Book("Refactoring", "Martin Fowler", 2015);
        Book book2 = new Book("Thinking in Java", "Bruce Eckel", 2017);
        Book book3 = new Book("Clean Code", "Robert C. Martin", 2010);

        library = new Library(Arrays.asList(book1, book2, book3));

        Book book4 = new Book("Knowledge Concept Maps", "Joseph D. Novak", 2016);
        Book book5 = new Book("Effective Java", "Joshua Bloch ", 2009);

        library.setLendingBooks(Arrays.asList(book4, book5));

        System.out.println("Welcome to Biblioteca!");
        CommandRouter controller = new CommandRouter(library);

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            if (input.equals("q")) break;
            controller.commandMapping(input);
        }
        sc.close();
        System.exit(0);
    }
}
