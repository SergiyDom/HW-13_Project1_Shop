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
        userList.add(new User("Ruslan", 6, "rus", "111", Roles.USER));
    }

    private Users() {
    }

    public static synchronized Users getInstance() {
        if (instance == null) {
            instance = new Users();
        }
        return instance;
    }

    public static boolean doesExist(String login, String password) {
        for (User user : userList) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public User getUser(String login, String password) throws Exception {
        for (User user : userList) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new Exception("User not found");
    }

    public void addUser(String login, String password, String name, int age) {
        if (!doesExist(login, password)) {
            userList.add(new User(name, age, login, password, Roles.USER));
        }
    }
}