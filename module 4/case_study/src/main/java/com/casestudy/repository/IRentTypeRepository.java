package com.casestudy.repository;

import com.casestudy.model.facility.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepository extends JpaRepository<RentType, Integer> {
}
