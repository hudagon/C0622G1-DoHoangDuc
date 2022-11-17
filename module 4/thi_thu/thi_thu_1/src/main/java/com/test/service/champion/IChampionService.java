package com.test.service.champion;

import com.test.model.Champion;
import com.test.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IChampionService extends IGeneralService<Champion> {

    Page<Champion> findAll(Pageable pageable, String name, String nation, Integer championClassId);

}
