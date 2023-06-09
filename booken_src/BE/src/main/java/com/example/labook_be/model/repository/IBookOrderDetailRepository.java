package com.example.labook_be.model.repository;

import com.example.labook_be.model.entity.BookOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IBookOrderDetailRepository extends JpaRepository<BookOrderDetail, Long> {

    @Modifying
    @Query(
            value = " update `labook`.`book_order_detail` " +
                    " set `quantity` = :new_quantity " +
                    " where (`id` = :book_order_detail_id)",
            nativeQuery = true
    )
    void updateProductOrderDetail(
            @Param("new_quantity") int newQuantity,
            @Param("book_order_detail_id") Long bookOrderDetailId
    );


    @Modifying
    @Query(
            value = " insert into `labook`.`book_order_detail` (`book_order_id`, `book_id`, `quantity`) " +
                    " values (:book_order_id, :book_id, :quantity); ",
            nativeQuery = true
    )
    void addBookOrderDetail(
            @Param("book_order_id") Long bookOrderId,
            @Param("quantity") int quantity,
            @Param("book_id") Long bookId
    );

    @Modifying
    @Query(
            value = " delete from `labook`.`book_order_detail` " +
                    " where (`id` = :book_order_detail_id ) ",
            nativeQuery = true
    )
    void removeFromCart(
            @Param("book_order_detail_id") Long bookOrderDetailId
    );


}
