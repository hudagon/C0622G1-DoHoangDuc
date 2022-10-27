package com.ss10.controller;

import com.ss10.model.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;


@Controller
public class NewController {



    @GetMapping("/home")
    public String get(@SessionAttribute("counter") Counter counter) {
        counter.increment();
        return "/index";
    }
}
