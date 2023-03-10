package com.example.mastercardcdbc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "transaction")
@Getter
@Setter
public class Transaction{

    @Id
    private String id;

    @NotNull
    @NotEmpty(message = "Please provide a Sender")
    private String sender;

    private String receiver;
    private Double amount;


    public Transaction(String sender, String receiver, Double amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    @PrePersist
    private void ensureID() {
        this.setId(UUID.randomUUID().toString());
    }
}
