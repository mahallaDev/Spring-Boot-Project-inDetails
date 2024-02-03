package com.spring.validation.springvalidation.pojo;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;




@Valid
public class ProductDetails {




  private int productNumber;

  @NotNull
  @NotBlank(message = "Phone Number should not blank")
  private String productName;

  private int productQuantity;

  @NotBlank(message = "Product Quantity should not be Blank")
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

