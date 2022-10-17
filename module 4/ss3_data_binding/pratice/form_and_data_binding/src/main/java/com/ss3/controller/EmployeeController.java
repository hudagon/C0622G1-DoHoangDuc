package com.ss3.controller;


import com.ss3.model.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployeeController {

    @GetMapping
    public String showListEmployee() {
        return "/index";
    }

    @GetMapping("/formCreate")
    public String createEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "/formCreate";
    }

    @PostMapping("/addEmployee")
    public String addEmployee (@ModelAttribute Employee employee, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("employeeId", employee.getId());
        redirectAttributes.addFlashAttribute("employeeName", employee.getName());
        redirectAttributes.addFlashAttribute("employeeContactNumber", employee.getContactNumber());

        return "redirect:/index";
    }

}
