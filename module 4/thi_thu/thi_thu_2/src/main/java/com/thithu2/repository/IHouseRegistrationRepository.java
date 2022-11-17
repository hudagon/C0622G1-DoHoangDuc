package com.thithu2.repository;

import com.thithu2.model.HouseRegistration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IHouseRegistrationRepository extends JpaRepository<HouseRegistration, Integer> {


    @Query(
            value = "select * from house_registration where host_name like %:hostName% " +
                    "and number_of_members = :numberOfMembers " +
                    "and status = 1",
            nativeQuery = true
    )
    Page<HouseRegistration> findAll(@Param("hostName") String hostName,
                                    @Param("numberOfMembers") Integer numberOfMembers,
                                    Pageable pageable);

    @Query(
            value = "select * from house_registration where host_name like %:hostName% " +
                    "and status = 1",
            nativeQuery = true
    )
    Page<HouseRegistration> findAll(@Param("hostName") String hostName,
                                    Pageable pageable);

}
