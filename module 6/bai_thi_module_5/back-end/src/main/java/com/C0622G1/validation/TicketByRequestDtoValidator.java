package com.C0622G1.validation;

import com.C0622G1.dto.TicketDto;
import com.C0622G1.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class TicketByRequestDtoValidator implements Validator {

    @Autowired
    private ITicketService ticketService;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        TicketDto ticketDto = (TicketDto) target;

        if (ticketDto.getStartPoint().equals("Da Nang")) {
            errors.rejectValue("startPoint", "startPoint.duplicate", "Start point must be unique!");
        }

    }
}
