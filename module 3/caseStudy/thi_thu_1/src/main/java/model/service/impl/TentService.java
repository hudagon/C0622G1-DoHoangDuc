package model.service.impl;

import model.model.PayMethod;
import model.model.Tent;
import model.repository.impl.TentRepository;
import model.service.ITentService;
import validation.DescriptionRegex;
import validation.PhoneNumberRegex;
import validation.TenantNameRegex;

import java.util.List;

public class TentService implements ITentService {
    TentRepository tentRepository = new TentRepository();
    @Override
    public List<Tent> getListTent() {
        return tentRepository.getListTent();
    }

    @Override
    public boolean addNewTent(Tent newTent) {

        if (!newTent.getTenantName().matches(TenantNameRegex.TENANT_NAME_REGEX) &&
            !newTent.getPhoneNumber().matches(PhoneNumberRegex.PHONE_NUMBER_REGEX) &&
            !newTent.getDescription().matches(DescriptionRegex.DESCRIPTION_REGEX)) {
            return false;
        }



        return tentRepository.addNewTent(newTent);
    }

    @Override
    public boolean deleteTent(int idDelete) {
        return tentRepository.deleteTent(idDelete);
    }

    @Override
    public List<Tent> search(String tentIdSearch, String tenantNameSearch, String phoneNumberSearch) {
        return tentRepository.search(tentIdSearch, tenantNameSearch, phoneNumberSearch);
    }

    @Override
    public List<PayMethod> getListPayMethod() {
        return tentRepository.getListPayMethod();
    }
}
