package com.example.bankmanagementsystem.DTO;


import jakarta.validation.constraints.AssertFalse;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDTO {

    private Integer accountNumber;

    private double balance;


    @AssertFalse
    private Boolean isActive;

    private Integer customer_id;
}
