package com.project.be.service.product;

import com.project.be.payload.request.ProductSearchInfo;
import com.project.be.model.product.Product;
import com.project.be.repository.product.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Object save(Object o) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Page<Product> searchProduct(ProductSearchInfo productSearchInfo, Pageable pageable) {
        return productRepository.searchProduct(
                productSearchInfo.getBrandId(),
                productSearchInfo.getCategoryId(),
                productSearchInfo.getProductName(),
                pageable);
    }
}
