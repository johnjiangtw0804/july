package com.coffee.july.account.account;

import org.springframework.stereotype.Service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AccountService {
    AccountRepository repository;
    Logger logger = LoggerFactory.getLogger(AccountService.class);

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public AccountItem register(AccountItem item) {
        logger.info("Account Service: register");
        AccountItem result = repository.register(item);
        return result;
    }

    public AccountItem login(Login login) {
        logger.info("Account Service: login");
        AccountItem result = repository.login(login);
        return result;
    }

    // public List<AccountItem> getAccounts() {
    //     logger.info("Account Service: getAccounts");
    //     List<AccountItem> result = repository.getAllAccounts();
    //     return result;
    // }
}
