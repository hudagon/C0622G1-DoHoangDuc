package com.project.be.repository.product;

import com.project.be.dto.product.ProductSearchDto;
import com.project.be.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = " select * " +
            " from product " +
            " where if (0 < 1, brand_id = 1, brand_id > 0)  " +
            "  and if (0 < 2, category_id = 2, category_id > 0);", nativeQuery = true)
    Page<Product> searchAllProduct(
            @Param("brand_id") int brand_id,
            @Param("category_id") int category_id,
            Pageable pageable
    );

    @Query(
            value = " select * " +
                    " from product " +
                    " where if (:#{#productSearchDto.brandId} > 0, brand_id = :#{#productSearchDto.brandId}, brand_id > 0)  " +
                    "  and if (:#{#productSearchDto.categoryId} > 0, category_id = :#{#productSearchDto.categoryId}, category_id > 0);", nativeQuery = true
    )
    Page<Product> findAllOk1(
            @Param("productSearchDto") ProductSearchDto productSearchDto,
            Pageable pageable);


}
