// SJSU CS 218 Spring 2023 TEAM1
package com.coffee.july.account.account;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDbBean
@DynamoDBTable(tableName = "account")
public class Account {

    @DynamoDBAttribute(attributeName = "emailAddress")
    private String emailAddress;

    @DynamoDBAttribute(attributeName = "password")
    private String password;

    private String preferences;

    @DynamoDbPartitionKey
    public String getEmailAddress() {
        return this.emailAddress;
    };

    public void setEmailAddress(String EmailAddress) {
        this.emailAddress = EmailAddress;
    };

    public String getPassword() {
        return this.password;
    };

    public void setPassword(String Password) {
        this.password = Password;
    };

    @DynamoDbSortKey
    @DynamoDBAttribute(attributeName = "preferences")
    public String getPreferences() {
        return this.preferences;
    };

    public void setPreferences(String Preferences) {
        this.preferences = Preferences;
    };
}
