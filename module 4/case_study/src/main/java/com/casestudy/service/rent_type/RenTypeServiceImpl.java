package com.casestudy.service.rent_type;

import com.casestudy.model.facility.RentType;
import com.casestudy.repository.IRentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RenTypeServiceImpl implements IRentTypeService {

    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @Override
    public Iterable<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public Optional<RentType> findById(Integer id) {
        return rentTypeRepository.findById(id);
    }

    @Override
    public RentType save(RentType rentType) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }
}
