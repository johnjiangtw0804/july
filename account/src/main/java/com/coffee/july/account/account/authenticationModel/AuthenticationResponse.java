package com.coffee.july.account.account.authenticationModel;

public class AuthenticationResponse {
    private final String access_token;

    public AuthenticationResponse(String jwt) {
        this.access_token = jwt;
    }

    public String getJwt() {
        return access_token;
    }

}