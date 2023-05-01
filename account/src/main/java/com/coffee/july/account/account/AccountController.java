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
@RequestMapping("/api/account")
public class AccountController {
    Logger logger = LoggerFactory.getLogger(AccountController.class);
    @Autowired
    private final AccountService service;

    public AccountController(AccountService repository) {
        this.service = repository;
    }

    @GetMapping("/items")
    public ResponseEntity<Object> getAccounts() {
        Map<String, List<AccountItem>> map = new HashMap<>();
        logger.info("AccountItemController: getAccounts");
        List<AccountItem> accounts = service.getAccounts();
        map.put("accountList", accounts);
        logger.info("getAccounts: Count " + accounts.size() + " accounts: " + accounts.toString());
        return ResponseEntity.ok().body(map);
    }

}
