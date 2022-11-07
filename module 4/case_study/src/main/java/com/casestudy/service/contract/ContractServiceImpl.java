package com.casestudy.service.contract;

import com.casestudy.model.contract.Contract;
import com.casestudy.repository.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractServiceImpl implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Override
    public Iterable<Contract> findAll() {
        return null;
    }

    @Override
    public Optional<Contract> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Contract save(Contract contract) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Page<Contract> findAll(String customerSearchName, String facilitySearchName, Pageable pageable) {
        return contractRepository.findAll(customerSearchName, facilitySearchName, pageable);
    }
}
