package services.impl;

import models.creatures.Employee;
import services.IEmployeeService;
import utils.read_write_file.read_write_employee.ReadFileEmployee;
import utils.read_write_file.read_write_employee.WriteFileEmployee;

import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    public static final String PATH = "src\\data\\employee.csv";
    Scanner scanner = new Scanner(System.in);
    private List<Employee> employees = ReadFileEmployee.readEmployeeFile(PATH);
    boolean temp = true;

    @Override
    public void display() {
        employees = ReadFileEmployee.readEmployeeFile(PATH);
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    @Override
    public void add() {
        employees = ReadFileEmployee.readEmployeeFile(PATH);
        Employee newEmployee = this.getEmployeeInfo();
        employees.add(newEmployee);
        System.out.println("New employee added successfully!");
        WriteFileEmployee.writeEmployeeFile(PATH, false,employees);
    }

    @Override
    public void edit() {
        Employee employeeEdit = this.findEmployeeToEdit();
        if (employeeEdit == null) {
            System.out.println("Can't found employee to edit");
        } else {
            while (true) {
                int positionEdit = employees.indexOf(employeeEdit);
                System.out.print("What information do you want to edit?\n" +
                        "1. Name\n" +
                        "2. Birthday\n" +
                        "3. Gender\n" +
                        "4. Citizen identity number\n" +
                        "5. Phone number\n" +
                        "6. Employee ID\n" +
                        "7. Employee qualifications\n" +
                        "8. Employee position\n" +
                        "9. Employee salary\n" +
                        "10. Exit\n" +
                        "--> Input here: ");
                int choiceEdit = Integer.parseInt(scanner.nextLine());

                switch (choiceEdit) {
                    case 1:
                        System.out.print("How do you want to change?: ");
                        String newName = scanner.nextLine();
                        employees.get(positionEdit).setName(newName);
                        System.out.println("Edit name successfully!");
                        System.out.println("---------------------------");
                        break;
                    case 2:
                        System.out.print("How do you want to change?: ");
                        String newBirthday = scanner.nextLine();
                        employees.get(positionEdit).setBirthday(newBirthday);
                        System.out.println("Edit birthday successfully!");
                        System.out.println("---------------------------");
                        break;
                    case 3:
                        System.out.print("How do you want to change?: ");
                        String newGender = scanner.nextLine();
                        employees.get(positionEdit).setGender(newGender);
                        System.out.println("Edit gender successfully!");
                        System.out.println("---------------------------");
                        break;
                    case 4:
                        System.out.print("How do you want to change?: ");
                        int newCitizenIdentifyNumber = Integer.parseInt(scanner.nextLine());
                        employees.get(positionEdit).setCitizenIdentityNumber(newCitizenIdentifyNumber);
                        System.out.println("Edit Citizen identity number successfully!");
                        System.out.println("---------------------------");
                        break;
                    case 5:
                        System.out.print("How do you want to change?: ");
                        String newPhoneNumber = scanner.nextLine();
                        employees.get(positionEdit).setPhoneNumber(newPhoneNumber);
                        System.out.println("Edit phone number successfully!");
                        System.out.println("---------------------------");
                        break;
                    case 6:
                        System.out.print("How do you want to change?: ");
                        String newID = scanner.nextLine();
                        employees.get(positionEdit).setId(newID);
                        System.out.println("Edit ID successfully!");
                        System.out.println("---------------------------");
                        break;
                    case 7:
                        System.out.print("How do you want to change?: ");
                        String newQualification = scanner.nextLine();
                        employees.get(positionEdit).setEmployeeQualifications(newQualification);
                        System.out.println("Edit qualifications successfully!");
                        System.out.println("---------------------------");
                        return;
                    case 8:
                        System.out.print("How do you want to change?: ");
                        String newPosition = scanner.nextLine();
                        employees.get(positionEdit).setEmployeePosition(newPosition);
                        System.out.println("Edit position successfully!");
                        System.out.println("---------------------------");
                        break;
                    case 9:
                        System.out.print("How do you want to change?: ");
                        double newSalary = Double.parseDouble(scanner.nextLine());
                        employees.get(positionEdit).setEmployeeSalary(newSalary);
                        System.out.println("Edit Salary successfully!");
                        System.out.println("---------------------------");
                    case 10:
                        return;
                    default:
                        System.out.println("Wrong input!");
                }
            }
        }
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
        String employeePhoneNumber = scanner.nextLine();
        System.out.print("Input employee's email address: ");
        String employeeEmail = scanner.nextLine();
        System.out.print("Input employee's id: ");
        String employeeId = scanner.nextLine();

        String employeeQualifications = "";
        while (temp) {
            System.out.print("Input employee's qualifications:\n" +
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

        temp = true;
        String employeePosition = "";
        while (temp) {
            System.out.print("Input employee's position:\n" +
                    "1. Receptionist\n" +
                    "2. Housekeeper\n" +
                    "3. Expert\n" +
                    "4. Supervisor\n" +
                    "5. Hotel manager\n" +
                    "6. Manager\n");
            System.out.print("Input your choice here: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    employeePosition = "Receptionist";
                    temp = false;
                    break;
                case 2:
                    employeePosition = "Housekeeper";
                    temp = false;
                    break;
                case 3:
                    employeePosition = "Expert";
                    temp = false;
                    break;
                case 4:
                    employeePosition = "Supervisor";
                    temp = false;
                    break;
                case 5:
                    employeePosition = "Hotel manager";
                    temp = false;
                    break;
                case 6:
                    employeePosition = "Manager";
                    temp = false;
                    break;
                default:
                    System.out.println("------------------------");
                    System.out.println("Wrong input!, try again");
            }
        }


        System.out.print("Input employee's salary: ");
        double employeeSalary = Double.parseDouble(scanner.nextLine());

        return new Employee(employeeName, employeeBirthday, employeeGender, employeeCitizenIdentityNumber,
                employeePhoneNumber, employeeEmail, employeeId, employeeQualifications, employeePosition, employeeSalary);
    }

    @Override
    public Employee findEmployeeToEdit() {
        System.out.print("Input Employee ID: ");
        String idFind = scanner.nextLine();

        for (Employee employee : employees) {
            if (employee.getId().equals(idFind)) {
                return employee;
            }
        }
        return null;
    }
}
