package com.spring.validation.springvalidation.Controller;

import com.spring.validation.springvalidation.pojo.ProductDetails;

import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;



@RestController
public class productController {

    //Need to send the Header in the request headers
    @PostMapping(path = "/add/product",consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addProduct( @RequestHeader(name = "key-name",required = false) String keyValue,@Valid @RequestBody ProductDetails productDetails)
    {
    System.out.println(keyValue);
        return "Product is created";
    }

    @GetMapping(path ="/get/products",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDetails>  getTheProduct()
    {
        ProductDetails p1=new ProductDetails();
        p1.setProductName("Iphone 15");
        p1.setProductNumber(1234);
        p1.setProductQuantity(15);
        p1.setProductType("mobile");

        HttpHeaders headers=new HttpHeaders();
        headers.add("key-token","....................axxxxxxxxxxxxxxxxxxxxxxxxxxxxx.sa...");
        headers.add("Auth-Token","sdvcsdhvksdka2342e4idbbcskaj324");
        return new ResponseEntity(p1,headers,HttpStatus.OK);
    }
}
