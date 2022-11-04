package com.casestudy.service.customer;

import com.casestudy.model.customer.Customer;
import com.casestudy.model.customer.CustomerType;
import com.casestudy.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService extends IGeneralService<Customer> {
    Page<Customer> findAll(Pageable pageable);

    Page<Customer> search(String searchName, String searchAddress,
                                    String searchCustomerType, Pageable pageable);

}
