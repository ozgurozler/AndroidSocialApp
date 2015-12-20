package com.yenitsrm.androidsekmeliarayuz;

import com.com.javakaian.models.User;

/**
 * Created by serdar on 20.12.2015.
 */
public class Factory {
    private static User user;

    public static void initLoginUser(String name, String userName, String email, int age) {
        user = new User(name, userName, email,age);
    }

    public static User getUser() {
        return user;
    }
}
