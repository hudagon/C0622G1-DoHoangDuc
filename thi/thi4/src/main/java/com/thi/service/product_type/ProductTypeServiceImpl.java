package com.thi.service.product_type;

import com.thi.model.ProductType;
import com.thi.repository.IProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductTypeServiceImpl implements IProductTypeService {

    @Autowired
    private IProductTypeRepository productTypeRepository;


    @Override
    public Iterable<ProductType> findAll() {
        return productTypeRepository.findAll();
    }

    @Override
    public Optional<ProductType> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public ProductType save(ProductType productType) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }
}
