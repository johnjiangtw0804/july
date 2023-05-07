// SJSU CS 218 Spring 2023 TEAM1
package com.coffee.july.inventory.Inventory;

import org.springframework.stereotype.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class InventoryService {
    InventoryRepository repository;
    Logger logger = LoggerFactory.getLogger(InventoryService.class);

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    public List<ProductItem> getItems() {
        logger.info("Inventory Service: getItems");
        List<ProductItem> result = repository.getAllItems();
        return result;
    }
}