package model.service.impl;

import model.model.human.employee.Employee;
import model.repository.impl.EmployeeRepository;
import model.service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public List<Employee> getEmployeeList() {
        return employeeRepository.getEmployeeList();
    }
}
