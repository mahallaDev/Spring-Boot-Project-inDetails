package com.flipkart.consume.flipkartconsume.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Valid
public class Flipkartuser {
    @NotBlank
    private String username;
    @NotBlank
    private String password;

}
