package model.service;

import model.model.PayMethod;
import model.model.Tent;

import java.util.List;

public interface ITentService {
    List<Tent> getListTent();

    boolean addNewTent(Tent newTent);

    boolean deleteTent(int idDelete);

    List<Tent> search(String tentIdSearch, String tenantNameSearch, String phoneNumberSearch);

    List<PayMethod> getListPayMethod();

    boolean editTent(Tent editTent);

    Tent findById(int idTent);
}
