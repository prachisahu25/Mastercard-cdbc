package com.example.mastercardcdbc.repository;


import com.example.mastercardcdbc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String>{

    public User findByEmail(String email);
}
