package com.casestudy.repository;

import com.casestudy.model.facility.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityTypeRepository extends JpaRepository<FacilityType, Integer> {
}
