package com.example.labook_be.model.service.price_range;

import com.example.labook_be.model.entity.PriceRange;
import com.example.labook_be.model.repository.IPriceRangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceRangeServiceImpl implements IPriceRangeService {

    @Autowired
    private IPriceRangeRepository priceRangeRepository;

    @Override
    public List<PriceRange> getAllPriceRanges() {
        return priceRangeRepository.getAllPriceRanges();
    }
}
