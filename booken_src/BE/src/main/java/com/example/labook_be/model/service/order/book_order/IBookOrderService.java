package com.example.labook_be.model.service.order.book_order;


import com.example.labook_be.model.entity.BookOrder;

public interface IBookOrderService {

    BookOrder getBookOrder();

    void saveManually(BookOrder newBookOrder);


}
