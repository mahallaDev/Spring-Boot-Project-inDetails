package com.icicibank.produce.icicibankproduce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MacbookController {

    @GetMapping(path = "mac/details")
    public String getMacbookDetails(){
        return "Macbook M1 : price 58000 and model 2023";
    }
    @GetMapping("iphone/details")
    public String getIphoneDetails(){
        return "Iphone Details: price 54000 and model 15 max pro";
    }
}
