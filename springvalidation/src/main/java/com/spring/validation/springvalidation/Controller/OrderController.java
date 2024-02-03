package com.spring.validation.springvalidation.Controller;

import com.spring.validation.springvalidation.pojo.OrderDetails;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @PostMapping(path = "/add/order", consumes ={ MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public String addOrder(@Valid @RequestBody OrderDetails orderDetails) {
        return "Adding the order";
    }

    @GetMapping(path = "/get/retrieve",produces ={ MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public OrderDetails getOrderDetails()
    {
        OrderDetails orderDetails=new OrderDetails();
        orderDetails.setOrderID("ID1001");
        orderDetails.setComments("Buying Phone");
        orderDetails.setAmount(1000.0F);
        orderDetails.setSucess(true);
            return orderDetails;
    }
}
