package services.impl;

import models.creatures.Employee;
import services.IEmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    Scanner scanner = new Scanner(System.in);
    private static List<Employee> employees = new ArrayList<>();

    static {
        employees.add(new Employee("Nguyễn văn A", "1/1/2000", "Nam", 001, 0111222333, "a@gmail.com", "NV001", "Đại học", "Bảo vệ", 5500000));
        employees.add(new Employee("Nguyễn văn B", "2/2/2000", "Nam", 002, 0222333444, "b@gmail.com", "NV002", "Đại học", "Lao công", 5800000));
        employees.add(new Employee("Nguyễn thị C", "3/3/2000", "Nữ", 003, 0555666777, "c@gmail.com", "NV003", "Đại học", "Giám đốc", 100000000));
    }

    @Override
    public void display() {
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    @Override
    public void add() {
        employees.add(this.getEmployeeInfo());
        System.out.println("New employee added successfully!");
    }

    @Override
    public Employee getEmployeeInfo() {
        System.out.print("Input employee's name: ");
        String employeeName = scanner.nextLine();
        System.out.print("Input employee's birthday': ");
        String employeeBirthday = scanner.nextLine();
        System.out.print("Input employee's gender: ");
        String employeeGender = scanner.nextLine();
        System.out.print("Input employee's citizen identity number: ");
        int employeeCitizenIdentityNumber = Integer.parseInt(scanner.nextLine());
        System.out.print("Input employee's phone number: ");
        int employeePhoneNumber = Integer.parseInt(scanner.nextLine());
        System.out.print("Input employee's email address: ");
        String employeeEmail = scanner.nextLine();
        System.out.print("Input employee's id: ");
        String employeeId = scanner.nextLine();

        String employeeQualifications = "";
        boolean temp = true;
        while (temp) {
            System.out.print("Input employee's employee qualifications:\n" +
                    "1. University\n" +
                    "2. College\n" +
                    "3. Intermediate\n" +
                    "4. Post-Graduate\n");
            System.out.print("Input your choice here: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    employeeQualifications = "University";
                    temp = false;
                    break;
                case 2:
                    employeeQualifications = "College";
                    temp = false;
                    break;
                case 3:
                    employeeQualifications = "Intermediate";
                    temp = false;
                    break;
                case 4:
                    employeeQualifications = "Post-Graduate";
                    temp = false;
                    break;
                default:
                    System.out.println("------------------------");
                    System.out.println("Wrong input!, try again");
            }
        }

        System.out.print("Input employee's position: ");
        String employeePosition = scanner.nextLine();
        System.out.print("Input employee's salary: ");
        double employeeSalary = Double.parseDouble(scanner.nextLine());

        return new Employee(employeeName, employeeBirthday, employeeGender, employeeCitizenIdentityNumber,
                employeePhoneNumber, employeeEmail, employeeId, employeeQualifications, employeePosition, employeeSalary);
    }
}
