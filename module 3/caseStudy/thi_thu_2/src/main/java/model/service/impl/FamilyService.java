package model.service.impl;

import model.model.Family;
import model.repository.impl.FamilyRepository;
import model.service.IFamilyService;

import java.util.List;

public class FamilyService implements IFamilyService {
    FamilyRepository familyRepository = new FamilyRepository();


    @Override
    public List<Family> getListFamily() {
        return familyRepository.getListFamily();
    }
}
