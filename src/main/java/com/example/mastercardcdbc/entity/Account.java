package com.example.mastercardcdbc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Entity
@Getter
@Setter
@Table(name = "account")
public class Account {

    @Id
    private String id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    private Double balance;

    public Account() {
    }

    public Account(User user, Double balance) {
        this.user = user;
        this.balance = balance;
    }


    @PrePersist
    private void ensureID() {
        this.setId(UUID.randomUUID().toString());
    }


}
