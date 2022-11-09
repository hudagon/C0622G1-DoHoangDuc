package com.casestudy.service.contract;

import com.casestudy.model.contract.AttachFacility;
import com.casestudy.model.contract.Contract;
import com.casestudy.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService extends IGeneralService<Contract> {

    Page<Contract> findAll(String customerSearchName, String facilitySearchName, Pageable pageable);

    String getTotalMoney(Integer contractId);
}
