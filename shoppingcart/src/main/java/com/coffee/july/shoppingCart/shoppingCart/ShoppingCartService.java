package com.coffee.july.shoppingCart.shoppingCart;

import org.springframework.stereotype.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ShoppingCartService {
    ShoppingCartRepository repository;
    Logger logger = LoggerFactory.getLogger(ShoppingCartService.class);

    public ShoppingCartService(ShoppingCartRepository repository) {
        this.repository = repository;
    }

    public List<CartItem> getItems() {
        logger.info("ShoppingCart Service: getItems");
        List<CartItem> result = repository.getAllCarts();
        return result;
    }
}