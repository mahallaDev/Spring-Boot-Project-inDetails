package com.spring.validation.springvalidation.pojo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ProductDetails {

  private int productNumber;
  private String productName;
  private int productQuantity;
  private String productType;

  public int getProductNumber() {
    return productNumber;
  }

  public void setProductNumber(int productNumber) {
    this.productNumber = productNumber;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public int getProductQuantity() {
    return productQuantity;
  }

  public void setProductQuantity(int productQuantity) {
    this.productQuantity = productQuantity;
  }

  public String getProductType() {
    return productType;
  }

  public void setProductType(String productType) {
    this.productType = productType;
  }
}

