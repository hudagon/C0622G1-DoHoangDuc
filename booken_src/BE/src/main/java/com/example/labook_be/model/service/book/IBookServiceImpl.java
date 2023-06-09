package com.example.labook_be.model.service.book;

import com.example.labook_be.model.entity.Book;
import com.example.labook_be.model.entity.PriceRange;
import com.example.labook_be.model.repository.IPriceRangeRepository;
import com.example.labook_be.payload.SearchBookInfo;
import com.example.labook_be.model.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IBookServiceImpl implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private IPriceRangeRepository priceRangeRepository;

    @Override
    public Page<Book> getBookDtoList(SearchBookInfo searchBookInfo, Pageable pageable) {

        Optional<PriceRange> priceRangeOpt = priceRangeRepository.findById(searchBookInfo.getPriceRangeId());

        PriceRange priceRange = new PriceRange(0, 0, 999999999, "Trên 150.000 VNĐ");
        if (priceRangeOpt.isPresent()) {
            priceRange = priceRangeOpt.get();
        }

        switch (searchBookInfo.getSortOption()) {
            case 0 -> pageable = PageRequest.of(
                    searchBookInfo.getPageNumber(),
                    searchBookInfo.getPageSize(),
                    searchBookInfo.isSortDirection() ?
                            Sort.by("input_date").ascending()
                            :
                            Sort.by("input_date").descending()
            );
            case 1 -> pageable = PageRequest.of(
                    searchBookInfo.getPageNumber(),
                    searchBookInfo.getPageSize(),
                    searchBookInfo.isSortDirection() ?
                            Sort.by("price").ascending()
                            :
                            Sort.by("price").descending()
            );
            default -> pageable = PageRequest.of(
                    searchBookInfo.getPageNumber(),
                    searchBookInfo.getPageSize()
            );
        }

        return bookRepository.searchProduct(
                searchBookInfo.getName(),
                searchBookInfo.getAuthorId(),
                searchBookInfo.getCategoryId(),
                priceRange.getFirstPrice(),
                priceRange.getSecondPrice(),
                pageable
        );

    }

}
















