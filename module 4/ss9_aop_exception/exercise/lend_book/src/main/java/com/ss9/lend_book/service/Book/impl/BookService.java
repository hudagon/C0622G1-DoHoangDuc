package com.ss9.lend_book.service.Book.impl;

import com.ss9.lend_book.model.Book;
import com.ss9.lend_book.repository.Book.IBookRepository;
import com.ss9.lend_book.service.Book.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {

    @Autowired
    IBookRepository bookRepository;


    @Override
    public Iterable<Book> findAll() {
        return null;
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Book> findBookByTitle(Integer titleId) {
        return bookRepository.findBookByTitle(titleId);
    }
}