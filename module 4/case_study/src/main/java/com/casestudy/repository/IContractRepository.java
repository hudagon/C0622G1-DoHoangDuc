package com.casestudy.repository;

import com.casestudy.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IContractRepository extends JpaRepository<Contract, Integer> {

    @Query(value = "select \n" +
            "\t`contract`.*\n" +
            "from `contract` join `customer` on `contract`.customer_id = `customer`.id\n" +
            "\t\t\t  join `facility` on `contract`.facility_id = `facility`.id\n" +
            "where `customer`.`name` like %:customerSearchName% and `facility`.`name` like %:facilitySearchName% \n" +
            "\t  and `facility`.`status` = 1\n" +
            "\t  and `customer`.`status` = 1 \n" +
            "      and `contract`.`status` = 1 \n",
            nativeQuery = true)
    Page<Contract> findAll(@Param("customerSearchName") String customerSearchName,
                           @Param("facilitySearchName") String facilitySearchName,
                           Pageable pageable);

}
