package com.C0622G1.service.carhost;

import com.C0622G1.model.CarHost;
import com.C0622G1.repository.ICarHostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarHostServiceImpl implements ICarHostService {

    @Autowired
    private ICarHostRepository carHostRepository;

    @Override
    public List<CarHost> findAll() {
        return carHostRepository.findAll();
    }

    @Override
    public Optional<CarHost> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public CarHost save(CarHost carHost) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }
}
