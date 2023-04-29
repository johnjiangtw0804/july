/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
   SPDX-License-Identifier: Apache-2.0
*/

// package com.aws.rest;
package com.coffee.july.inventory;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class Product {
    private String name;
    private Integer count;
    private Float price;
    private String img;
    private String description;

    @DynamoDbPartitionKey
    public String getName() {
        return this.name;
    };

    public void setName(String name) {
        this.name = name;
    };

    @DynamoDbSortKey
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
