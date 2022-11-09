package com.casestudy.service.contract_detail;

import com.casestudy.model.contract.ContractDetail;
import com.casestudy.service.IGeneralService;

import java.util.List;

public interface IContractDetailService extends IGeneralService<ContractDetail> {

    List<ContractDetail> findByContractIdForMoney(Integer contractId);

    List<ContractDetail> findByContractIdForAttachFacility(Integer contractId);

}
