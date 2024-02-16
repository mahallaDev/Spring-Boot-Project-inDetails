package com.flipkart.consume.flipkartconsume.controller;

import com.flipkart.consume.flipkartconsume.dto.CountryPositionDetails;
import com.flipkart.consume.flipkartconsume.dto.FlipkartUserAccountDetails;
import com.flipkart.consume.flipkartconsume.dto.Flipkartuser;
import com.flipkart.consume.flipkartconsume.dto.UserAccountDetails;
import com.flipkart.consume.flipkartconsume.services.FlipkartDetailsServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class FlipkartUserController {

    @Autowired
    FlipkartDetailsServices flipkartDetailsServices;
    @PostMapping(path="/checkout/makepayment",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> loginBankDetails(@Valid @RequestBody Flipkartuser flipkartuser)
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

    @GetMapping(path="/country/position")
        public CountryPositionDetails countryDetails()
        {

            String url="https://countriesnow.space/api/v0.1/countries/positions";
            RestTemplate restTemplate=new RestTemplate();
            CountryPositionDetails response=restTemplate.getForEntity(url,CountryPositionDetails.class).getBody();
            return response;
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
