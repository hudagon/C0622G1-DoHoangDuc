package com.example.airbnb.service.impl;

import com.example.airbnb.model.Blog;
import com.example.airbnb.repository.BlogRepository;
import com.example.airbnb.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    BlogRepository blogRepository;

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAllByNameContaining(Pageable pageable, String name) {
        return null;
    }

    @Override
    public Iterable<Blog> findAllByContentContaining(String content) {
        return blogRepository.findAllByContentContaining(content);
    }

    @Override
    public Iterable<Blog> findAllByDayCreate(String day) {
        return blogRepository.findAllByDayCreate(day);
    }

    @Override
    public Iterable<Blog> findAllByUserId(Long id) {
        return blogRepository.findAllByUserId(id);
    }

    @Override
    public Iterable<Blog> findAllByStatusPublic() {
        return blogRepository.findAllByStatusPublic();
    }


}
