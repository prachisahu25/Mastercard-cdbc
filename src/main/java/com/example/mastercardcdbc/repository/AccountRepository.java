package com.example.mastercardcdbc.repository;


import com.example.mastercardcdbc.entity.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,String>{

 Account findAccountByBalance(Double amount);



  @Query("from Account a where a.user.id = :user ")
 Account findByUserId(String user);


}