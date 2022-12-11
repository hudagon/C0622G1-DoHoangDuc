package com.example.airbnb.controller;

import com.example.airbnb.model.Blog;
import com.example.airbnb.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    IBlogService blogService;

    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity(blogService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/find-all-public-status")
    public ResponseEntity findAllPublicStatus() {
        return new ResponseEntity(blogService.findAllByStatusPublic(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Blog blog) {
        blogService.save(blog);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return new ResponseEntity(blogService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Blog blog) {
        blog.setId(id);
        blogService.save(blog);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        blogService.remove(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/search-by-content")
    public ResponseEntity findAllByContentContaining(@RequestParam String content) {
        return new ResponseEntity(blogService.findAllByContentContaining(content), HttpStatus.OK);
    }

    @GetMapping("/search-by-day")
    public ResponseEntity findAllByDayCreate(@RequestParam String day) {
        return new ResponseEntity(blogService.findAllByDayCreate(day + '%'), HttpStatus.OK);
    }

    @GetMapping("/search-by-user-id")
    public ResponseEntity findAllByUserId(@RequestParam Long id) {
        return new ResponseEntity(blogService.findAllByUserId(id), HttpStatus.OK);
    }
}
