package com.ss12.service;

import com.ss12.model.Smartphone;

import java.util.List;

public interface ISmartphoneService extends IGeneralService<Smartphone> {

    List<Smartphone> findByProducer(String producerName);
}
