package com.ss12.repository;

import com.ss12.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISmartphoneRepository extends JpaRepository<Smartphone, Integer> {



    @Query(
            value = "select * from smartphone where producer like %:producerName%",
            nativeQuery = true
    )
    List<Smartphone> findByProducer(@Param("producerName") String producerName);
}
