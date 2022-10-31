package com.ss7.controller;

import com.ss7.dto.BlogDto;
import com.ss7.model.Blog;
import com.ss7.service.blog.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blog")
public class RestBlogController {

    @Autowired
    private IBlogService blogService;


    @GetMapping
    public ResponseEntity<Iterable<BlogDto>> getBlogList() {
        List<Blog> blogList = (List<Blog>) blogService.findAll();

        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<BlogDto> blogListDto = new ArrayList<>();

        for (Blog x : blogList) {
            BlogDto blogDto = new BlogDto();
            BeanUtils.copyProperties(x, blogDto);
            blogDto.setCategoryId(x.getCategory().getId());
            blogListDto.add(blogDto);
        }


        return new ResponseEntity<>(blogListDto, HttpStatus.OK);
    }

    @GetMapping("/category-{id}")
    public ResponseEntity<Iterable<Blog>> getBlogListOfOneCategory(@PathVariable Integer id) {
        List<Blog> blogList = blogService.findAllBasedOnCategory(id);

        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> viewBlog(@PathVariable Integer id) {
        Optional<Blog> blogViewed = blogService.findById(id);

        if (!blogViewed.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(blogViewed.get(), HttpStatus.OK);
    }
}
