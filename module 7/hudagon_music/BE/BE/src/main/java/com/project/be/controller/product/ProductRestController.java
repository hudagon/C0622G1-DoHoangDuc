package com.project.be.controller.product;

import com.project.be.dto.product.ProductDto;
import com.project.be.dto.product.ProductHomeShow;
import com.project.be.model.product.ImgUrlProduct;
import com.project.be.payload.request.ProductSearchInfo;
import com.project.be.model.product.Product;
import com.project.be.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @PostMapping("/searchProduct")
    public ResponseEntity<Page<ProductHomeShow>> getProductPage(
            @RequestBody ProductSearchInfo productSearchInfo,
            @PageableDefault(value = 6) Pageable pageable
            ) {

        Page<Product> productPage = productService.searchProduct(productSearchInfo, pageable);

        List<ProductHomeShow> productHomeShowList = new ArrayList<>();

        for (Product x : productPage) {
            ProductHomeShow productHomeShow = new ProductHomeShow();

            productHomeShow.setId(x.getId());
            productHomeShow.setName(x.getName());
            productHomeShow.setBrand(x.getBrand().getName());
            productHomeShow.setCategory(x.getCategory().getName());
            productHomeShow.setPrice(x.getPrice());

            for (ImgUrlProduct y : x.getImgUrlProductSet()) {
                productHomeShow.setHomeImgCart(y.getUrl());
                break;
            }

            productHomeShowList.add(productHomeShow);
        }

        Page<ProductHomeShow> productHomeShowPage = new PageImpl<>(productHomeShowList,
                pageable, productPage.getTotalElements());

        return new ResponseEntity<>(productHomeShowPage, HttpStatus.OK);
    }

}
