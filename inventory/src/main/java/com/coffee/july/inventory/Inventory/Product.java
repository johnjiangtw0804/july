// SJSU CS 218 Spring 2023 TEAM1
package com.coffee.july.inventory.Inventory;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class Product {
    private String name;
    private int count;
    private float price;
    private String description;

    @DynamoDbPartitionKey
    public String getName() {
        return this.name;
    };

    public void setName(String name) {
        this.name = name;
    };

    public float getPrice() {
        return this.price;
    };

    @DynamoDbSortKey
    public void setPrice(float price) {
        this.price = price;
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
