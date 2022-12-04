package com.ss11.repository;

import com.ss11.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Long> {


    @Modifying
    @Query(value = "insert into customer(id, first_name, last_name, customer_type_id) " +
            "value (:customerId, :firstName, :lastName, :customerTypeId);", nativeQuery = true)
    void save(@Param("customerId") Long customerId,
              @Param("firstName") String firstName,
              @Param("lastName") String lastName,
              @Param("customerTypeId") Integer customerTypeId);

}
