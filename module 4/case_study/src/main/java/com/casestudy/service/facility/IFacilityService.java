package com.casestudy.service.facility;

import com.casestudy.model.customer.Customer;
import com.casestudy.model.facility.Facility;
import com.casestudy.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService extends IGeneralService<Facility> {

    Page<Facility> findAll(String searchName, String searchRentType,
                          String searchFacilityType, Pageable pageable);

}
