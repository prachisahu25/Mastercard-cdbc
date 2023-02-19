package com.example.mastercardcdbc.service;

import com.example.mastercardcdbc.domain.TransactionRequest;
import com.example.mastercardcdbc.entity.Account;
import com.example.mastercardcdbc.entity.Transaction;
import com.example.mastercardcdbc.exception.TransactionException;
import com.example.mastercardcdbc.repository.AccountRepository;
import com.example.mastercardcdbc.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountRepository accountRepository;

    @Transactional
    public void transaction(TransactionRequest transactionRequest) {
        Account senderAccount = accountRepository.findByUserId(transactionRequest.getSender());
        if (senderAccount.getBalance().compareTo(transactionRequest.getAmount()) < 0) {
            throw new TransactionException("InSufficient balance");
        }
        Account receiverAccount = accountRepository.findByUserId(transactionRequest.getReceiver());
        Double amount = receiverAccount.getBalance() + transactionRequest.getAmount();
        receiverAccount.setBalance(amount);
        accountRepository.save(receiverAccount);
        senderAccount.setBalance(senderAccount.getBalance() - transactionRequest.getAmount());
        accountRepository.save(senderAccount);
        transactionRepository.save(new Transaction(transactionRequest.getSender(), transactionRequest.getReceiver(),
                transactionRequest.getAmount()));

    }
}