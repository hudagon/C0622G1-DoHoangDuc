package model.service.impl;

import model.customerDto.CustomerDto;
import model.customerDto.CustomerDtoAttachService;
import model.model.human.customer.Customer;
import model.repository.impl.CustomerRepository;
import model.service.ICustomerService;
import validation.CustomerEmailRegex;
import validation.CustomerIdCardRegex;
import validation.CustomerNameRegex;
import validation.CustomerPhoneNumberRegex;

import java.util.List;

public class CustomerService implements ICustomerService {
    CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> getCustomerList() {
        return customerRepository.getCustomerList();
    }

    @Override
    public boolean addCustomer(Customer newCustomer) {

        String nameCustomer = newCustomer.getName();
        String phoneNumberCustomer = newCustomer.getPhoneNumber();
        String idCardCustomer = newCustomer.getIdCard();
        String emailCustomer = newCustomer.getEmail();

        if (CustomerNameRegex.validate(nameCustomer) &&
            CustomerPhoneNumberRegex.validate(phoneNumberCustomer) &&
            CustomerIdCardRegex.validate(idCardCustomer) &&
            CustomerEmailRegex.validate(emailCustomer)) {
            return customerRepository.addCustomer(newCustomer);
        }

        return false;
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

    @Override
    public List<CustomerDto> getListCustomerWhoAreUsingService() {
        return customerRepository.getListCustomerWhoAreUsingService();
    }

    @Override
    public List<CustomerDto> searchCustomerWAUSByName(String name) {
        return customerRepository.searchCustomerWAUSByName(name);
    }

    @Override
    public List<CustomerDtoAttachService> getlistAttachService() {
        return customerRepository.getlistAttachService();
    }
}
