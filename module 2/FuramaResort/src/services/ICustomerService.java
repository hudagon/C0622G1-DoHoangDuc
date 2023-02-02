package services;

import models.creatures.Customer;

public interface ICustomerService extends IService {
    Customer getCustomerInfo();

    Customer findCustomer();

    void edit();
}
