package model.repository;

import model.customerDto.CustomerDto;
import model.customerDto.CustomerDtoAttachService;
import model.model.human.customer.Customer;
import model.model.human.employee.Employee;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getCustomerList();

    boolean addCustomer(Customer newCustomer);

    List<Customer> searchByName(String name);

    boolean deleteCustomer(String idDelete);

    boolean editCustomer(Customer editCustomer);

    List<CustomerDto> getListCustomerWhoAreUsingService();

    List<CustomerDto> searchCustomerWAUSByName(String name);

    List<CustomerDtoAttachService> getlistAttachService();
}