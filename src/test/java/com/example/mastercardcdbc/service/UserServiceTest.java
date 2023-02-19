package com.example.mastercardcdbc.service;

import com.example.mastercardcdbc.domain.UserRequest;
import com.example.mastercardcdbc.entity.User;
import com.example.mastercardcdbc.exception.DuplicateException;
import com.example.mastercardcdbc.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Mock
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void testUserSave() {
        when(userRepository.findByEmail(anyString())).thenReturn(null);
        userService.createUser(createUser());
        verify(userRepository, times(1)).save(any());
    }

    @Test(expected = DuplicateException.class)
    public void testDuplicateUser() {
        when(userRepository.findByEmail(anyString())).thenReturn(new User());
        userService.createUser(createUser());
    }

    private UserRequest createUser() {
        UserRequest userRequest = new UserRequest();
        userRequest.setEmail("admin@gmail.com");
        userRequest.setPassword("12345");
        return userRequest;
    }


}
