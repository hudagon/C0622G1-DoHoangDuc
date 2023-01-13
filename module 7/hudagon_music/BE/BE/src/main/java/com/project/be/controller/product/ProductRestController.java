package com.project.be.controller.product;

import com.project.be.dto.product.ProductDto;
import com.project.be.dto.product.ProductSearchDto;
import com.project.be.model.product.Product;
import com.project.be.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/product")
public class ProductRestController {

    @Autowired
    private IProductService productService;

    @GetMapping("/test")
    public String test() {
        return "ok";
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<Page<Product>> getProductPage(
            @RequestBody ProductSearchDto productSearchDto,
            @PageableDefault(value = 2) Pageable pageable
            ) {

//        Page<Product> productPage = productService.searchAllProduct(productSearchDto, pageable);

        Page<Product> productPage = productService.findAllOk1(productSearchDto, pageable);

        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }

}
