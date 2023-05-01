package com.coffee.july.account.account;

public class AccountItem {
    private int UserID;
    private String EmailAddress;
    private String Preferences;

    public int getUserID() {
        return this.UserID;
    };

    public void setUserID(int UserID) {
        this.UserID = UserID;
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
