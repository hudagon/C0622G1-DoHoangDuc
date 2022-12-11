package com.example.airbnb.service;

import com.example.airbnb.model.Blog;
import org.springframework.data.repository.query.Param;

public interface IBlogService extends IService<Blog> {
    Iterable<Blog> findAllByContentContaining(String content);

    Iterable<Blog> findAllByDayCreate(String day);

    Iterable<Blog> findAllByUserId(Long id);

    Iterable<Blog> findAllByStatusPublic();
}
