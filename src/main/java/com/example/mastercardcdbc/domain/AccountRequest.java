package com.example.mastercardcdbc.domain;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequest {

    @NotNull(message = "User cannot be null")
    @NotEmpty(message = "User cannot be empty")
    private String userId;

    @NotNull(message = "Balance cannot be null")
    private Double balance;
}
