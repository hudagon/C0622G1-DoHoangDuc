package com.example.labook_be.model.repository;

import com.example.labook_be.model.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IBookRepository extends JpaRepository<Book, Long> {

    @Query(
            value = " select * " +
                    " from book " +
                    " where name like %:name% and if ( :author_id > 0, author_id = :author_id , author_id > 0) " +
                    "           and if ( :category_id > 0, category_id = :category_id , category_id > 0) " +
                    "           and price between :first_price and :second_price "
            , nativeQuery = true
    )
    Page<Book> searchProduct(
            @Param("name") String name,
            @Param("author_id") int authorId,
            @Param("category_id") int categoryId,
            @Param("first_price") int firstPrice,
            @Param("second_price") int secondPrice,
            Pageable pageable);


}
