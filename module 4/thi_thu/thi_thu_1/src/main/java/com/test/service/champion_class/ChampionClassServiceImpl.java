package com.test.service.champion_class;

import com.test.model.ChampionClass;
import com.test.repository.IChampionClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChampionClassServiceImpl implements IChampionClassService {

    @Autowired
    private IChampionClassRepository championClassRepository;

    @Override
    public Iterable<ChampionClass> findAll() {
        return championClassRepository.findAll();
    }

    @Override
    public Optional<ChampionClass> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public ChampionClass save(ChampionClass championClass) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }
}
