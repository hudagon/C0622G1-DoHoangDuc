package model.repository;

import model.model.PayMethod;
import model.model.Tent;

import java.util.List;

public interface ITentRepository {
    List<Tent> getListTent();

    boolean addNewTent(Tent newTent);

    boolean deleteTent(int idDelete);

    List<Tent> search(String tentIdSearch, String tenantNameSearch, String phoneNumberSearch);

    List<PayMethod> getListPayMethod();
}
