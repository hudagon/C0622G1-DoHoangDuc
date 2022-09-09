package services.impl;

import models.creatures.Employee;
import services.IEmployeeService;
import utils.exception.*;
import utils.read_write_file.read_write_employee.ReadFileEmployee;
import utils.read_write_file.read_write_employee.WriteFileEmployee;
import utils.validation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static final String PATH = "src\\data\\employee.csv";
    Scanner scanner = new Scanner(System.in);
    private List<Employee> employees = ReadFileEmployee.readEmployeeFile(PATH);
    boolean temp = true;
    int choice;

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
        Employee employeeEdit = this.findEmployee();
        int positionEdit = employees.indexOf(employeeEdit);
        int choiceEdit;
        if (employeeEdit == null) {
            System.out.println("Can't found employee to edit");
        } else {
            while (true) {

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
                choiceEdit = Integer.parseInt(scanner.nextLine());
                switch (choiceEdit) {
                    case 1:
                        System.out.print("How do you want to change?: ");
                        String newName = scanner.nextLine();
                        employees.get(positionEdit).setName(newName);
                        System.out.println("Edit name successfully!");
                        WriteFileEmployee.writeEmployeeFile(PATH, false,employees);
                        System.out.println("---------------------------");
                        break;
                    case 2:
                        System.out.print("How do you want to change?: ");
                        String newBirthday = scanner.nextLine();
                        employees.get(positionEdit).setBirthday(newBirthday);
                        System.out.println("Edit birthday successfully!");
                        WriteFileEmployee.writeEmployeeFile(PATH, false,employees);
                        System.out.println("---------------------------");
                        break;
                    case 3:
                        System.out.print("How do you want to change?: ");
                        String newGender = scanner.nextLine();
                        employees.get(positionEdit).setGender(newGender);
                        System.out.println("Edit gender successfully!");
                        WriteFileEmployee.writeEmployeeFile(PATH, false,employees);
                        System.out.println("---------------------------");
                        break;
                    case 4:
                        System.out.print("How do you want to change?: ");
                        int newCitizenIdentifyNumber = Integer.parseInt(scanner.nextLine());
                        employees.get(positionEdit).setCitizenIdentityNumber(newCitizenIdentifyNumber);
                        System.out.println("Edit Citizen identity number successfully!");
                        WriteFileEmployee.writeEmployeeFile(PATH, false,employees);
                        System.out.println("---------------------------");
                        break;
                    case 5:
                        System.out.print("How do you want to change?: ");
                        String newPhoneNumber = scanner.nextLine();
                        employees.get(positionEdit).setPhoneNumber(newPhoneNumber);
                        System.out.println("Edit phone number successfully!");
                        WriteFileEmployee.writeEmployeeFile(PATH, false,employees);
                        System.out.println("---------------------------");
                        break;
                    case 6:
                        System.out.print("How do you want to change?: ");
                        String newID = scanner.nextLine();
                        employees.get(positionEdit).setId(newID);
                        System.out.println("Edit ID successfully!");
                        WriteFileEmployee.writeEmployeeFile(PATH, false,employees);
                        System.out.println("---------------------------");
                        break;
                    case 7:
                        System.out.print("How do you want to change?: ");
                        String newQualification = scanner.nextLine();
                        employees.get(positionEdit).setEmployeeQualifications(newQualification);
                        System.out.println("Edit qualifications successfully!");
                        WriteFileEmployee.writeEmployeeFile(PATH, false,employees);
                        System.out.println("---------------------------");
                        return;
                    case 8:
                        System.out.print("How do you want to change?: ");
                        String newPosition = scanner.nextLine();
                        employees.get(positionEdit).setEmployeePosition(newPosition);
                        System.out.println("Edit position successfully!");
                        WriteFileEmployee.writeEmployeeFile(PATH, false,employees);
                        System.out.println("---------------------------");
                        break;
                    case 9:
                        System.out.print("How do you want to change?: ");
                        double newSalary = Double.parseDouble(scanner.nextLine());
                        employees.get(positionEdit).setEmployeeSalary(newSalary);
                        System.out.println("Edit Salary successfully!");
                        WriteFileEmployee.writeEmployeeFile(PATH, false,employees);
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
    public void delete() {
        employees = ReadFileEmployee.readEmployeeFile(PATH);
        Employee employeeToDelete = this.findEmployee();

        if (employeeToDelete == null) {
            System.out.println("Can't find employee to delete");
        } else {
            while (temp) {
                System.out.print("Do you want to delete this employee?\n" +
                        "1. Yes\n" +
                        "2. No\n" +
                        "Input here: ");
                try {
                    choice = Integer.parseInt(scanner.nextLine());

                    switch (choice) {
                        case 1:
                            employees.removeIf(x -> x.getId().equals(employeeToDelete.getId()));
                            System.out.println("Delete successfully!");
                            temp = false;
                            WriteFileEmployee.writeEmployeeFile(PATH, false,employees);
                            break;
                        case 2:
                            return;
                        default:
                            System.out.println("Wrong input!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input, you must enter a number");
                } catch (Exception e) {
                    System.out.println("Something went wrong");
                }
            }
        }
    }

    @Override
    public Employee getEmployeeInfo() {
        String employeeName = "";
        while (true) {
            try {
                System.out.print("Input employee's name: ");
                employeeName = scanner.nextLine();
                employeeName = employeeName.trim();
                if (!employeeName.matches(NameRegex.NAME_REGEX) && !employeeName.matches("\\D{5,50}")) {
                    throw new InvaildNameInputException("Invalid employee name, please try again");
                }
                break;
            } catch (InvaildNameInputException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Something went wrong!");
            }
        }

        String employeeBirthday = "";
        Date currentTime = new Date();
        Date employeeBirthday1;
        while (true) {
            System.out.print("Input employee's birthday: ");
            try {
                employeeBirthday = scanner.nextLine();
                if (!employeeBirthday.matches(BirthdayRegex.BIRTHDAY_REGEX)) {
                    throw new InvaildBirthdayException("Invalid birthday format, please input dd/MM/yyyy");
                }

                employeeBirthday1 = dateFormat.parse(employeeBirthday);
                if (currentTime.getYear() - employeeBirthday1.getYear() > 100) {
                    throw new IllegalAgeException("Employee must be between 18 and 100 years old");
                }

                employeeBirthday1.setYear(employeeBirthday1.getYear() + 18);
                if (employeeBirthday1.compareTo(currentTime) > 0) {
                    throw new IllegalAgeException("Employee must be between 18 and 100 years old");
                }

                break;
            } catch (InvaildBirthdayException | IllegalAgeException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Something went wrong!");
            }
        }

        String employeeGender = "";
        while (true) {
            System.out.print("Input employee's gender: ");
            try {
                employeeGender = scanner.nextLine();
                if (!employeeGender.matches(GenderRegex.GENDER_REGEX)) {
                    throw new InvaildGenderException("Please input Male or Female or neither");
                }
                break;
            } catch (InvaildGenderException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Something went wrong!");
            }
        }

        String employeeCitizenIdentityNumber1 = "";
        while (true) {
            System.out.print("Input employee's citizen identity number: ");
            try {
                employeeCitizenIdentityNumber1 = scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Something went wrong!");
            }
        }
        int employeeCitizenIdentityNumber = Integer.parseInt(employeeCitizenIdentityNumber1);

        String employeePhoneNumber1 = "";
        while (true) {
            System.out.print("Input employee's phone number: ");
            try {
                employeePhoneNumber1 = scanner.nextLine();
                if (!employeePhoneNumber1.matches(PhoneNumberRegex.PHONE_NUMBER_REGEX)) {
                    throw new InvaildPhoneNumberException("Please enter a valid phone number!");
                }
                break;
            } catch (InvaildPhoneNumberException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Something went wrong!");
            }
        }
        String employeePhoneNumber = employeePhoneNumber1;

        String employeeEmail = "";
        while (true) {
            System.out.print("Input employee's email address: ");
            try {
                employeeEmail = scanner.nextLine();
                if (!employeeEmail.matches(EmailRegex.EMAIL_REGEX)) {
                    throw new InvaildEmailException("Please enter a valid email address");
                }
                break;
            } catch (InvaildEmailException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Something went wrong!");
            }
        }

        String employeeId;
        while (true) {
            try {
                System.out.print("Input employee's id: ");
                employeeId = scanner.nextLine();
                if (!employeeId.matches(EmployeeIdRegex.EMPLOYEE_ID_REGEX)) {
                    throw new InvaildIdInputException("The employee id must be 'NVXXX' format");
                }
                break;
            } catch (InvaildIdInputException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Something went wrong!");
            }
        }

        String employeeQualifications = "";
        temp = true;
        while (temp) {
            System.out.print("Input employee's qualifications:\n" +
                    "1. University\n" +
                    "2. College\n" +
                    "3. Intermediate\n" +
                    "4. Post-Graduate\n");
            System.out.print("Input your choice here: ");
            while (true) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("You input String type not number try again!");
                } catch (Exception e) {
                    System.out.println("Something went wrong!");
                }
            }

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

        String employeePosition = "";
        temp = true;
        while (temp) {
            System.out.print("Input employee's position:\n" +
                    "1. Receptionist\n" +
                    "2. Housekeeper\n" +
                    "3. Expert\n" +
                    "4. Supervisor\n" +
                    "5. Hotel manager\n" +
                    "6. Manager\n");
            System.out.print("Input your choice here: ");
            while (true) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("You input String type not number try again!");
                } catch (Exception e) {
                    System.out.println("Something went wrong!");
                }
            }

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

        double employeeSalary;
        while (true) {
            System.out.print("Input employee's salary: ");
            try {
                employeeSalary = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Something went wrong!");
            }
        }

        return new Employee(employeeName, employeeBirthday, employeeGender, employeeCitizenIdentityNumber,
                employeePhoneNumber, employeeEmail, employeeId, employeeQualifications, employeePosition, employeeSalary);
    }

    @Override
    public Employee findEmployee() {
        employees = ReadFileEmployee.readEmployeeFile(PATH);
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
