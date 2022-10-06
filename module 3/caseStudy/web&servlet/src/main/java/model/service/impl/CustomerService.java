package model.service.impl;

import model.model.human.customer.Customer;
import model.repository.impl.CustomerRepository;
import model.service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    CustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> getCustomerList() {
        return customerRepository.getCustomerList();
    }

    @Override
    public boolean addCustomer(Customer newCustomer) {
        return customerRepository.addCustomer(newCustomer);
    }

    @Override
    public List<Customer> searchByName(String name) {
        return customerRepository.searchByName(name);
    }

    @Override
    public boolean deleteCustomer(String idDelete) {
        return customerRepository.deleteCustomer(idDelete);
    }

    @Override
    public boolean editCustomer(Customer editCustomer) {
        return customerRepository.editCustomer(editCustomer);
    }
}
