package com.example.labook_be.model.service.author;

import com.example.labook_be.model.entity.Author;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IAuthorService {

    List<Author> getAuthorList();

}
