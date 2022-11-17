package com.test.service.champion;

import com.test.model.Champion;
import com.test.repository.IChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChampionServiceImpl implements IChampionService {

    @Autowired
    private IChampionRepository championRepository;

    @Override
    public Iterable<Champion> findAll() {
        return championRepository.findAll();
    }

    @Override
    public Optional<Champion> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Champion save(Champion champion) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Page<Champion> findAll(Pageable pageable, String name, String nation, Integer championClassId) {

        if (championClassId != -1) {
            return championRepository.findAll(name, nation, championClassId, pageable);

        }

        return championRepository.findAll(name, nation, pageable);
    }
}
