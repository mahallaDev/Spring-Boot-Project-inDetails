package com.flipkart.consume.flipkartconsume.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("UserAccountDetails")
public class FlipkartUserAccountDetails {

             public String accountNumber;
             public String accountType;
             public String accountBalance;
             public String accounterName;
}
