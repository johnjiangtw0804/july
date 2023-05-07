// SJSU CS 218 Spring 2023 TEAM1
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
    Logger logger = LoggerFactory.getLogger(AccountController.class);
    @Autowired
    private final AccountService service;

    public AccountController(AccountService repository) {
        this.service = repository;
    }

    // this is to register a new account
    @PostMapping("/process_register")
    public ResponseEntity<Object> register(@RequestBody RegisterRequest registerRequest, ServletWebRequest webRequest) {
        logger.info("AccountController: register " + registerRequest.toString());
        AccountItem newAccount = new AccountItem(registerRequest);
        if (newAccount.getEmailAddress() == null || newAccount.getPassword() == null) {
            logger.info("register: emailAddress or password is null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if (newAccount.getPreferences() == null) {
            newAccount.setPreferences("I like coffee");
        }
        AccountItem newAccountItem = service.register(newAccount);
        logger.info("register successfully: " + newAccountItem.getEmailAddress());

        HttpServletRequest request = webRequest.getRequest();
        URI location = ServletUriComponentsBuilder.fromRequest(request)
                .path("/{userName}").buildAndExpand(newAccountItem.getEmailAddress())
                .toUri();
        logger.info("createPlan: plan created. Plan = " + newAccountItem.toString());

        return ResponseEntity.created(location).body(registerRequest);
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
