package com.twu.biblioteca;

import com.twu.biblioteca.controller.CommandRouter;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.service.CommandExecutor;

import java.util.Arrays;
import java.util.Scanner;

public class BibliotecaApp {


    public static void main(String[] args) {

        Book book1 = new Book("Refactoring", "Martin Fowler", 2015);
        Book book2 = new Book("Thinking in Java", "Bruce Eckel", 2017);
        Book book3 = new Book("Clean Code", "Robert C. Martin", 2010);

        Library library = new Library(Arrays.asList(book1, book2, book3));

        Book book4 = new Book("Knowledge Concept Maps", "Joseph D. Novak", 2016);
        Book book5 = new Book("Effective Java", "Joshua Bloch ", 2009);

        library.setLendingBooks(Arrays.asList(book4, book5));

        Movie movie1 = new Movie("Titanic", 1997, "James Cameron", 8);
        Movie movie2 = new Movie("Forrest Gump", 1993, "Robert Zemeckis", 9);
        Movie movie3 = new Movie("The Terminator", 1984, "James Cameron");

        library.setMovies(Arrays.asList(movie1, movie2, movie3));

        CommandExecutor service = new CommandExecutor();
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
