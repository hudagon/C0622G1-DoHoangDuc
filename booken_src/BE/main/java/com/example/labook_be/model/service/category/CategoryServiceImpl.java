package com.example.labook_be.model.service.category;

import com.example.labook_be.model.entity.Category;
import com.example.labook_be.model.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> getCategoryList() {
        return categoryRepository.getCategoryList();
    }

}
