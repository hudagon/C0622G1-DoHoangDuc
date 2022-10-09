package model.service.impl;

import model.model.facility.Facility;
import model.repository.impl.FacilityRepository;
import model.service.IFacilityService;
import validation.FacilityNameRegex;

import java.util.List;

public class FacilityService implements IFacilityService {
    FacilityRepository facilityRepository = new FacilityRepository();

    @Override
    public List<Facility> getFacilityList() {
        return facilityRepository.getFacilityList();
    }

    @Override
    public boolean addNewFacility(Facility newFacility) {
        String facilityName = newFacility.getName();

        if (FacilityNameRegex.validate(facilityName)) {
            return facilityRepository.addNewFacility(newFacility);
        }
        return false;
    }

    @Override
    public List<Facility> searchByName(String nameSearch) {
        return facilityRepository.searchByName(nameSearch);
    }

    @Override
    public boolean editFacility(Facility editFacility) {
        return facilityRepository.editFacility(editFacility);
    }

    @Override
    public boolean deleteFacility(int deleteId) {
        return facilityRepository.deleteFacility(deleteId);
    }


}
