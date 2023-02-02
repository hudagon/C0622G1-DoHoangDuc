package services;

import models.things.Contract;

public interface IContractService  {
    void add();

    void display();

    void editContract();

    Contract getContractInfo();

    Contract findContractToEdit();
}
