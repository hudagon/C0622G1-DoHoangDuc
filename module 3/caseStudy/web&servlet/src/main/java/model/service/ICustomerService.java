package model.service;

import model.model.human.customer.Customer;
import model.model.human.employee.Employee;

import java.util.List;

public interface ICustomerService {
    List<Customer> getCustomerList();

    boolean addCustomer(Customer newCustomer);

    List<Customer> searchByName(String name);

    boolean deleteCustomer(String idDelete);

    boolean editCustomer(Customer editCustomer);
}
