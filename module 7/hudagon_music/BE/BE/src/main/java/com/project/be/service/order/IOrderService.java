package com.project.be.service.order;

import com.project.be.dto.order.ProductOrderDto;
import com.project.be.model.order.ProductOrder;
import com.project.be.service.IGeneralService;

public interface IOrderService extends IGeneralService<ProductOrder> {

    ProductOrder getOrderByUserId(Integer userId);

    void saveManually(ProductOrderDto productOrderDto);

    void addProductOrderDetail(String productOrderId, String productQuantity, String productId);

}
