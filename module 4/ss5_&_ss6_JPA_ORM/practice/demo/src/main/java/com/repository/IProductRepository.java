package com.repository;

import com.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
}
