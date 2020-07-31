package com.domaranskiy.entities.models.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String name;
    private int age;
    private String login;
    private String password;
    private Roles role;

    public User(String name, int age, String login, String password, Roles role) {
        this.name = name;
        this.age = age;
        this.login = login;
        this.password = password;
        this.role = role;
    }
}