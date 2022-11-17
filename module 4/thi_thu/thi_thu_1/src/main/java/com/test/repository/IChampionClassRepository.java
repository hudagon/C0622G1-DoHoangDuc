package com.test.repository;

import com.test.model.ChampionClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IChampionClassRepository extends JpaRepository<ChampionClass, Integer> {
}
