package com.casestudy.service.customer_type;

import com.casestudy.model.customer.CustomerType;
import com.casestudy.repository.ICustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerTypeServiceImpl implements ICustomerTypeService{

    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public Iterable<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public Optional<CustomerType> findById(Integer id) {
        return customerTypeRepository.findById(id);
    }

    @Override
    public CustomerType save(CustomerType customerType) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }
}
