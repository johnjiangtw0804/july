// SJSU CS 218 Spring 2023 TEAM1
package com.coffee.july.inventory.Inventory;

public class ProductItem {

  private String name;
  private int count;
  private float price;
  private String description;

  public String getName() {
    return this.name;
  };

  public void setName(String name) {
    this.name = name;
  };

  public void setPrice(float price) {
    this.price = price;
  };

  public float getPrice() {
    return this.price;
  };

  public int getCount() {
    return this.count;
  };

  public void setCount(int count) {
    this.count = count;
  };

  public String getDescription() {
    return this.description;
  };

  public void setDescription(String description) {
    this.description = description;
  };
}
