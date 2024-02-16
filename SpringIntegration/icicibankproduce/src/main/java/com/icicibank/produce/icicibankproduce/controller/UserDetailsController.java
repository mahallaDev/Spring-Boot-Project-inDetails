package com.icicibank.produce.icicibankproduce.controller;

import com.icicibank.produce.icicibankproduce.dto.UserAccountDetails;
import com.icicibank.produce.icicibankproduce.dto.UserDetails;
import com.icicibank.produce.icicibankproduce.services.UserDetailsServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import java.net.URI;

@RestController
public class UserDetailsController {



    @Autowired
    UserDetailsServices userDetailsServices;
    @PostMapping(path = "bank/userdetails")
    public ResponseEntity<String> loginUser(@Valid @RequestBody UserDetails userDetails)
    {
//        @RequestHeader(name = "Icici-bank") String KeyName,
        if(userDetailsServices.authenticateUser(userDetails)) {
            String paymentPage = "Show the payment page";
            return new ResponseEntity<>(paymentPage, HttpStatus.OK);
        }
        else{

            String paymentPage = "Show the invalid user page";
            return new ResponseEntity<>(paymentPage, HttpStatus.UNAUTHORIZED);
        }
    }


    @RequestMapping(path = "/bank/accountDetails",method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserAccountDetails> accountDetailsUser()
    {

      UserAccountDetails  userAccountDetails= userDetailsServices.accountDetailsUser();
        return new ResponseEntity<>(userAccountDetails,HttpStatus.OK);
    }


}
