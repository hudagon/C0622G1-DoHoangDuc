package com.thi.dto;


import com.thi.model.ProductType;

public class ProductOrderDto {

    private Integer id;
    private String productName;
    private String price;
    private String productType;
    private String buyDate;
    private Integer amount;
    private Double totalMoney;


    public ProductOrderDto() {
    }

    public ProductOrderDto(Integer id, String productName,
                           String price, String productType, String buyDate,
                           Integer amount, Double totalMoney) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.productType = productType;
        this.buyDate = buyDate;
        this.amount = amount;
        this.totalMoney = totalMoney;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }
}
