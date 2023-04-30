package com.coffee.july.shoppingCart.shoppingCart;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shoppingCart")
public class ShoppingCartController {
    Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);
    @Autowired
    private final ShoppingCartService service;

    public ShoppingCartController(ShoppingCartService repository) {
        this.service = repository;
    }

    @GetMapping("/carts")
    public ResponseEntity<Object> getItems() {
        Map<String, List<CartItem>> map = new HashMap<>();
        logger.info("InventoryController: getItems");
        List<CartItem> items = service.getItems();
        map.put("itemList", items);
        logger.info("getAllItems: Count " + items.size() + " items: " + items.toString());
        return ResponseEntity.ok().body(map);
    }
}
