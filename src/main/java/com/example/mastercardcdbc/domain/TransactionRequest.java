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
public class TransactionRequest {

    @NotNull(message = "Sender cannot be null")
    @NotEmpty(message = "Sender cannot be empty")
    private String sender;
    @NotNull(message = "Receiver cannot be null")
    @NotEmpty(message = "Receiver cannot be empty")
    private String receiver;
    @NotNull(message = "Amount cannot be null")
    private Double amount;
}
