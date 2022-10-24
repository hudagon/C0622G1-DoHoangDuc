package com.ss8.controller;

import com.ss8.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {


    @GetMapping("/user")
    public String showCreateList(Model model) {

        model.addAttribute("user", new User());

        return "/index";
    }

    @PostMapping("/validateUser")
    public String validateUser(@Validated @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/index";
        }

        return "/result";
    }
}
