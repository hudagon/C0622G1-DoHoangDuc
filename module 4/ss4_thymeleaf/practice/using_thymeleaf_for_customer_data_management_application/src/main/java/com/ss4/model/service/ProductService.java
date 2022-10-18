package com.ss4.model.service;

import com.ss4.model.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
