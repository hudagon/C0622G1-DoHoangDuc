package com.example.labook_be.model.service.order.book_order;

import com.example.labook_be.model.entity.BookOrder;
import com.example.labook_be.model.repository.IBookOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookOrderServiceImpl implements IBookOrderService {

    @Autowired
    private IBookOrderRepository bookOrderRepository;

    @Override
    public BookOrder getBookOrder() {
        return bookOrderRepository.getBookOrder();
    }

    @Override
    public void saveManually(BookOrder newBookOrder) {
        bookOrderRepository.saveManually(
                String.valueOf(newBookOrder.getOrderDate()),
                newBookOrder.getTotalMoney()
        );
    }


}
