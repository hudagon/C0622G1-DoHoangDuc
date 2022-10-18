package com.ss4.controller;

import com.ss4.model.model.Product;
import com.ss4.model.service.IProductService;
import com.ss4.model.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
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

    @GetMapping("/showAddNewForm")
    public String showAddNewForm(Model model) {
        model.addAttribute("newProduct", new Product());
        return "/create";
    }

    @PostMapping("/addNewProduct")
    public String addNewProduct(@ModelAttribute Product newProduct, RedirectAttributes redirectAttributes) {
        String mess = "Add new product failed!";

        if (productService.addProduct(newProduct)) {
            mess = "Adding new product Succesfully!";
        }

        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/";
    }

    @GetMapping("/showUpdateForm")
    public String showUpdateForm(Model model, @RequestParam int idFind) {
        Product productUpdate = productService.findProductById(idFind);

        model.addAttribute("productUpdate", productUpdate);

        return "/edit";
    }

    @PostMapping("/editProduct")
    public String editProduct(@ModelAttribute Product productUpdate, RedirectAttributes redirectAttributes) {
        String mess = null;

        if (productService.updateProduct(productUpdate)) {
            mess = "Product updated successfully!";
        }

        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/";
    }

    @PostMapping("/deleteProduct")
    public String deleteProduct(@RequestParam int idDelete, RedirectAttributes redirectAttributes) {

        productService.deleteProduct(idDelete);

        redirectAttributes.addFlashAttribute("mess", "Delete product successfully!");
        return "redirect:/";
    }

    @GetMapping("/viewProduct")
    public String viewProduct(@RequestParam int idView, Model model) {
        Product productView = productService.findProductById(idView);

        List<Product> productToView = new ArrayList<>();

        productToView.add(productView);

        model.addAttribute("productList", productToView);

        return "/index";
    }

    @GetMapping("/searchByName")
    public String searchByName(@RequestParam String productNameSearch, Model model) {
        String mess = "Found!";

        List<Product> productFound = productService.searchByName(productNameSearch);

        if (productFound.size() == 0) {
            mess = "No products found!";
        }

        model.addAttribute("productList", productFound);
        model.addAttribute("mess", mess);

        return "/index";
    }


}
