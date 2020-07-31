package com.domaranskiy.database;

import com.domaranskiy.entities.models.user.Roles;
import com.domaranskiy.entities.models.user.User;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private static Users instance;
    private static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User("Sergiy", 30, "Ser", "123", Roles.ADMIN));
        userList.add(new User("Ruslan", 6, "test", "111", Roles.USER));
    }

    private Users() {
    }

    public static synchronized Users getInstance() {
        if (instance == null) {
            instance = new Users();
        }
        return instance;
    }
}