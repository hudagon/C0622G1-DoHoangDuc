package com.thi.repository;

import com.thi.model.ProductOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductOrderRepository extends JpaRepository<ProductOrder, Integer> {

    @Query(
            value = "select * from product_order where delete_status = 1",
            nativeQuery = true
    )
    Page<ProductOrder> findAll(Pageable pageable);

    @Query(
            value = "select * from product_order where buy_date between :startDate and :endDate " +
                    "and delete_status = 1",
            nativeQuery = true
    )
    Page<ProductOrder> findAll(Pageable pageable,
                               @Param("startDate") String startDate,
                               @Param("endDate") String endDate);

}
