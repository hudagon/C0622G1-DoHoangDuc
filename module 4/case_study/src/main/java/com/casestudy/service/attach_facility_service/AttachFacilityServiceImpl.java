package com.casestudy.service.attach_facility_service;

import com.casestudy.model.contract.AttachFacility;
import com.casestudy.repository.IAttachFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AttachFacilityServiceImpl implements IAttachFacilityService {

    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;

    @Override
    public Iterable<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public Optional<AttachFacility> findById(Integer id) {
        return attachFacilityRepository.findById(id);
    }

    @Override
    public AttachFacility save(AttachFacility attachFacility) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }
}
