package com.project.be.repository.product;

import com.project.be.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query(
            value = " select *\n" +
                    "from product\n" +
                    "where name like %:product_name% and if ( :brand_id > 0, brand_id = :brand_id , brand_id > 0)\n" +
                    "\t\t\t\t     and if ( :category_id > 0, category_id = :category_id, category_id > 0) "
            , nativeQuery = true
    )
    Page<Product> searchProduct(
            @Param("brand_id") String brandId,
            @Param("category_id") String categoryId,
            @Param("product_name") String productName,
            Pageable pageable);


}
