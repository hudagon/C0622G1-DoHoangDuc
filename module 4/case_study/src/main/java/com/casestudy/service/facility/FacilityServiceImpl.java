package com.casestudy.service.facility;

import com.casestudy.model.customer.Customer;
import com.casestudy.model.facility.Facility;
import com.casestudy.repository.IFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacilityServiceImpl implements IFacilityService {

    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public Iterable<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public Optional<Facility> findById(Integer id) {
        return facilityRepository.findById(id);
    }

    @Override
    public Facility save(Facility facility) {
        return facilityRepository.save(facility);
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Page<Facility> findAll(String searchName, String searchRentType,
                                 String searchFacilityType, Pageable pageable) {
        return facilityRepository.findAll(searchName, searchRentType, searchFacilityType, pageable);
    }
}
