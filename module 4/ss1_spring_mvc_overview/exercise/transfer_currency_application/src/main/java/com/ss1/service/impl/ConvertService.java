package com.ss1.service.impl;


import com.ss1.service.IConvertService;
import org.springframework.stereotype.Service;

@Service
public class ConvertService implements IConvertService {


    public double convert(double amount, double rate) {
        return amount * rate;
    }
}
