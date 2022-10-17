package com.ss3.controller;

import com.ss3.model.model.Login;
import com.ss3.model.model.User;
import com.ss3.model.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String toIndex(Model model) {
        model.addAttribute("login", new Login());
        return "/index";
    }

    @GetMapping("/showPage")
    public String toShowPage() {
        return "/showPage";
    }

    @PostMapping("/login")
    public String checkLogin(@ModelAttribute Login login, RedirectAttributes redirectAttributes) {
        User user = userService.checkLogin(login);

        if (user == null) {
            redirectAttributes.addFlashAttribute("mess","Login failed!");
        } else {
            redirectAttributes.addFlashAttribute("mess", "Login successful!");
            redirectAttributes.addFlashAttribute("user", user);

        }

        return "redirect:/showPage";
    }

}
