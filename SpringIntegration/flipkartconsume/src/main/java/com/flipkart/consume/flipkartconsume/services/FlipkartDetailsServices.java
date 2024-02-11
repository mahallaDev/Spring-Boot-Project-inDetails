package com.flipkart.consume.flipkartconsume.services;

import com.flipkart.consume.flipkartconsume.dto.FlipkartUserAccountDetails;
import com.flipkart.consume.flipkartconsume.dto.UserAccountDetails;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FlipkartDetailsServices {
    public UserAccountDetails getAccountDetails() {

        String url="http://localhost:7787/icici/bank/accountDetails";
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders headers=new HttpHeaders();
        headers.add("Content-Type","application/json");
        headers.add("Accept","application/json");
        HttpEntity<UserAccountDetails> req= new HttpEntity<>(null,headers);
        UserAccountDetails userAccountDetails=restTemplate.exchange(url, HttpMethod.GET,req, UserAccountDetails.class).getBody();


        return userAccountDetails;
    }
}
