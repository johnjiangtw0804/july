/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
   SPDX-License-Identifier: Apache-2.0
*/

package com.coffee.july.account.account;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class AccountRepository {
    Logger logger = LoggerFactory.getLogger(AccountRepository.class);

    private DynamoDbClient getClient() {
        Region region = Region.US_EAST_1;
        return DynamoDbClient.builder()
                .region(region)
                .build();
    }

    // Get All items from the DynamoDB table.
    public List<AccountItem> getAllAccounts() {
        DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
                .dynamoDbClient(getClient())
                .build();

        try {
            DynamoDbTable<Account> table = enhancedClient.table("account", TableSchema.fromBean(Account.class));
            Iterator<Account> results = table.scan().items().iterator();
            AccountItem prodItem;
            ArrayList<AccountItem> itemList = new ArrayList<>();
            while (results.hasNext()) {
                Account current = results.next();
                prodItem = new AccountItem();
                prodItem.setUserID(current.getUserID());
                prodItem.setEmailAddress(current.getEmailAddress());
                prodItem.setPreferences(current.getPreferences());

                // Push the workItem to the list.
                itemList.add(prodItem);
            }
            return itemList;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        return null;
    }

}
