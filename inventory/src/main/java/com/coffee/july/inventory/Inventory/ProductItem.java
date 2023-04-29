package com.coffee.july.inventory.Inventory;

public class ProductItem {

  private String name;
  private Integer count;
  private Float price;
  private String img;
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

  public Float getPrice() {
    return this.price;
  };

  public Integer getCount() {
    return this.count;
  };

  public void setCount(int count) {
    this.count = count;
  };

  public String getImg() {
    return this.img;
  };

  public void setImg(String img) {
    this.img = img;
  };

  public String getDescription() {
    return this.description;
  };

  public void setDescription(String description) {
    this.description = description;
  };
}
