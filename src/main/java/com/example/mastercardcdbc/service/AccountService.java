package com.example.mastercardcdbc.service;

import com.example.mastercardcdbc.domain.AccountRequest;
import com.example.mastercardcdbc.entity.Account;
import com.example.mastercardcdbc.entity.User;
import com.example.mastercardcdbc.exception.ResourceNotFoundException;
import com.example.mastercardcdbc.repository.AccountRepository;
import com.example.mastercardcdbc.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    final AccountRepository accountRepository;
    final UserRepository userRepository;

    public AccountService(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    public void createAccount(AccountRequest request) throws ResourceNotFoundException {
         User user =userRepository.findById(request.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
         accountRepository.save(new Account(user,request.getBalance()));
    }
}
