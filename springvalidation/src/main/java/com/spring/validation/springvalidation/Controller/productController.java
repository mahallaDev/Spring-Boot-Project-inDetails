package com.spring.validation.springvalidation.Controller;

import com.spring.validation.springvalidation.pojo.ProductDetails;

import jakarta.validation.Valid;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class productController {

    //Need to send the Header in the request headers
    @PostMapping("/add/product")
    public String addProduct(@Valid @RequestBody ProductDetails productDetails)
    {
        return "Product is created";
    }

    @GetMapping(path ="/get/products")
    public ResponseEntity<ProductDetails> getTheProduct()
    {
        ProductDetails p1=new ProductDetails();
        p1.setProductName("Iphone 15");
        p1.setProductNumber(1234);
        p1.setProductQuantity(15);
        p1.setProductType("mobile");

        HttpHeaders headers=new HttpHeaders();
        headers.add("content","XML");
        return new ResponseEntity<>(p1,headers,HttpStatus.OK);
    }
}
