package com.ss1.controller;


import com.ss1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ModelAndView showList() {
        return new ModelAndView("/customer",
                "customerList", customerService.findAll());
    }


    @GetMapping("/detail")
    public ModelAndView showInfo(@RequestParam Long id) {
        return new ModelAndView("/detail","customer",customerService.findOne(id));
    }
}
