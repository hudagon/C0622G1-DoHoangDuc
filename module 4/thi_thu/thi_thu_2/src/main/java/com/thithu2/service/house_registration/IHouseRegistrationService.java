package com.thithu2.service.house_registration;

import com.thithu2.model.HouseRegistration;
import com.thithu2.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IHouseRegistrationService extends IGeneralService<HouseRegistration> {

    Page<HouseRegistration> findAll(String hostName, Integer numberOfMembers, Pageable pageable);

}
