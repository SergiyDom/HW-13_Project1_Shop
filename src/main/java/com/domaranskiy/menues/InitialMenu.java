package com.domaranskiy.menues;

import com.domaranskiy.database.Users;
import com.domaranskiy.menues.abs.Menu;
import com.domaranskiy.models.user.User;

public class InitialMenu extends Menu {
    Users users;

    public InitialMenu() {
        users = Users.getInstance();
        setMainMenuItem("1. Log in");
        setMainMenuItem("2. Sing in");
    }

    @Override
    protected void handleCallbacks() {

    }

    @Override
    protected void navigation() throws Exception {
        switch (getMenuItem()) {
            case 1 -> logIn();
            case 2 -> singIn();
            case 0 -> System.exit(0);
            default -> showMenuMessage("Unknown menu item");
        }
    }

    private void logIn() throws Exception {
        String login = getLogin();
        String password = getPassword();
        if (users.doesExist(login, password)) {
            defineNextMenu(users.getUser(login, password)).run();
        } else {
            showMenuMessage("User not found");
        }
    }

    private void singIn() throws Exception {
        String login = getLogin();
        String password = getPassword();
        String name = getName();
        int age = getAge();
        if (users.doesExist(login, password)) {
            showMenuMessage("Such user already exists");
        } else {
            users.addUser(login, password, name, age);
            showMenuMessage("New user: " + name + " has been created");
        }
        showMenuMessage("Use his credentials to log-in");
    }

    private Menu defineNextMenu(User user) {
        return switch (user.getRole()) {
            case ADMIN -> new AdminMenu(user, this);
            case USER -> new UserMenu(user, this);
        };
    }
}