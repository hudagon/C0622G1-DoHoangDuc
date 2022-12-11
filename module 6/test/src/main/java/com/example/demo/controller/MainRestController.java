package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class MainRestController {

    @GetMapping("/test")
    public String test() {
        return "Ai cũng vô được đây";
    }

    @GetMapping("/test1")
    public String test1() {
        return "ADMIN và USER mới vô được đây";
    }

    @GetMapping("/test2")
    public String test2() {
        return "ADMIN mới vô được đây thui";
    }

}
