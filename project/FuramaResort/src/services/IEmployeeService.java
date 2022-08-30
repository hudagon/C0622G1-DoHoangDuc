package services;

import models.creatures.Employee;

public interface IEmployeeService extends IService {
    Employee getEmployeeInfo();

    Employee findEmployeeToEdit();

    void edit();
}
