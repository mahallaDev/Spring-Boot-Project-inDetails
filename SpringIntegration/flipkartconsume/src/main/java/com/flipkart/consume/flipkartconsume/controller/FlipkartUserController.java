package com.flipkart.consume.flipkartconsume.controller;

import com.flipkart.consume.flipkartconsume.dto.FlipkartUserAccountDetails;
import com.flipkart.consume.flipkartconsume.dto.Flipkartuser;
import com.flipkart.consume.flipkartconsume.dto.UserAccountDetails;
import com.flipkart.consume.flipkartconsume.services.FlipkartDetailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class FlipkartUserController {

    @Autowired
    FlipkartDetailsServices flipkartDetailsServices;
    @PostMapping(path="/checkout/makepayment",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> loginBankDetails(@RequestBody Flipkartuser flipkartuser)
    {
//        @RequestHeader(name = "Icici-bank") String KeyName,
        String bankUrl="http://localhost:7787/icici/bank/userdetails";
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders headers=new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept","application/json");
        ResponseEntity<String> res =restTemplate.postForEntity(bankUrl,flipkartuser, String.class);
        String response=res.getBody();

        return new ResponseEntity<>(response,headers,HttpStatus.OK);

    }


    @RequestMapping(path = "/checkout/bankDetails",method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserAccountDetails> accountDetails()
    {

       UserAccountDetails response= flipkartDetailsServices.getAccountDetails();
        HttpHeaders headers=new HttpHeaders();
        headers.add("Content-Type","application/xml");
        headers.add("Accept","application/json");
        return new ResponseEntity<>(response, headers,HttpStatus.OK);
    }

}
