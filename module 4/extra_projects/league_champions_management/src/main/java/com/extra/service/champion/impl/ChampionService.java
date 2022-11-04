package com.extra.service.champion.impl;

import com.extra.model.Champion;
import com.extra.repository.IChampionRepository;
import com.extra.service.champion.IChampionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChampionService implements IChampionService {

    @Autowired
    private IChampionRepository championRepository;

    @Override
    public Iterable<Champion> findAll() {
        return championRepository.findAll();
    }

    @Override
    public Optional<Champion> findById(Integer id) {
        return championRepository.findById(id);
    }

    @Override
    public Champion save(Champion champion) {
        return championRepository.save(champion);
    }

    @Override
    public void remove(Integer id) {
        championRepository.deleteById(id);
    }
}
