package com.project.be.controller.order;

import com.project.be.dto.order.ProductOrderDto;
import com.project.be.model.order.ProductOrder;
import com.project.be.service.order.IOrderService;
import com.project.be.util.GetDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/productOrder")
public class ProductOrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping("/getProductOrder")
    public ResponseEntity<ProductOrder> getProductOrderByUserId(
            @RequestParam String userId
    ) {

        ProductOrder productOrderFound = orderService.getOrderByUserId(Integer.valueOf(userId));

        if (productOrderFound == null) {
            ProductOrderDto newProductOrderDto = new ProductOrderDto();
            newProductOrderDto.setOrderDate(GetDate.getCurrentDate());
            newProductOrderDto.setUserId(Integer.valueOf(userId));
            newProductOrderDto.setDeleteStatus(1);
            newProductOrderDto.setPaymentStatus(1);
            newProductOrderDto.setTotalMoney(0L);

            orderService.saveManually(newProductOrderDto);

            ProductOrder productOrderNew = orderService.getOrderByUserId(Integer.valueOf(userId));

            return new ResponseEntity<>(productOrderNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(productOrderFound, HttpStatus.OK);
    }

}
