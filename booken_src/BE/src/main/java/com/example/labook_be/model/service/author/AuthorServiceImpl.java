package com.example.labook_be.model.service.author;

import com.example.labook_be.model.entity.Author;
import com.example.labook_be.model.repository.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements IAuthorService {

    @Autowired
    private IAuthorRepository authorRepository;

    @Override
    public List<Author> getAuthorList() {
        return authorRepository.getAuthorList();
    }
}
