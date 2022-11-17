package com.test.repository;

import com.test.model.Champion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IChampionRepository extends JpaRepository<Champion, Integer> {


    @Query(
            value = "select * from champion where name like %:championName% " +
                    "and nation like %:nation% " +
                    "and champion_class_id = :championClassId " +
                    "and status = 1",
            nativeQuery = true

    )
    Page<Champion> findAll(@Param("championName") String championName,
                           @Param("nation") String nation,
                           @Param("championClassId") Integer championClassId,
                           Pageable pageable);


    @Query(
            value = "select * from champion where name like %:championName% " +
                    "and nation like %:nation% " +
                    "and status = 1",
            nativeQuery = true

    )
    Page<Champion> findAll(@Param("championName") String championName,
                           @Param("nation") String nation,
                           Pageable pageable);
}
