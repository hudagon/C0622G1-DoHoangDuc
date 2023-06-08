package com.example.labook_be.controller;

import com.example.labook_be.model.entity.Author;
import com.example.labook_be.model.service.author.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/author")
@CrossOrigin("*")
public class AuthorRestController {

    @Autowired
    private IAuthorService authorService;

    @GetMapping("/getAuthorList")
    public ResponseEntity<List<Author>> getAuthorList() {
        return new ResponseEntity<>(authorService.getAuthorList(), HttpStatus.OK);
    }

}















