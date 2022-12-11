package com.example.demo.controller;

import com.example.demo.dto.JwtRespone;
import com.example.demo.dto.SignInForm;
import com.example.demo.security.jwt.JwtProvider;
import com.example.demo.security.user_detail.MyUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/auth")
public class SecurityController {

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody SignInForm signInForm) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInForm.getUsername(), signInForm.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.createToken(authentication);

        MyUserDetail myUserDetail = (MyUserDetail) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtRespone(token, myUserDetail.getAccount().getUser().getName(),
                myUserDetail.getAuthorities()));
    }

}
