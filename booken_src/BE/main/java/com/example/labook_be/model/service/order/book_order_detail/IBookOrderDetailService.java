package com.example.labook_be.model.service.order.book_order_detail;

public interface IBookOrderDetailService {

    void addBookOrderDetail(Long bookOrderId, int quantity, Long bookId);

    void updateProductOrderDetail(int newQuantity, Long bookOrderDetailId);

    void removeFromCart(Long bookOrderDetailId);

}
