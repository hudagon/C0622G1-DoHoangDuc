package com.ss3.controller;

import com.ss3.model.EmailSetting;
import com.ss3.serivce.impl.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/email")
@Controller
public class EmailSettingController {

    @Autowired
    EmailService emailService;


    @GetMapping("/")
    public String toIndex(Model model) {
        model.addAttribute("emailSetting", new EmailSetting());
        model.addAttribute("languageList", emailService.getListLanguage());
        model.addAttribute("pageSizeList", emailService.getListPageSize());
        model.addAttribute("signatureList", emailService.getListSignature());
        return "/emailSetting";
    }

    @PostMapping("/saveSetting")
    public String saveSetting(@ModelAttribute("emailSetting") EmailSetting emailSetting,
                              RedirectAttributes redirectAttributes, HttpServletRequest request) {

        String function = request.getParameter("function");

        if (function.equals("add")) {
            emailService.AddNewEmailSetting(emailSetting);
            redirectAttributes.addFlashAttribute("mess","Adding Successfully!");
        } else if (function.equals("update")) {
            emailService.updateEmailSetting(emailSetting);
            redirectAttributes.addFlashAttribute("mess","Update Successfully!");
        } else {
            emailService.deleteEmailSetting(emailSetting);
            redirectAttributes.addFlashAttribute("mess","Delete Successfully!");
        }



        return "redirect:/email/";
    }

    @GetMapping("/showEmailSetting")
    public String showEmailSetting(HttpServletRequest request, Model model) {
        String signature = request.getParameter("signature");

        model.addAttribute("emailSetting",
                emailService.getEmailSettingBasedOnSignature(signature));
        model.addAttribute("languageList", emailService.getListLanguage());
        model.addAttribute("pageSizeList", emailService.getListPageSize());
        model.addAttribute("signatureList", emailService.getListSignature());

        return "/emailSetting";
    }
}