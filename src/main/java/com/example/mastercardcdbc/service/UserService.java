package com.example.mastercardcdbc.service;

import com.example.mastercardcdbc.domain.UserRequest;
import com.example.mastercardcdbc.entity.User;
import com.example.mastercardcdbc.exception.DuplicateException;
import com.example.mastercardcdbc.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    final UserRepository userRepository;

    final PasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    public void createUser(UserRequest userRequest) {
        String encodedPassword = this.bCryptPasswordEncoder.encode(userRequest.getPassword());
        User user = userRepository.findByEmail(userRequest.getEmail());
        if (user != null) {
            throw new DuplicateException("Email Exist !!!! Please try another email ");
        }
        User userEntity = new User(userRequest.getEmail(), encodedPassword);
        userRepository.save(userEntity);
    }
}
