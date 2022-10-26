package com.ss9.lend_book.repository.Book;

import com.ss9.lend_book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "select * from book where title_id = :titleId and status = 1",
            nativeQuery = true)
    List<Book> findBookByTitle(Integer titleId);
}
