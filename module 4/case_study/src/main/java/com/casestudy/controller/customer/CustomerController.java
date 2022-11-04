package com.casestudy.controller.customer;

import com.casestudy.dto.CustomerDto;
import com.casestudy.model.customer.Customer;
import com.casestudy.model.customer.CustomerType;
import com.casestudy.service.customer.ICustomerService;
import com.casestudy.service.customer_type.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("/list")
    public String showListCustomerNormal(Model model, @PageableDefault(value = 5) Pageable pageable) {

        Page<Customer> customerList = customerService.findAll(pageable);
        List<CustomerType> customerTypeList = (List<CustomerType>) customerTypeService.findAll();
        List<CustomerDto> customerDtoList = new ArrayList<>();

        for (Customer x : customerList) {
            CustomerDto customerDto = new CustomerDto();
            BeanUtils.copyProperties(x, customerDto);

            if (x.getGender() == 1) {
                customerDto.setGender("Nam");
            } else {
                customerDto.setGender("Nữ");
            }

            customerDto.setCustomerType(x.getCustomerType().getName());

            customerDtoList.add(customerDto);
        }

        Page<CustomerDto> customerDtoListPage = new PageImpl<>(customerDtoList, pageable, customerList.getTotalElements());

        model.addAttribute("customerList", customerDtoListPage);
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("flag", "list");

        return "/customer/list";
    }

    @GetMapping("/search")
    public String searchCustomer(@RequestParam String searchName,
                                 @RequestParam String searchAddress,
                                 @RequestParam String searchCustomerType,
                                 @PageableDefault(value = 5) Pageable pageable,
                                 Model model) {

        Page<Customer> customersFound = customerService.search(searchName, searchAddress,
                searchCustomerType, pageable);
        List<CustomerDto> customerDtosFound = new ArrayList<>();
        List<CustomerType> customerTypeList = (List<CustomerType>) customerTypeService.findAll();


        for (Customer x : customersFound) {
            CustomerDto customerDto = new CustomerDto();
            BeanUtils.copyProperties(x, customerDto);

            if (x.getGender() == 1) {
                customerDto.setGender("Nam");
            } else {
                customerDto.setGender("Nữ");
            }

            customerDto.setCustomerType(x.getCustomerType().getName());
            customerDtosFound.add(customerDto);
        }

        Page<CustomerDto> customerDtosFoundPage = new PageImpl<>(customerDtosFound,
                pageable, customersFound.getTotalElements());

        model.addAttribute("customerList", customerDtosFoundPage);
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("flag", "search");
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchAddress", searchAddress);
        model.addAttribute("searchCustomerType", searchCustomerType);


        return "/customer/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {

        List<CustomerType> customerTypeList = (List<CustomerType>) customerTypeService.findAll();

        model.addAttribute("newCustomer", new CustomerDto());
        model.addAttribute("customerTypeList", customerTypeList);

        return "/customer/create";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute CustomerDto newCustomer,
                                 RedirectAttributes redirectAttributes) {

        Customer customerATBC = new Customer();
        Optional<CustomerType> customerType = customerTypeService.findById(Integer.valueOf(newCustomer.getCustomerType()));

        BeanUtils.copyProperties(newCustomer, customerATBC);
        customerATBC.setStatus(1);
        customerATBC.setGender(Integer.valueOf(newCustomer.getGender()));

        if (customerType.isPresent()) {
            customerATBC.setCustomerType(customerType.get());
        }

        customerService.save(customerATBC);

        redirectAttributes.addFlashAttribute("mess", "New customer added successfully!");

        return "redirect:/customer/list";
    }

}
