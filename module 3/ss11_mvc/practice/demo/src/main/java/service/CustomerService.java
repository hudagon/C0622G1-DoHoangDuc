package service;

import model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {
    private static Map<Integer, Customer> customer;

    static {
        customer = new HashMap<>();
        customer.put(1, new Customer(1, "John", "john@codegym.vn", "Hanoi"));
        customer.put(2, new Customer(2, "Bill", "bill@codegym.vn", "Danang"));
        customer.put(3, new Customer(3, "Alex", "alex@codegym.vn", "Saigon"));
        customer.put(4, new Customer(4, "Adam", "adam@codegym.vn", "Beijin"));
        customer.put(5, new Customer(5, "Sophia", "sophia@codegym.vn", "Miami"));
        customer.put(6, new Customer(6, "Rose", "rose@codegym.vn", "Newyork"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customer.values());
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Customer customer) {

    }

    @Override
    public void remove(int id) {

    }
}
