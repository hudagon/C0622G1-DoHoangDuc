package com.example.labook_be.model.service.book;

import com.example.labook_be.model.entity.Book;
import com.example.labook_be.payload.SearchBookInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {

    Page<Book> getBookDtoList(SearchBookInfo searchBookInfo, Pageable pageable);

}
