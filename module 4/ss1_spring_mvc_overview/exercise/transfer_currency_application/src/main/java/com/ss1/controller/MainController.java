package com.ss1.controller;

import com.ss1.service.impl.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    ConvertService service;

    @GetMapping
    public String toHome() {
        return "/index";
    }

    @PostMapping("/convert")
    public ModelAndView toResult(@RequestParam String amount, @RequestParam String rate) {
        return new ModelAndView("/index",
                "result",service.convert(Double.parseDouble(amount), Double.parseDouble(rate)));
    }
}
