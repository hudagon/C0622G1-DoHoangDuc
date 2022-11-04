package com.extra.repository;

import com.extra.model.Champion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IChampionRepository extends JpaRepository<Champion, Integer> {
}
