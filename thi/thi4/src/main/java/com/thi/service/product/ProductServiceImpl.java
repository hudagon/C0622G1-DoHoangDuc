package com.thi.service.product;

import com.thi.model.Product;
import com.thi.model.ProductType;
import com.thi.repository.IProductRepository;
import com.thi.service.product_type.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product productType) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }
}
