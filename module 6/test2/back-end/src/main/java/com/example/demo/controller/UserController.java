package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/test1")
    public ResponseEntity<List<User>> getUserList1() {
        return new ResponseEntity<>((List<User>) userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/test2")
    public ResponseEntity<List<User>> getUserList2() {
        return new ResponseEntity<>((List<User>) userService.findAll(), HttpStatus.OK);
    }

}
