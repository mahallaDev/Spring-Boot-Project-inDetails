package com.flipkart.consume.flipkartconsume.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CountryDetails {

    private String name;
    private String iso2;
    @JsonProperty("long")
    private int longitude;
    private int lat;
}
