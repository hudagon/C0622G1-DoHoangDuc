package com.ss9.lend_book.service.Book;

import com.ss9.lend_book.model.Book;
import com.ss9.lend_book.service.IGeneralService;

import java.util.List;

public interface IBookService extends IGeneralService<Book> {

    List<Book> findBookByTitle(Integer titleId);
}
