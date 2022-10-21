package com.ss7.service.blog;

import com.ss7.model.Blog;
import com.ss7.service.IGeneralService;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGeneralService<Blog> {
    Page<Blog> findAll(Pageable pageable);
}
