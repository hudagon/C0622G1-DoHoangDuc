package com.ss4.service;

import com.ss4.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1,"Iphone3",7800,"None","Apple"));
        productList.add(new Product(2,"Nokia3",6300,"None","Nokia"));
        productList.add(new Product(3,"SamsungGalaxyS21",4800,"None","Samsung"));
        productList.add(new Product(4,"HTCOne",3150,"None","HTC"));
        productList.add(new Product(5,"GoogleUltra5",3150,"None","Google"));
        productList.add(new Product(6,"HuaweiG1",3150,"None","Huawei"));
        productList.add(new Product(7,"XiaomiE6",3150,"None","Xiaomi"));
        productList.add(new Product(8,"MotorolaZ100",1350,"None","Motorola"));
        productList.add(new Product(9,"OppoNeo12",1350,"None","Oppo"));
        productList.add(new Product(10,"NokiaBasic",450,"None","Noika"));
    }


    @Override
    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public boolean addProduct(Product newProduct) {

        productList.add(newProduct);

        return true;
    }

    @Override
    public Product findProductById(int idFind) {
        for (Product x : productList) {
            if (x.getId() == idFind) {
                return x;
            }
        }

        return null;
    }

    @Override
    public boolean updateProduct(Product productUpdate) {

        for (Product x : productList) {
            if (x.getId() == productUpdate.getId()) {
                x.setName(productUpdate.getName());
                x.setPrice(productUpdate.getPrice());
                x.setDescription(productUpdate.getDescription());
                x.setManufacturer(productUpdate.getManufacturer());
            }
        }

        return false;
    }

    @Override
    public boolean deleteProduct(int idDelete) {

        productList.removeIf(x -> x.getId() == idDelete);

        return true;
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> productsFound = new ArrayList<Product>();

        for (Product x : productList) {
            if (x.getName().contains(name)) {
                productsFound.add(x);
            }
        }

        return productsFound;
    }
}
