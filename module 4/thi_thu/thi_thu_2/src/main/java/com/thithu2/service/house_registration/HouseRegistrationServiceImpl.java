package com.thithu2.service.house_registration;

import com.thithu2.model.HouseRegistration;
import com.thithu2.repository.IHouseRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HouseRegistrationServiceImpl implements IHouseRegistrationService {

    @Autowired
    private IHouseRegistrationRepository houseRegistrationRepository;

    @Override
    public Iterable<HouseRegistration> findAll() {
        return null;
    }

    @Override
    public Optional<HouseRegistration> findById(Integer id) {
        return houseRegistrationRepository.findById(id);
    }

    @Override
    public HouseRegistration save(HouseRegistration houseRegistration) {
        return houseRegistrationRepository.save(houseRegistration);
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Page<HouseRegistration> findAll(String hostName, Integer numberOfMembers, Pageable pageable) {

        if (numberOfMembers == -1) {
            return houseRegistrationRepository.findAll(hostName, pageable);

        }

        return houseRegistrationRepository.findAll(hostName, numberOfMembers, pageable);
    }


}
