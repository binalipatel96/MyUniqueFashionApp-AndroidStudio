package com.example.myuniquefashionapp;

public class ProductModel {
    int productImages;
    String productName, productDesc, productPrice;

    public ProductModel(int productImages, String productName, String productDesc, String productPrice) {
        this.productImages = productImages;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
    }

    public int getProductImages() {
        return productImages;
    }

    public void setProductImages(int productImages) {
        this.productImages = productImages;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
