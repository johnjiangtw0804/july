package com.coffee.july.shoppingcart;

import java.util.ArrayList;
import java.util.List;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class Cart {

  private String UserID;
  private ArrayList<List<String>> CartItems;
  private String DeliveryAddress;
  private float Total;
  private boolean isPaid;

  @DynamoDbPartitionKey
  public String getUserID() {
    return this.UserID;
  };

  public void setUserID(String UserID) {
    this.UserID = UserID;
  };

  public ArrayList<List<String>> getCartItems() {
    return this.CartItems;
  };

  public void setCartItems(ArrayList<List<String>> CartItems) {
    this.CartItems = CartItems;
  };

  public float getTotal() {
    return this.Total;
  };

  public void setTotal(float Total) {
    this.Total = Total;
  };

  public String getDeliveryAddress() {
    return this.DeliveryAddress;
  };

  public void setDeliveryAddress(String DeliveryAddress) {
    this.DeliveryAddress = DeliveryAddress;
  };

  public boolean getPaidStatus() {
    return this.isPaid;
  };

  public void setPaidStatus(boolean isPaid) {
    this.isPaid = isPaid;
  };
}
