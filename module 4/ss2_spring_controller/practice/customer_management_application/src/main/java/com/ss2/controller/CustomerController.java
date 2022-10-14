package com.ss2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

    @GetMapping
    public String toIndex() {
        return "/index";
    }
}
