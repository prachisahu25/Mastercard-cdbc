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
@Table(name = "user1")
@Setter
@Getter
public class User {

    @Id
    private String id;

    @NotNull
    @NotEmpty(message = "Please provide a Email")
    private String email;
    @NotNull
    @NotEmpty(message = "Please provide a password")
    private String password;

    public User() {
    }

    public User(String email, String password) {

        this.email = email;
        this.password = password;
    }


    @PrePersist
    private void ensureID() {
        this.setId(UUID.randomUUID().toString());
    }


}
