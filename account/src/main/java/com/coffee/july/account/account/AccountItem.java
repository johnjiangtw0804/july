package com.coffee.july.account.account;

import com.coffee.july.account.account.authenticationModel.AuthenticationRequest;

public class AccountItem {
    private String emailAddress;
    private String password;
    private String preferences;

    public AccountItem() {
    }

    public AccountItem(AuthenticationRequest login) {
        this.emailAddress = login.getUsername();
        this.password = login.getPassword();
    }

    public String getPassword() {
        return this.password;
    };

    public void setPassword(String Password) {
        this.password = Password;
    };

    public String getEmailAddress() {
        return this.emailAddress;
    };

    public void setEmailAddress(String EmailAddress) {
        this.emailAddress = EmailAddress;
    };

    public String getPreferences() {
        return this.preferences;
    };

    public void setPreferences(String Preferences) {
        this.preferences = Preferences;
    };
}
