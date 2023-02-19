package com.example.mastercardcdbc.controller;

import com.example.mastercardcdbc.controller.TransactionController;
import com.example.mastercardcdbc.domain.AccountRequest;
import com.example.mastercardcdbc.domain.TransactionRequest;
import com.example.mastercardcdbc.domain.UserRequest;
import com.example.mastercardcdbc.service.AccountService;
import com.example.mastercardcdbc.service.TransactionService;
import com.example.mastercardcdbc.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@ExtendWith(MockitoExtension.class)
class TransactionControllerTest {

    @InjectMocks
    private TransactionController controller;

    @Mock
    UserService userService;

    @Mock
    AccountService accountService;

    @Mock
    TransactionService transactionService;


    @Test
    void testCreateUserAPI() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ResponseEntity<String> responseEntity = controller.saveUser(createUser());
        org.junit.Assert.assertEquals( "User Created Successfully", responseEntity.getBody());
        org.junit.Assert.assertEquals(responseEntity.getStatusCode().toString(), HttpStatus.CREATED.toString());

    }

    @Test
    void testCreateAccountAPI() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ResponseEntity<String> responseEntity = controller.saveAccount(createAccountRequest());
        org.junit.Assert.assertEquals( "Account Created Successfully", responseEntity.getBody());
        org.junit.Assert.assertEquals(responseEntity.getStatusCode().toString(), HttpStatus.CREATED.toString());

    }

    @Test
    void testTransaction() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ResponseEntity<String> responseEntity = controller.saveTransaction(createTransactionRequest());
        org.junit.Assert.assertEquals("Transaction Completed Successfully", responseEntity.getBody());
        org.junit.Assert.assertEquals(responseEntity.getStatusCode().toString(), HttpStatus.OK.toString());

    }


    private TransactionRequest createTransactionRequest() {

        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setReceiver("5666655");
        transactionRequest.setSender("67889899");
        transactionRequest.setAmount(677.0);
        return transactionRequest;
    }

    private AccountRequest createAccountRequest() {
        AccountRequest accountRequest = new AccountRequest();
        accountRequest.setUserId("R66655-8888");
        accountRequest.setBalance(20000.0);
        return accountRequest;
    }


    private UserRequest createUser() {
        UserRequest userRequest = new UserRequest();
        userRequest.setEmail("admin@gmail.com");
        userRequest.setPassword("12345");
        return userRequest;
    }
}
