package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rzhou on 18/09/2017.
 */
public class UserRepo {

    private List<User> users =new ArrayList<>();

    public UserRepo() {
        User user1 = new User("123-4444", "123456",
                "Jack", "Jack@twu.com", "ThoughtWorks University", "12345678900");
        User user2 = new User("123-5555", "123456",
                "Linda", "Linda@twu.com", "ThoughtWorks University", "12345678900");
        User user3 = new User("123-6666", "123456",
                "Ann", "Ann@twu.com", "ThoughtWorks University", "12345678900");
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    public User findUerByLibraryNumber(String libraryNumber) {
        for (int i = 0; i < users.size(); i++) {
            if (libraryNumber.equals(users.get(i).getLibraryNumber())) {
                return users.get(i);
            }
        }
        return null;
    }
}
