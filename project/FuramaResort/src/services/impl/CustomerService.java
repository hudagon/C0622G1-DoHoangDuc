package services.impl;

import models.creatures.Customer;
import models.creatures.Employee;
import services.ICustomerService;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    Scanner scanner = new Scanner(System.in);
    private static List<Customer> customers = new LinkedList<>();

    static {
        customers.add(new Customer("Nguyễn Văn A", "1/1/2000", "Nam", 111222333, 123123123, "a@gmail.com", "KH001", "Diamond", "abc"));
        customers.add(new Customer("Nguyễn Văn B", "1/1/2000", "Nam", 456456456, 444555666, "b@gmail.com", "KH002", "Silver", "bcd"));
        customers.add(new Customer("Nguyễn Thị C", "1/1/2000", "Nữ", 789789789, 777888999, "c@gmail.com", "KH003", "Gold", "efk"));
    }

    @Override
    public void display() {
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }

    @Override
    public void add() {
        customers.add(this.getCustomerInfo());
        System.out.println("New customer added successfully!");
    }

    @Override
    public void edit() {
        Customer customerEdit = this.findCustomerToEdit();
        if (customerEdit == null) {
            System.out.println("Can't found customer to edit");
        } else {
            while (true) {
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
                        int newPhoneNumber = Integer.parseInt(scanner.nextLine());
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
    }

    @Override
    public Customer getCustomerInfo() {
        System.out.print("Input customer's name: ");
        String customerName = scanner.nextLine();
        System.out.print("Input customer's birthday': ");
        String customerBirthday = scanner.nextLine();
        System.out.print("Input customer's gender: ");
        String customerGender = scanner.nextLine();
        System.out.print("Input customer's citizen identity number: ");
        int customerCitizenIdentityNumber = Integer.parseInt(scanner.nextLine());
        System.out.print("Input customer's phone number: ");
        int customerPhoneNumber = Integer.parseInt(scanner.nextLine());
        System.out.print("Input customer's email address: ");
        String customerEmail = scanner.nextLine();
        System.out.print("Input customer's id: ");
        String customerId = scanner.nextLine();

        String customerClassification = "";
        boolean temp = true;
        while (temp) {
            System.out.print("Input customer's classification:\n" +
                    "1. Diamond\n" +
                    "2. Platinum\n" +
                    "3. Gold\n" +
                    "4. Silver\n" +
                    "5. Member\n");
            System.out.print("Input your choice here: ");
            int choice = Integer.parseInt(scanner.nextLine());
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

        System.out.print("Input custom's address: ");
        String customerAddress = scanner.nextLine();

        return new Customer(customerName, customerBirthday, customerGender, customerCitizenIdentityNumber,
                customerPhoneNumber, customerEmail, customerId, customerClassification, customerAddress);
    }

    @Override
    public Customer findCustomerToEdit() {
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
