package com.example.labook_be.controller;

import com.example.labook_be.model.entity.BookOrder;
import com.example.labook_be.model.entity.BookOrderDetail;
import com.example.labook_be.model.service.order.book_order.IBookOrderService;
import com.example.labook_be.model.service.order.book_order_detail.IBookOrderDetailService;
import com.example.labook_be.utils.GetDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/order")
public class OrderRestController {

    @Autowired
    private IBookOrderService bookOrderService;

    @Autowired
    private IBookOrderDetailService bookOrderDetailService;

    @GetMapping("/getBookOrder")
    public ResponseEntity<BookOrder> getBookOrder() {

        BookOrder bookOrderFound = bookOrderService.getBookOrder();

        if (bookOrderFound == null) {
            BookOrder newBookOrder = new BookOrder();

            newBookOrder.setOrderDate(Date.valueOf(GetDate.getCurrentDate()));
            newBookOrder.setDeleteStatus(false);
            newBookOrder.setPayment_status(false);
            newBookOrder.setTotalMoney(0L);

            bookOrderService.saveManually(newBookOrder);

            BookOrder bookOrderNew = bookOrderService.getBookOrder();

            return new ResponseEntity<>(bookOrderNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(bookOrderFound, HttpStatus.OK);
    }

    @GetMapping("/addToCart")
    public ResponseEntity<Void> addToCart(
            @RequestParam String bookId,
            @RequestParam String bookOrderId,
            @RequestParam String quantity
    ) {

        BookOrder bookOrder = bookOrderService.getBookOrder();

        if (bookOrder != null) {

            for (BookOrderDetail x : bookOrder.getBookOrderDetailSet()) {
                if (x.getBook().getId() == Long.parseLong(bookId)) {

                    int oldQuantity = x.getQuantity();
                    int newQuantity = ++oldQuantity;

                    bookOrderDetailService.updateProductOrderDetail(
                            newQuantity,
                            x.getId()
                    );

                    return new ResponseEntity<>(HttpStatus.OK);
                }
            }

        }

        bookOrderDetailService.addBookOrderDetail(
                Long.parseLong(bookOrderId),
                Integer.parseInt(quantity),
                Long.parseLong(bookId)
        );

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/removeFromCart")
    public ResponseEntity<Void> removeFromCart(
            @RequestParam String bookOrderDetailId
    ) {

        bookOrderDetailService.removeFromCart(Long.valueOf(bookOrderDetailId));

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
