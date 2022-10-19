package com.ss5.repository;

import com.ss5.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getProductList();

    boolean addProduct(Product newProduct);

    Product findProductById(int id);

    boolean updateProduct(Product productUpdate);

    boolean deleteProduct(int idDelete);

    List<Product> searchByName(String productNameSearch);
}
