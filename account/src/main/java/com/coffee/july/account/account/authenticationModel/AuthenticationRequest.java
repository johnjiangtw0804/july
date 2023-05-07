// SJSU CS 218 Spring 2023 TEAM1
package com.coffee.july.account.account.authenticationModel;

public class AuthenticationRequest {

    private String username;
    private String password;

    public AuthenticationRequest() {

    }

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

    public AuthenticationRequest(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

}