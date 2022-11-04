package com.extra.service.champion_class.impl;

import com.extra.model.ChampionClass;
import com.extra.repository.IChampionClassRepository;
import com.extra.service.champion_class.IChampionClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChampionClassService implements IChampionClassService {

    @Autowired
    private IChampionClassRepository championClassRepository;

    @Override
    public Iterable<ChampionClass> findAll() {
        return championClassRepository.findAll();
    }

    @Override
    public Optional<ChampionClass> findById(Integer id) {
        return championClassRepository.findById(id);
    }

    @Override
    public ChampionClass save(ChampionClass championClass) {
        return championClassRepository.save(championClass);
    }

    @Override
    public void remove(Integer id) {
        championClassRepository.deleteById(id);
    }
}
