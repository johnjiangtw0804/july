package com.coffee.july.inventory.Inventory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    Logger logger = LoggerFactory.getLogger(InventoryController.class);
    @Autowired
    private final InventoryService service;

    public InventoryController(InventoryService repository) {
        this.service = repository;
    }

    @GetMapping("/items")
    public ResponseEntity<Object> getItems() {
        Map<String, List<ProductItem>> map = new HashMap<>();
        logger.info("InventoryController: getItems");
        List<ProductItem> items = service.getItems();
        map.put("itemList", items);
        logger.info("getAllItems: Count " + items.size() + " items: " + items.toString());
        return ResponseEntity.ok().body(map);
    }
}
