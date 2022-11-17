package com.thithu2.repository;

import com.thithu2.model.FamilyMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFamilyMemberRepository extends JpaRepository<FamilyMember, Integer> {

    @Query(
            value = "select * from family_member where house_registration_id = :houseRegistrationId ",
            nativeQuery = true

    )
    List<FamilyMember> findAll(@Param("houseRegistrationId") Integer houseRegistrationId);

}
