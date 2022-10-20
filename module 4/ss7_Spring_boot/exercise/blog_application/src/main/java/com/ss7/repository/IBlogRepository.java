package com.ss7.repository;

import com.ss7.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IBlogRepository extends JpaRepository<Blog, Integer> {
}
