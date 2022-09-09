package services;

import models.Employee;
import models.Person;
import models.Student;

import java.text.ParseException;

public interface IPersonService {
    void add() throws ParseException;

    void display();

    void delete();

    Employee getEmployeeInfo();

    Student getStudentInfo() throws ParseException;

    Person findPerson();
}
