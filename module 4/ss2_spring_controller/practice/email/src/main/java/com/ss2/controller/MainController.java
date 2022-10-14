package com.ss2.controller;


import com.ss2.service.impl.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    EmailService emailService;

    @GetMapping
    public String toIndex() {
        return "/index";
    }

    @GetMapping("/checkEmail")
    public ModelAndView checkEmail(@RequestParam String emailCheck) {
        return new ModelAndView("/index", "result",emailService.checkEmail(emailCheck));
    }
}
