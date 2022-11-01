package com.ss12.service.impl;

import com.ss12.model.Smartphone;
import com.ss12.repository.ISmartphoneRepository;
import com.ss12.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SmartphoneService implements ISmartphoneService {

    @Autowired
    private ISmartphoneRepository smartphoneRepository;

    @Override
    public Iterable<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Optional<Smartphone> findById(Integer id) {
        return smartphoneRepository.findById(id);
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
        return smartphoneRepository.save(smartphone);
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public List<Smartphone> findByProducer(String producerName) {
        return smartphoneRepository.findByProducer(producerName);
    }
}
