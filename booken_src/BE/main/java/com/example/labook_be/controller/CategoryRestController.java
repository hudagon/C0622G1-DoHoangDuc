package com.example.labook_be.controller;

import com.example.labook_be.model.entity.Author;
import com.example.labook_be.model.entity.Category;
import com.example.labook_be.model.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/category")
@CrossOrigin("*")
public class CategoryRestController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/getCategoryList")
    public ResponseEntity<List<Category>> getCategoryList() {
        return new ResponseEntity<>(categoryService.getCategoryList(), HttpStatus.OK);
    }

}
