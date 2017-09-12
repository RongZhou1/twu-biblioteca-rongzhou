package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.service.CommandExecutor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rzhou on 13/09/2017.
 */
//@RunWith(MockitoJUnitRunner.class)
public class CommandRouterTest {

    private CommandRouter controller;

//    @Mock
    private CommandExecutor service;

    @Before
    public void setUp() throws Exception {
        controller = new CommandRouter(new Library());
    }

    @Test
    public void should_jump_into_book_list_page() throws Exception {
        controller.commandMapping("1");
        assertThat(controller.getStatusNow(), is(Status.HOME_PAGE));
//        verify(this.service, times(1)).display();

    }

    @Test
    public void should_jump_into_book_checkout_page() throws Exception {
        controller.commandMapping("2");
        assertThat(controller.getStatusNow(), is(Status.CHECKOUT_BOOK_PAGE));
    }

    @Test
    public void should_jump_into_book_return_page() throws Exception {
        controller.commandMapping("3");
        assertThat(controller.getStatusNow(), is(Status.RETURN_BOOK_PAGE));
    }

    @Test
    public void should_remain_home_page_given_input_invalid()throws Exception{
        controller.commandMapping("i");
        assertThat(controller.getStatusNow(),is(Status.HOME_PAGE));
    }

    @Test
    public void should_remain_book_checkout_page_until_input_h() throws Exception {
        controller.commandMapping("2");
        controller.commandMapping("some thing");
        assertThat(controller.getStatusNow(),is(Status.CHECKOUT_BOOK_PAGE));
    }

    @Test
    public void should_jump_back_to_home_page_given_h_in_checkout_page() throws Exception {
        controller.commandMapping("2");
        controller.commandMapping("h");
        assertThat(controller.getStatusNow(),is(Status.HOME_PAGE));
    }

    @Test
    public void should_remain_book_return_page_until_input_h() throws Exception {
        controller.commandMapping("3");
        controller.commandMapping("some thing");
        assertThat(controller.getStatusNow(),is(Status.RETURN_BOOK_PAGE));
    }

    @Test
    public void should_jump_back_to_home_page_given_h_in_return_page() throws Exception {
        controller.commandMapping("3");
        controller.commandMapping("h");
        assertThat(controller.getStatusNow(),is(Status.HOME_PAGE));
    }
}