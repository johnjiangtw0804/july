// SJSU CS 218 Spring 2023 TEAM1
package com.coffee.july.account.account;

public class RegisterRequest {

    private String username;
    private String password;
    private String description;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "username: " + username + " password: " + password + " description: " + description;
    }
}