package com.thi.service.product_order;

import com.thi.model.ProductOrder;
import com.thi.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductOrderService extends IGeneralService<ProductOrder> {

    Page<ProductOrder> findAll(Pageable pageable);

    Page<ProductOrder> findAll(Pageable pageable, String startDate, String endDate);

}
