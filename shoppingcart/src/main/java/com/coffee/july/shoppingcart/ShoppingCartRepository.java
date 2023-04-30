package com.coffee.july.shoppingcart;

/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
   SPDX-License-Identifier: Apache-2.0
*/
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
public class ShoppingCartRepository {
  Logger logger = LoggerFactory.getLogger(ShoppingCartRepository.class);

  private DynamoDbClient getClient() {
    Region region = Region.US_EAST_1;
    return DynamoDbClient.builder()
        .region(region)
        .build();
  }

  // Get All items from the DynamoDB table.
  public List<CartItem> getAllCarts() {
    DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
        .dynamoDbClient(getClient())
        .build();

    try {
      DynamoDbTable<Cart> table = enhancedClient.table("Cart", TableSchema.fromBean(Cart.class));
      Iterator<Cart> results = table.scan().items().iterator();
      CartItem cartItem;
      ArrayList<CartItem> itemList = new ArrayList<>();
      while (results.hasNext()) {
        Cart current = results.next();
        cartItem = new CartItem();
        cartItem.setUserID(current.getUserID());
        cartItem.setCartItems(current.getCartItems());
        cartItem.setDeliveryAddress(current.getDeliveryAddress());
        cartItem.setTotal(current.getTotal());
        cartItem.setPaidStatus(current.getPaidStatus());

        // Push the workItem to the list.
        itemList.add(cartItem);
      }
      return itemList;

    } catch (Exception e) {
      System.err.println(e.getMessage());
      System.exit(1);
    }
    return null;
  }
}
