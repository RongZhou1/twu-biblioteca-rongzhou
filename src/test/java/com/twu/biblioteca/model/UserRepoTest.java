package com.twu.biblioteca.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Created by rzhou on 18/09/2017.
 */
public class UserRepoTest {
    UserRepo userRepo;
    User user1;
    User user2;
    User user3;

    @Before
    public void setUp() throws Exception {
        userRepo = new UserRepo();
        user1 = new User("123-4444", "123456",
                "Jack", "Jack@twu.com", "ThoughtWorks University", "12345678900");
        user2 = new User("123-5555", "123456",
                "Linda", "Linda@twu.com", "ThoughtWorks University", "12345678900");
        user3 = new User("123-6666", "123456",
                "Ann", "Ann@twu.com", "ThoughtWorks University", "12345678900");
    }

    @Test
    public void should_find_user_successfully_given_correct_library_number() throws Exception {
        User result = userRepo.findUerByLibraryNumber("123-4444");
        assertThat(result.getName(), is(user1.getName()));
        assertThat(result.getAddress(), is(user1.getAddress()));
        assertThat(result.getEmail(), is(user1.getEmail()));
        assertThat(result.getPhone(), is(user1.getPhone()));
    }

    @Test
    public void should_return_null_given_not_exist_library_number() throws Exception {
        assertNull(userRepo.findUerByLibraryNumber("999-0000"));
    }
}