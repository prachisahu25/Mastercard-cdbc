package com.example.mastercardcdbc.repository;


import com.example.mastercardcdbc.entity.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,String>{
}
