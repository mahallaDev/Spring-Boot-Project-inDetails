package com.flipkart.consume.flipkartconsume.dto;

import lombok.Data;

import java.util.List;

@Data
public class CountryPositionDetails {

    private boolean error;
    private String msg;
    private List<CountryDetails> data;

}
