package com.example.labook_be.controller;

import com.example.labook_be.model.entity.Book;
import com.example.labook_be.model.entity.PriceRange;
import com.example.labook_be.model.service.price_range.IPriceRangeService;
import com.example.labook_be.payload.SearchBookInfo;
import com.example.labook_be.model.service.book.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/book")
@CrossOrigin("*")
public class BookRestController {

    @Autowired
    private IBookService bookService;

    @Autowired
    private IPriceRangeService priceRangeService;

    @PostMapping("/searchBook")
    public ResponseEntity<Page<Book>> searchBook(
            @RequestBody SearchBookInfo searchBookInfo,
            @PageableDefault(value = 6) Pageable pageable
            ) {

        Page<Book> bookPage = bookService.getBookDtoList(searchBookInfo, pageable);

        return new ResponseEntity<>(bookPage, HttpStatus.OK);
    }

    @GetMapping("/getAllPriceRanges")
    public ResponseEntity<List<PriceRange>> getAllPriceRanges() {

        List<PriceRange> priceRangeList = new ArrayList<>();
        try {

            priceRangeList = priceRangeService.getAllPriceRanges();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return new ResponseEntity<>(priceRangeList, HttpStatus.OK);
    }

}











