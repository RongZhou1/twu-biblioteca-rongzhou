package com.twu.biblioteca;

import com.twu.biblioteca.controller.CommandRouter;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca!");

        CommandRouter controller=new CommandRouter();

//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            controller.commandMapping(sc.nextLine());
//            if (controller.getStatusNow() == CurrentStatus.EXIT_PAGE) break;
//        }
//        sc.close();
//        System.exit(0);
    }
}
