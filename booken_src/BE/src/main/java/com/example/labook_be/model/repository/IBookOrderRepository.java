package com.example.labook_be.model.repository;

import com.example.labook_be.model.entity.BookOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IBookOrderRepository extends JpaRepository<BookOrder, Long> {

    @Query(
            value = " select * " +
                    " from book_order " +
                    " where book_order.payment_status = 0 ",
            nativeQuery = true
    )
    BookOrder getBookOrder();

    @Modifying
    @Query(
            value = " insert into `labook`.`book_order` (`order_date`, `total_money`) " +
                    "VALUES ( :order_date, :total_money);",
            nativeQuery = true
    )
    void saveManually(
            @Param("order_date") String orderDate,
            @Param("total_money") Long totalMoney
    );

}
