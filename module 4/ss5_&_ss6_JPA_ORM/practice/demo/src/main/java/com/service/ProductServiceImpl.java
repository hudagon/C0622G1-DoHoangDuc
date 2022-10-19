package com.service;

import com.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.IProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

}
