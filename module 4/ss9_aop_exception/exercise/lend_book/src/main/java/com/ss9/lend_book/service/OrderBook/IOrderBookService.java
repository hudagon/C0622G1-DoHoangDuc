package com.ss9.lend_book.service.OrderBook;

import com.ss9.lend_book.model.OrderBook;
import com.ss9.lend_book.service.IGeneralService;

import java.util.Optional;

public interface IOrderBookService extends IGeneralService<OrderBook>{
    Optional<OrderBook> findByOtp(Integer otp);

    Integer getOtp();
}
