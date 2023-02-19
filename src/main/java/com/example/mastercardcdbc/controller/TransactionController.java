package com.example.mastercardcdbc.controller;

import com.example.mastercardcdbc.domain.AccountRequest;
import com.example.mastercardcdbc.domain.TransactionRequest;
import com.example.mastercardcdbc.domain.UserRequest;
import com.example.mastercardcdbc.exception.ResourceNotFoundException;
import com.example.mastercardcdbc.exception.TransactionException;
import com.example.mastercardcdbc.service.AccountService;
import com.example.mastercardcdbc.service.TransactionService;
import com.example.mastercardcdbc.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    UserService userService;

    @Autowired
    AccountService accountService;

    @Autowired
    TransactionService transactionService;


    @PostMapping(value = "/saveUser")
    public ResponseEntity<String> saveUser(@Valid @RequestBody UserRequest userRequest) {
        userService.createUser(userRequest);
        return new ResponseEntity<>("User Created Successfully", HttpStatus.CREATED);
    }


    @PostMapping(value = "/saveAccount")
    public ResponseEntity<String> saveAccount(@Valid @RequestBody AccountRequest accountRequest) throws ResourceNotFoundException {
        accountService.createAccount(accountRequest);
        return new ResponseEntity<>("Account Created Successfully", HttpStatus.CREATED);
    }

    @PostMapping(value = "/transaction")
    public ResponseEntity<String> saveTransaction(@Valid @RequestBody TransactionRequest transactionRequest) throws TransactionException {
        transactionService.transaction(transactionRequest);
        return new ResponseEntity<>("Transaction Completed Successfully", HttpStatus.OK);
    }

}
