package com.example.labook_be.model.repository;

import com.example.labook_be.model.entity.PriceRange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IPriceRangeRepository extends JpaRepository<PriceRange, Integer> {

    @Query(
            value = " select * from price_range ", nativeQuery = true
    )
    List<PriceRange> getAllPriceRanges();

}
