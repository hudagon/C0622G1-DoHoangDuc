package com.project.be.dto.product;

public class ProductSearchDto {

    private String productName;
    private String categoryId;
    private String brandId;
    private String priceRange;

    public ProductSearchDto() {
    }

    public ProductSearchDto(String productName, String categoryId,
                            String brandId, String priceRange) {
        this.productName = productName;
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.priceRange = priceRange;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }
}
