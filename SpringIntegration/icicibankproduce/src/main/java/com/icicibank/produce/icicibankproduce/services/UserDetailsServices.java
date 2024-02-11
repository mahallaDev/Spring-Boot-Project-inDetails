package com.icicibank.produce.icicibankproduce.services;

import com.icicibank.produce.icicibankproduce.dto.UserAccountDetails;
import com.icicibank.produce.icicibankproduce.dto.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

@Service
public class UserDetailsServices {


    public UserAccountDetails accountDetailsUser() {

        UserAccountDetails userAccountDetails = new UserAccountDetails();
        userAccountDetails.setAccounterName("Abhishek Mahalle");
        userAccountDetails.setAccountType("saving");
        userAccountDetails.setAccountNumber("31325623");
        userAccountDetails.setAccountBalance("8900");

        return userAccountDetails;
    }


    public boolean authenticateUser(UserDetails userDetails) {

        if (userDetails.getUsername().contains("Abhishek") && userDetails.getPassword().contains("Abhi123")){
            return true;
        }
        else {
            return false;
        }
    }
}
