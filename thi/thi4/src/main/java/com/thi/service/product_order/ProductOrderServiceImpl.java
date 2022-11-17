package com.thi.service.product_order;

import com.thi.model.ProductOrder;
import com.thi.repository.IProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductOrderServiceImpl implements IProductOrderService {

    @Autowired
    private IProductOrderRepository productOrderRepository;


    @Override
    public Iterable<ProductOrder> findAll() {
        return null;
    }

    @Override
    public Optional<ProductOrder> findById(Integer id) {
        return productOrderRepository.findById(id);
    }

    @Override
    public ProductOrder save(ProductOrder productOrder) {
        return productOrderRepository.save(productOrder);
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Page<ProductOrder> findAll(Pageable pageable) {
        return productOrderRepository.findAll(pageable);
    }

    @Override
    public Page<ProductOrder> findAll(Pageable pageable, String startDate, String endDate) {
        return productOrderRepository.findAll(pageable, startDate, endDate);
    }
}
