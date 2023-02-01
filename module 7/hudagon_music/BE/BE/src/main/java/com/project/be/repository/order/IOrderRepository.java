package com.project.be.repository.order;

import com.project.be.model.order.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IOrderRepository extends JpaRepository<ProductOrder, Integer> {

    @Query(
            value = " select * " +
                    " from product_order " +
                    " where product_order.user_id = :user_id and product_order.payment_status = 1 ",
            nativeQuery = true
    )
    ProductOrder getOrderByUserId(@Param("user_id") Integer userId);

    @Modifying
    @Query(
            value = " insert into `hudagon_music`.`product_order` (`delete_status`, `order_date`, " +
                    " `user_id`, `payment_status`, `total_money`)  " +
                    "  values ( :delete_status , :order_date , :user_id , :payment_status , :total_money) ",
            nativeQuery = true
    )
    void saveManually(
            @Param("delete_status") String deleteStatus,
            @Param("order_date") String orderDate,
            @Param("user_id") String userId,
            @Param("payment_status") String paymentStatus,
            @Param("total_money") String totalMoney
    );

}
