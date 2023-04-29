
/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
   SPDX-License-Identifier: Apache-2.0
*/

package com.coffee.july.inventory.Inventory;

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

/*
 Before running this code example, create an Amazon DynamoDB table named Work with a primary key named id.
 */
@Repository
public class InventoryRepository {
    Logger logger = LoggerFactory.getLogger(InventoryRepository.class);

    private DynamoDbClient getClient() {
        Region region = Region.US_EAST_1;
        return DynamoDbClient.builder()
                .region(region)
                .build();
    }

    // Get All items from the DynamoDB table.
    public List<ProductItem> getAllItems() {
        DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
                .dynamoDbClient(getClient())
                .build();

        try {
            DynamoDbTable<Product> table = enhancedClient.table("Product", TableSchema.fromBean(Product.class));
            Iterator<Product> results = table.scan().items().iterator();
            ProductItem prodItem;
            ArrayList<ProductItem> itemList = new ArrayList<>();
            while (results.hasNext()) {
                Product current = results.next();
                prodItem = new ProductItem();
                prodItem.setName(current.getName());
                prodItem.setCount(current.getCount());
                prodItem.setPrice(current.getPrice());
                prodItem.setDescription(current.getDescription());

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