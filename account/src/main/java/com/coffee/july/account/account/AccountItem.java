package com.coffee.july.account.account;

public class AccountItem {
    private int userID;
    private String Password;
    private String emailAddress;
    private String preferences;

    public int getUserID() {
        return this.UserID;
    };

    public void setUserID(int UserID) {
        this.UserID = UserID;
    };

    public String getPassword() {
        return this.Password;
    };

    public void setPassword(String Password) {
        this.Password = Password;
    };

    public String getEmailAddress() {
        return this.EmailAddress;
    };

    public void setEmailAddress(String EmailAddress) {
        this.EmailAddress = EmailAddress;
    };

    public String getPreferences() {
        return this.Preferences;
    };

    public void setPreferences(String Preferences) {
        this.Preferences = Preferences;
    };
}
