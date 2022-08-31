package services;

import models.things.Contract;

public interface IContractService extends IService {
    void add();

    void display();

    void editContract();

    Contract getContractInfo();

    Contract findContractToEdit();
}
