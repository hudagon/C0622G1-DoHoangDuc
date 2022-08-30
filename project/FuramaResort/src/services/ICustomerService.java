package services;

import models.creatures.Customer;

public interface ICustomerService extends IService {
    Customer getCustomerInfo();

    Customer findCustomerToEdit();

    void edit();
}
