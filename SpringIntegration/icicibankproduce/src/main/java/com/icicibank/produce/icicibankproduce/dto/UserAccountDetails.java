package com.icicibank.produce.icicibankproduce.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.engine.spi.ManagedEntity;

@Data
@Valid
public class UserAccountDetails {

    @NotBlank(message = "Account number should not be blank")
    @NotNull(message = "Account Number should not be account number")
    private String accountNumber;
    @NotBlank(message = "Account Type should not be account type")
    @NotNull(message = "Account type should not be null")
    private String accountType;
    @NotBlank(message = "Account Balance should not be account balance")
    private String accountBalance;
    @NotBlank(message = "accounter name should not be blank")
    @NotNull(message="Accounter name should not be null")
    private String accounterName;
}
