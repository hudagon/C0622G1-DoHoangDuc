package com.ss11.controller;

import com.ss11.dto.CustomerDto;
import com.ss11.model.Customer;
import com.ss11.model.CustomerType;
import com.ss11.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public ResponseEntity<Iterable<Customer>> findAllCustomer() {
        List<Customer> customers = (List<Customer>) customerService.findAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<> (HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById (@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (!customer.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customer.get(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> addCustomer(@RequestBody CustomerDto customerDto) {
        customerService.save(customerDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Optional<Customer> customerEdited = customerService.findById(id);

        if (!customerEdited.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        customer.setId(customerEdited.get().getId());

        return new ResponseEntity<>(customerService.save(customer), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer1(@PathVariable Long id, @RequestBody Customer customer) {
        Optional<Customer> customerEdited = customerService.findById(id);

        if (!customerEdited.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        customer.setId(customerEdited.get().getId());

        return new ResponseEntity<>(customerService.save(customer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer (@PathVariable Long id) {
        Optional<Customer> customerDeleted = customerService.findById(id);

        if (!customerDeleted.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        customerService.remove(id);
        return new ResponseEntity<>(customerDeleted.get(), HttpStatus.OK);
    }

}
