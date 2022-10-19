package com.ss5.service;

import com.ss5.model.Product;
import com.ss5.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getProductList() {
        return productRepository.getProductList();
    }

    @Override
    public boolean addProduct(Product newProduct) {
        return productRepository.addProduct(newProduct);
    }

    @Override
    public Product findProductById(int idFind) {
        return findProductById(idFind);
    }

    @Override
    public boolean updateProduct(Product productUpdate) {
        return updateProduct(productUpdate);
    }

    @Override
    public boolean deleteProduct(int idDelete) {
        return deleteProduct(idDelete);
    }

    @Override
    public List<Product> searchByName(String name) {
        return productRepository.searchByName(name);
    }
}
