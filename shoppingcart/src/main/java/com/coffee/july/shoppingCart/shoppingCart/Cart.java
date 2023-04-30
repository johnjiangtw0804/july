/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
   SPDX-License-Identifier: Apache-2.0
*/

// package com.aws.rest;
package com.coffee.july.shoppingCart.shoppingCart;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
@DynamoDBTable(tableName = "shopping_cart")
public class Cart {

  @DynamoDBAttribute(attributeName = "userID")
  public int userID;

  @DynamoDBAttribute(attributeName = "cartItems")
  private Map<String, String> cartItems;

  @DynamoDBAttribute(attributeName = "deliveryAddress")
  private String deliveryAddress;

  @DynamoDBAttribute(attributeName = "total")
  private float total;

  @DynamoDBAttribute(attributeName = "isPaid")
  private boolean isPaid;

  public int getUserID() {
    return this.userID;
  };

  public void setUserID(int userID) {
    this.userID = userID;
  };

  public Map<String, String> getCartItems() {
    return this.cartItems;
  };

  public void setCartItems(Map<String, String> cartItems) {
    this.cartItems = cartItems;
  };

  @DynamoDbSortKey
  public float getTotal() {
    return this.total;
  };

  public void setTotal(float total) {
    this.total = total;
  };

  public String getDeliveryAddress() {
    return this.deliveryAddress;
  };

  public void setDeliveryAddress(String deliveryAddress) {
    this.deliveryAddress = deliveryAddress;
  };

  public boolean getPaidStatus() {
    return this.isPaid;
  };

  public void setPaidStatus(boolean isPaid) {
    this.isPaid = isPaid;
  };
}