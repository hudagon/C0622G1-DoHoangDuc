package com.casestudy.repository;

import com.casestudy.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
}
