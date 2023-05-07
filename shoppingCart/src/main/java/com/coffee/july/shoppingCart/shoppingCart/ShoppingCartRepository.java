// SJSU CS 218 Spring 2023 TEAM1
package com.coffee.july.shoppingCart.shoppingCart;

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
      DynamoDbTable<Cart> table = enhancedClient.table("shopping_cart", TableSchema.fromBean(Cart.class));
      Iterator<Cart> results = table.scan().items().iterator();
      CartItem cartItem;
      List<CartItem> itemList = new ArrayList<>();
      while (results.hasNext()) {
        Cart current = results.next();
        cartItem = new CartItem();
        cartItem.setDeliveryAddress(current.getDeliveryAddress());
        cartItem.setPaidStatus(current.getPaidStatus());
        cartItem.setUserID(current.getUserID());
        cartItem.setCartItems(current.getCartItems());
        cartItem.setTotal(current.getTotal());

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
