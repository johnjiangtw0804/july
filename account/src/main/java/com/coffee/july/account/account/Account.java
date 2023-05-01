
package com.coffee.july.account.account;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDbBean
@DynamoDBTable(tableName = "account")
public class Account {

    @DynamoDBAttribute(attributeName = "userID")
    private int UserID;

    @DynamoDBAttribute(attributeName = "emailAddress")
    private String EmailAddress;

    @DynamoDBAttribute(attributeName = "preferences")
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
