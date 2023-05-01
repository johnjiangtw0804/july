package com.coffee.july.account.account;

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
@CrossOrigin
@RequestMapping("/api/account")
public class AccountController {
    Logger logger = LoggerFactory.getLogger(AccountController.class);
    @Autowired
    private final AccountService service;

    public AccountController(AccountService repository) {
        this.service = repository;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody AccountItem item) {
        logger.info("AccountController: register");
        AccountItem account = service.register(item);
        logger.info("register: " + account.toString());
        return ResponseEntity.ok().body(account);
    }

    // this is log in API
    @GetMapping("/registerapii")
    public ResponseEntity<Object> login(@RequestBody Login login) {
        logger.info("AccountController: login");

        AccountItem account = service.login(login);
        
    }

    }

}
