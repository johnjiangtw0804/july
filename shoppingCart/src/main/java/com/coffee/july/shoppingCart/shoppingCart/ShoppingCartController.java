// SJSU CS 218 Spring 2023 TEAM1
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@CrossOrigin
@RequestMapping("/api/shoppingCart")
public class ShoppingCartController {
    Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);
    @Autowired
    private final ShoppingCartService service;

    public ShoppingCartController(ShoppingCartService repository) {
        this.service = repository;
    }

    @GetMapping("/carts")
    public ResponseEntity<Object> getCarts() {
        logger.info("ShoppingCartController: getItems");
        Map<String, List<CartItem>> map = new HashMap<>();
        List<CartItem> carts = service.getCarts();
        map.put("cartList", carts);
        logger.info("getCarts: Count " + carts.size() + " items: " + carts.toString());
        return ResponseEntity.ok().body(map);
    }
}
