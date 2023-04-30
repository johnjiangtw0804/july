
package com.coffee.july.account.account;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class Account {
    private String UserID;
    private String EmailAddress;
    private String Preferences;

    @DynamoDbPartitionKey
    public String getUserID() {
        return this.UserID;
    };

    public void setUserID(String UserID) {
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
