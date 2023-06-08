package com.example.labook_be.model.service.order.book_order_detail;

import com.example.labook_be.model.repository.IBookOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookOrderDetailServiceImpl implements IBookOrderDetailService {

    @Autowired
    private IBookOrderDetailRepository bookOrderDetailRepository;

    @Override
    public void addBookOrderDetail(Long bookOrderId, int quantity, Long bookId) {
        bookOrderDetailRepository.addBookOrderDetail(bookOrderId, quantity, bookId);
    }

    @Override
    public void updateProductOrderDetail(int newQuantity, Long bookOrderDetailId) {
        bookOrderDetailRepository.updateProductOrderDetail(newQuantity, bookOrderDetailId);
    }

    @Override
    public void removeFromCart(Long bookOrderDetailId) {
        bookOrderDetailRepository.removeFromCart(bookOrderDetailId);
    }

}
