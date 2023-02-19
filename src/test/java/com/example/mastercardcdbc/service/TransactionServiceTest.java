package com.example.mastercardcdbc.service;

import com.example.mastercardcdbc.domain.TransactionRequest;
import com.example.mastercardcdbc.entity.Account;
import com.example.mastercardcdbc.entity.User;
import com.example.mastercardcdbc.exception.TransactionException;
import com.example.mastercardcdbc.repository.AccountRepository;
import com.example.mastercardcdbc.repository.TransactionRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceTest {

    @InjectMocks
    TransactionService transactionService;

    @Mock
    TransactionRepository transactionRepository;

    @Mock
    AccountRepository accountRepository;

    @Test
    public void testTransaction() {
        User user = new User();
        user.setId("67889899");
        Account sender_account = new Account(user, 20000.0);
        //when(accountRepository.findByUserId(any())).thenReturn(sender_account);
        User receiver = new User();
        receiver.setId("5666655");
        Account receiver_account = new Account(receiver, 100000.0);
        when(accountRepository.findByUserId(any())).thenReturn(sender_account).thenReturn(receiver_account);
        transactionService.transaction(createTransactionRequest());
        verify(accountRepository, times(2)).save(any());
        verify(transactionRepository, times(1)).save(any());

    }

    @Test(expected = TransactionException.class)
    public void testTransactionException() {
        User user = new User();
        user.setId("67889899");
        Account sender_account = new Account(user, 200.0);
        when(accountRepository.findByUserId(any())).thenReturn(sender_account);
        transactionService.transaction(createTransactionRequest());


    }


    private TransactionRequest createTransactionRequest() {
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setReceiver("5666655");
        transactionRequest.setSender("67889899");
        transactionRequest.setAmount(677.0);
        return transactionRequest;
    }
}
