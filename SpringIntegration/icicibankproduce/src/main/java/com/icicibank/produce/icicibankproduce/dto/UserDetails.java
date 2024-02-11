package com.icicibank.produce.icicibankproduce.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
@Valid
public class UserDetails {

    @NotNull(message = "username should not be null")
    @NotBlank(message = "Username should not be blank")
    private String username;

    @NotNull(message = "Password should not be null")
    @NotBlank(message = "Password should not be blank")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
