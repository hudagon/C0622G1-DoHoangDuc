package com.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.service.IProductService;



@Controller
@RequestMapping({"/product","/home"})
public class ProductController {


    @Autowired
    private IProductService productService;


    @RequestMapping(value = "/list",
                    method = RequestMethod.GET)
    public ModelAndView showProductList(){
            return new ModelAndView("product",
                    "productList", productService.findAll());
    }

}
