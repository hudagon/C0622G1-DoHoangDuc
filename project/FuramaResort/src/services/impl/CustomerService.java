package services.impl;

import models.creatures.Customer;
import services.ICustomerService;
import utils.exception.*;
import utils.read_write_file.read_write_customer.ReadFileCustomer;
import utils.read_write_file.read_write_customer.WriteFileCustomer;
import utils.validation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static final String PATH = "src\\data\\customer.csv";
    Scanner scanner = new Scanner(System.in);
    private List<Customer> customers = new LinkedList<>();

    @Override
    public void display() {
        customers = ReadFileCustomer.readFileCustomer(PATH);
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }

    @Override
    public void add() {
        customers = ReadFileCustomer.readFileCustomer(PATH);
        customers.add(this.getCustomerInfo());
        System.out.println("New customer added successfully!");
        WriteFileCustomer.writeFileCustomer(PATH, customers);
    }

    @Override
    public void edit() {
        customers = ReadFileCustomer.readFileCustomer(PATH);
        Customer customerEdit = this.findCustomerToEdit();
        if (customerEdit == null) {
            System.out.println("Can't found customer to edit");
        } else {
            while (true) {
                customers = ReadFileCustomer.readFileCustomer(PATH);
                int positionEdit = customers.indexOf(customerEdit);
                System.out.print("What information do you want to edit?\n" +
                        "1. Name\n" +
                        "2. Birthday\n" +
                        "3. Gender\n" +
                        "4. Citizen identity number\n" +
                        "5. Phone number\n" +
                        "6. Employee ID\n" +
                        "7. Customer classification\n" +
                        "8. Customer address\n" +
                        "9. Exit\n" +
                        "--> Input here: ");
                int choiceEdit = Integer.parseInt(scanner.nextLine());

                switch (choiceEdit) {
                    case 1:
                        System.out.print("How do you want to change?: ");
                        String newName = scanner.nextLine();
                        customers.get(positionEdit).setName(newName);
                        System.out.println("Edit name successfully!");
                        System.out.println("---------------------------");
                        break;
                    case 2:
                        System.out.print("How do you want to change?: ");
                        String newBirthday = scanner.nextLine();
                        customers.get(positionEdit).setBirthday(newBirthday);
                        System.out.println("Edit birthday successfully!");
                        System.out.println("---------------------------");
                        break;
                    case 3:
                        System.out.print("How do you want to change?: ");
                        String newGender = scanner.nextLine();
                        customers.get(positionEdit).setGender(newGender);
                        System.out.println("Edit gender successfully!");
                        System.out.println("---------------------------");
                        break;
                    case 4:
                        System.out.print("How do you want to change?: ");
                        int newCitizenIdentifyNumber = Integer.parseInt(scanner.nextLine());
                        customers.get(positionEdit).setCitizenIdentityNumber(newCitizenIdentifyNumber);
                        System.out.println("Edit Citizen identity number successfully!");
                        System.out.println("---------------------------");
                        break;
                    case 5:
                        System.out.print("How do you want to change?: ");
                        String newPhoneNumber = scanner.nextLine();
                        customers.get(positionEdit).setPhoneNumber(newPhoneNumber);
                        System.out.println("Edit phone number successfully!");
                        System.out.println("---------------------------");
                        break;
                    case 6:
                        System.out.print("How do you want to change?: ");
                        String newID = scanner.nextLine();
                        customers.get(positionEdit).setId(newID);
                        System.out.println("Edit ID successfully!");
                        System.out.println("---------------------------");
                        break;
                    case 7:
                        System.out.print("How do you want to change?: ");
                        String newClassification = scanner.nextLine();
                        customers.get(positionEdit).setCustomerClassification(newClassification);
                        System.out.println("Edit qualifications successfully!");
                        System.out.println("---------------------------");
                        return;
                    case 8:
                        System.out.print("How do you want to change?: ");
                        String newAddress = scanner.nextLine();
                        customers.get(positionEdit).setAddress(newAddress);
                        System.out.println("Edit address successfully!");
                        System.out.println("---------------------------");
                    case 9:
                        return;
                    default:
                        System.out.println("Wrong input!");
                }
            }
        }
        WriteFileCustomer.writeFileCustomer(PATH, customers);
    }

    @Override
    public Customer getCustomerInfo() {
        customers = ReadFileCustomer.readFileCustomer(PATH);
        String customerName = "";
        while (true) {
            try {
                System.out.print("Input customer's name: ");
                customerName = scanner.nextLine();
                customerName = customerName.trim();
                if (!customerName.matches(NameRegex.NAME_REGEX) && !customerName.matches("\\D{5,50}")) {
                    throw new InvaildNameInputException("Invalid customer name, please try again");
                }
                break;
            } catch (InvaildNameInputException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Something went wrong!");
            }
        }

        String customerBirthday = "";
        Date currentTime = new Date();
        Date customerBirthday1;
        while (true) {
            System.out.print("Input customer's birthday: ");
            try {
                customerBirthday = scanner.nextLine();
                if (!customerBirthday.matches(BirthdayRegex.BIRTHDAY_REGEX)) {
                    throw new InvaildBirthdayException("Invalid birthday format, please input dd/MM/yyyy");
                }

                customerBirthday1 = dateFormat.parse(customerBirthday);
                if (currentTime.getYear() - customerBirthday1.getYear() > 100) {
                    throw new IllegalAgeException("Employee must be between 18 and 100 years old");
                }

                customerBirthday1.setYear(customerBirthday1.getYear() + 18);
                if (customerBirthday1.compareTo(currentTime) > 0) {
                    throw new IllegalAgeException("Employee must be between 18 and 100 years old");
                }

                break;
            } catch (InvaildBirthdayException | IllegalAgeException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Something went wrong!");
            }
        }

        String customerGender = "";
        while (true) {
            System.out.println("Input customer's gender: ");
            try {
                customerGender = scanner.nextLine();
                if (!customerGender.matches(GenderRegex.GENDER_REGEX)) {
                    throw new InvaildGenderException("Please input Male or Female or neither");
                }
                break;
            } catch (InvaildGenderException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Something went wrong!");
            }
        }

        String customerCitizenIdentityNumber1 = "";
        while (true) {
            System.out.print("Input customer's citizen identity number: ");
            try {
                customerCitizenIdentityNumber1 = scanner.nextLine();
                if (!customerCitizenIdentityNumber1.matches(CitizenIdentityNumberRegex.CITIZEN_IDENTITY_NUMBER_REGEX)) {
                    throw new InvaildGenderException("Please input Male or Female or neither");
                }
                break;
            } catch (InvaildGenderException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Something went wrong!");
            }
        }
        int customerCitizenIdentityNumber = Integer.parseInt(customerCitizenIdentityNumber1);

        String customerPhoneNumber1 = "";
        while (true) {
            System.out.print("Input customer's phone number: ");
            try {
                customerPhoneNumber1 = scanner.nextLine();
                if (!customerPhoneNumber1.matches(PhoneNumberRegex.PHONE_NUMBER_REGEX)) {
                    throw new InvaildPhoneNumberException("Please enter a valid phone number!");
                }
                break;
            } catch (InvaildPhoneNumberException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Something went wrong!");
            }
        }
        String customerPhoneNumber = customerPhoneNumber1;

        String customerEmail = "";
        while (true) {
            System.out.print("Input customer's email address: ");
            try {
                customerEmail = scanner.nextLine();
                if (!customerEmail.matches(EmailRegex.EMAIL_REGEX)) {
                    throw new InvaildEmailException("Please enter a valid email address");
                }
                break;
            } catch (InvaildEmailException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Something went wrong!");
            }
        }

        String customerId;
        while (true) {
            try {
                System.out.print("Input customer's id: ");
                customerId = scanner.nextLine();
                if (!customerId.matches(CustomerIdRegex.CUSTOMER_ID_REGEX)) {
                    throw new InvaildIdInputException("The customer id must be 'KHXXX' format");
                }
                break;
            } catch (InvaildIdInputException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Something went wrong!");
            }
        }

        String customerClassification = "";
        boolean temp = true;
        int choice;
        while (temp) {
            System.out.print("Input customer's classification:\n" +
                    "1. Diamond\n" +
                    "2. Platinum\n" +
                    "3. Gold\n" +
                    "4. Silver\n" +
                    "5. Member\n");
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
                    customerClassification = "Diamond";
                    temp = false;
                    break;
                case 2:
                    customerClassification = "Platinum";
                    temp = false;
                    break;
                case 3:
                    customerClassification = "Gold";
                    temp = false;
                    break;
                case 4:
                    customerClassification = "Silver";
                    temp = false;
                    break;
                case 5:
                    customerClassification = "Member";
                default:
                    System.out.println("------------------------");
                    System.out.println("Wrong input!, try again");
            }
        }

        String customerAddress;
        while (true) {
            try {
                System.out.print("Input customer's address: ");
                customerAddress = scanner.nextLine();
                if (customerAddress.equals("")) {
                    throw new InvaildAddressException("Address can't be empty");
                }
                break;
            } catch (InvaildAddressException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Something went wrong!");
            }
        }

        return new Customer(customerName, customerBirthday, customerGender, customerCitizenIdentityNumber,
                customerPhoneNumber, customerEmail, customerId, customerClassification, customerAddress);
    }

    @Override
    public Customer findCustomerToEdit() {
        customers = ReadFileCustomer.readFileCustomer(PATH);
        System.out.print("Input Customer ID: ");
        String idFind = scanner.nextLine();

        for (Customer customer : customers) {
            if (customer.getId().equals(idFind)) {
                return customer;
            }
        }
        return null;
    }
}
