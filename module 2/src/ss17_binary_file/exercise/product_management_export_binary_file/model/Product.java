package ss17_binary_file.exercise.product_management_export_binary_file.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String productCode;
    private String productName;
    private String manufacturerName;
    private double price;
    private String description;

    public Product() {}

    public Product(String productCode, String productName, String manufacturerName, double price, String description) {
        this.productCode = productCode;
        this.productName = productName;
        this.manufacturerName = manufacturerName;
        this.price = price;
        this.description = description;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
