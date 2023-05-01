package com.coffee.july.account.account;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.coffee.july.account.account.authenticationModel.AuthenticationRequest;
import com.coffee.july.account.account.authenticationModel.AuthenticationResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/api/account")
public class AccountController {
    private static class userID {
        private static int id = 0;

        public synchronized static int getID() {
            return id++;
        }
    }

    Logger logger = LoggerFactory.getLogger(AccountController.class);
    @Autowired
    private final AccountService service;

    public AccountController(AccountService repository) {
        this.service = repository;
    }

    // this is to register a new account
    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody AuthenticationRequest account, ServletWebRequest webRequest) {
        logger.info("AccountController: register" + account.toString());
        AccountItem newAccount = new AccountItem(account);
        newAccount.setPreferences("I like coffee");
        AccountItem newAccountItem = service.register(newAccount);
        logger.info("register successfully: " + newAccountItem.getEmailAddress());

        HttpServletRequest request = webRequest.getRequest();
        URI location = ServletUriComponentsBuilder.fromRequest(request)
                .path("/{id}").buildAndExpand(newAccountItem.getEmailAddress())
                .toUri();
        logger.info("createPlan: plan created. Plan = " + newAccountItem.toString());

        return ResponseEntity.created(location).body(account);
    }

    // this is log in API
    @PostMapping("/registerapii")
    public ResponseEntity<Object> login(@RequestBody AuthenticationRequest login) {
        logger.info("AccountController: login" + login.getUsername() + " " +
                login.getPassword());
        AccountItem logInAccount = new AccountItem(login);
        logger.info(logInAccount.getEmailAddress() + " " + logInAccount.getPassword());
        AccountItem account = service.login(logInAccount);

        if (account == null) {
            logger.info("login: account is null");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        logger.info("login completed");

        AuthenticationResponse response = new AuthenticationResponse("this is a fake token");
        return ResponseEntity.ok().body(response);
    }
}
