package com.ss4.controller;

import com.ss4.model.model.Product;
import com.ss4.model.service.ProductService;
import com.ss4.model.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class ProductController {

    private final IProductService productService = new ProductService();

    @GetMapping("")
    public String toIndex(Model model) {
        List<Product> productList = productService.getProductList();
        model.addAttribute("productList", productList);
        return "/index";
    }
}
