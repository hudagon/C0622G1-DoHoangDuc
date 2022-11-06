package com.casestudy.service.facility_type;

import com.casestudy.model.facility.FacilityType;
import com.casestudy.repository.IFacilityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacilityTypeServiceImpl implements IFacilityTypeService {

    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;

    @Override
    public Iterable<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }

    @Override
    public Optional<FacilityType> findById(Integer id) {
        return facilityTypeRepository.findById(id);
    }

    @Override
    public FacilityType save(FacilityType facilityType) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }
}
