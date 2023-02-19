package com.example.mastercardcdbc.service;

import com.example.mastercardcdbc.domain.AccountRequest;
import com.example.mastercardcdbc.entity.User;
import com.example.mastercardcdbc.exception.ResourceNotFoundException;
import com.example.mastercardcdbc.repository.AccountRepository;
import com.example.mastercardcdbc.repository.UserRepository;
import com.example.mastercardcdbc.service.AccountService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

    @InjectMocks
    AccountService accountService;

    @Mock
    AccountRepository accountRepository;

    @Mock
    UserRepository userRepository;


    @Test
    public void testSaveAccount() throws Exception {
        Optional<User> user = Optional.of(new User());
        when(userRepository.findById(anyString())).thenReturn(user);
        accountService.createAccount(createAccountRequest());
        verify(accountRepository, times(1)).save(any());
    }


    @Test(expected = ResourceNotFoundException.class)
    public void testUserException() throws Exception {
        when(userRepository.findById(anyString())).thenThrow(new ResourceNotFoundException("User Not Found"));
        accountService.createAccount(createAccountRequest());

    }

    private AccountRequest createAccountRequest() {
        AccountRequest accountRequest = new AccountRequest();
        accountRequest.setUserId("R66655-8888");
        accountRequest.setBalance(20000.0);
        return accountRequest;
    }


}
