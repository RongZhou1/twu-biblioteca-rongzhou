package com.twu.biblioteca.model;

/**
 * Created by rzhou on 10/09/2017.
 */
public class User {

    private String libraryNumber;
    private String password;
    private String name;
    private String email;
    private String address;
    private String phone;

    public User() {
    }

    public User(String libraryNumber, String password, String name, String email, String address, String phone) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public boolean checkOutBook(String name, Library library) {
        return library.takeOutBook(name);
    }

    public boolean returnBook(String name, Library library) {
        return library.putBackBook(name);
    }

    public boolean checkOutMovie(String name, Library library) {
        return library.takeOutMovie(name);
    }
}
