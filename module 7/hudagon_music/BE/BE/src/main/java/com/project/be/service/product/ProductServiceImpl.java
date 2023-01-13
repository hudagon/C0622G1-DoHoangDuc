package com.project.be.service.product;

import com.project.be.dto.product.ProductSearchDto;
import com.project.be.model.product.Product;
import com.project.be.repository.product.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Page<Product> searchAllProduct(ProductSearchDto productSearchDto, Pageable pageable) {
        return productRepository.searchAllProduct(
                Integer.parseInt(productSearchDto.getBrandId()),
                Integer.parseInt(productSearchDto.getCategoryId()),
                pageable);
    }

    @Override
    public Page<Product> findAllOk1(ProductSearchDto productSearchDto, Pageable pageable) {
        return productRepository.findAllOk1(
                productSearchDto,
                pageable);
    }
}
