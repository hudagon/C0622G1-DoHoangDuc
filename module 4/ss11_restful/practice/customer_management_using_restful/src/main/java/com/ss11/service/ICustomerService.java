package com.ss11.service;

import com.ss11.dto.CustomerDto;
import com.ss11.model.Customer;

public interface ICustomerService extends IGeneralService<Customer> {
    void save(CustomerDto customer);
}
