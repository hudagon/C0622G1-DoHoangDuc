package model.repository;

import model.model.facility.Facility;

import java.util.List;

public interface IFacilityRepository {
    List<Facility> getFacilityList();

    boolean addNewFacility(Facility newFacility);
}
