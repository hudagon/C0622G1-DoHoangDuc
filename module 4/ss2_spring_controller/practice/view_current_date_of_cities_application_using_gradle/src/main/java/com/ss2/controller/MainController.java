package com.ss2.controller;


import com.ss2.service.impl.DateTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    DateTimeService dateTimeService;

    @GetMapping
    public String toIndex() {
        return "/index";
    }

    @GetMapping("/getDate")
    public String getDate(@RequestParam String city, Model model) {
        model.addAttribute("result",dateTimeService.getDateTime(city));
        return "/index";
    }
}
