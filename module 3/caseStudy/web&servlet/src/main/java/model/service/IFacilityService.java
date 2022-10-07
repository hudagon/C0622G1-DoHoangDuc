package model.service;

import model.model.facility.Facility;

import java.util.List;

public interface IFacilityService {
    List<Facility> getFacilityList();

    boolean addNewFacility(Facility newFacility);

}
