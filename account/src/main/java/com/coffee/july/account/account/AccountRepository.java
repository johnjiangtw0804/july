// SJSU CS 218 Spring 2023 TEAM1
package com.coffee.july.account.account;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class AccountRepository {
    public static final String TABLE_NAME = "account";
    Logger logger = LoggerFactory.getLogger(AccountRepository.class);

    private DynamoDbClient getClient() {
        Region region = Region.US_EAST_1;
        return DynamoDbClient.builder()
                .region(region)
                .build();
    }

    // Login to an existing account.
    public boolean isLogin(AccountItem loginAccount) {
        logger.info(loginAccount.getEmailAddress());
        DynamoDbClient ddb = getClient();
        Map<String, AttributeValue> keyToGet = new HashMap<>();
        keyToGet.put("emailAddress", AttributeValue.builder()
                .s(loginAccount.getEmailAddress())
                .build());

        GetItemRequest request = GetItemRequest.builder()
                .key(keyToGet)
                .tableName(TABLE_NAME)
                .build();

        try {
            Map<String, AttributeValue> returnedItem = ddb.getItem(request).item();

            if (returnedItem != null) {
                Set<String> keySet = returnedItem.keySet();
                // Assume there is only one returned item since no duplicate username allowed.
                String searchedPw = "";
                for (String key : keySet) {
                    if (key.equals("password")) {
                        searchedPw = returnedItem.get(key).s();
                        if (searchedPw.equals(loginAccount.getPassword())) {
                            logger.info("Account Repository: Logged in successfully!");
                            return true;
                        }
                    }
                }
                logger.info("Incorrect Password  " + loginAccount.getPassword());
            } else {
                logger.info("No item found with the key %s!\n", "year");
            }
        } catch (DynamoDbException e) {
            logger.error("AccountRepository: DynamoDB exception caught " + e.getMessage());
            System.exit(1);
        }
        return false;
    }

    // Register a new account.
    public AccountItem registerAccount(AccountItem newAccount) {
        DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
                .dynamoDbClient(getClient())
                .build();
        try {
            DynamoDbTable<Account> table = enhancedClient.table(TABLE_NAME, TableSchema.fromBean(Account.class));
            Account account = new Account();
            account.setEmailAddress(newAccount.getEmailAddress());
            account.setPassword(newAccount.getPassword());
            account.setPreferences(newAccount.getPreferences());
            table.putItem(account);

            return newAccount;
        } catch (Exception e) {
            logger.error("AccountRepository: DynamoDB exception caught " + e.getMessage());
        }

        return null;
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
                prodItem.setEmailAddress(current.getEmailAddress());
                prodItem.setPreferences(current.getPreferences());

                // Push the workItem to the list.
                itemList.add(prodItem);
            }
            return itemList;

        } catch (Exception e) {
            logger.error("AccountRepository: DynamoDB exception caught " + e.getMessage());
            System.exit(1);
        }
        return null;
    }

}
