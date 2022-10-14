package com.ss2.service.impl;

import com.ss2.service.IEmailService;
import com.ss2.validation.EmailRegex;
import org.springframework.stereotype.Service;


@Service
public class EmailService implements IEmailService {
    @Override
    public String checkEmail(String emailCheck) {
        String result = "Email not accepted!";

        if (emailCheck.matches(EmailRegex.EMAIL_REGEX)) {
            result = "Email accepted!";
        }

        return result;
    }
}
