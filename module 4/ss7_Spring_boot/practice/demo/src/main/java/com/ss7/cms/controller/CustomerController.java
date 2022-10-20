package com.ss7.cms.controller;


import com.ss7.cms.model.Customer;
import com.ss7.cms.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("customerList", customerService.findAll());
        return "/customer/list";
    }

    @GetMapping("/create-customer")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "/customer/create";
    }

    @PostMapping("/create-customer")
    public String saveCustomer(@ModelAttribute Customer customer, Model model) {
        customerService.save(customer);
        model.addAttribute("customer", new Customer());
        model.addAttribute("mess", "New customer created successfully!");
        return "/customer/create";
    }

    @GetMapping("/edit-customer/{idEdit}")
    public String showEditForm(@PathVariable Long idEdit, Model model) {
        Optional<Customer> customerEdit = customerService.findById(idEdit);
        if (customerEdit.isPresent()) {
            model.addAttribute("customerEdit", customerEdit.get());
            return "/customer/edit";
        } else {
            return "/error.404";
        }
    }

    @PostMapping("/edit-customer")
    public String editCustomer(@ModelAttribute Customer customerEdit, Model model) {
        customerService.save(customerEdit);
        model.addAttribute("customerEdit", customerEdit);
        model.addAttribute("mess", "Customer updated successfully!");
        return "/customer/edit";
    }

    @GetMapping("/delete-customer/{idDelete}")
    public String showDeletePage(@PathVariable Long idDelete, Model model) {
        Optional<Customer> customerDelete = customerService.findById(idDelete);
        if (customerDelete.isPresent()) {
            model.addAttribute("customerDelete", customerDelete.get());
            return "/customer/delete";
        } else {
            return "/error.404";
        }
    }

    @PostMapping("/delete-customer")
    public String deleteCustomer(@ModelAttribute Customer customerDelete, RedirectAttributes redirectAttributes) {
        customerService.remove(customerDelete.getId());
        redirectAttributes.addFlashAttribute("mess", "Delete customer successfully!");
        return "redirect:/customer/list";
    }

}
