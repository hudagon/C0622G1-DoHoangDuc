package services.impl;

import models.things.Booking;
import models.things.Contract;
import services.IContractService;

import java.util.*;

public class ContractService implements IContractService {
    Scanner scanner = new Scanner(System.in);
    static List<Contract> contracts = new ArrayList<>();
    static List<Booking> bookingsUseToMakeContracts = new LinkedList<>(BookingService.getBookings());

    @Override
    public void display() {
        if (contracts.isEmpty()) {
            System.out.println("Nothing to display!");
        } else {
            for (Contract x : contracts) {
                System.out.println(x.toString());
            }
        }
    }

    @Override
    public void editContract() {
        Contract contractEdit = this.findContractToEdit();
        if (contractEdit == null) {
            System.out.println("Can't found contract to edit");
        } else {
            while (true) {
                int positionEdit = contracts.indexOf(contractEdit);
                System.out.print("What information do you want to edit?\n" +
                        "1. Contract number\n" +
                        "2. Deposit\n" +
                        "3. Total payment\n" +
                        "4. Exit\n" +
                        "--> Input here: ");
                int choiceEdit = Integer.parseInt(scanner.nextLine());

                switch (choiceEdit) {
                    case 1:
                        System.out.print("How do you want to change?: ");
                        int newContractNumber = Integer.parseInt(scanner.nextLine());
                        contracts.get(positionEdit).setContractNumber(newContractNumber);
                        System.out.println("Edit contract number successfully!");
                        System.out.println("---------------------------");
                        break;
                    case 2:
                        System.out.print("How do you want to change?: ");
                        double newDeposit = Double.parseDouble(scanner.nextLine());
                        contracts.get(positionEdit).setDeposit(newDeposit);
                        System.out.println("Edit deposit successfully!");
                        System.out.println("---------------------------");
                        break;
                    case 3:
                        System.out.print("How do you want to change?: ");
                        double totalPaymentEdit = Double.parseDouble(scanner.nextLine());
                        contracts.get(positionEdit).setTotalPayment(totalPaymentEdit);
                        System.out.println("Edit total payment successfully!");
                        System.out.println("---------------------------");
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Wrong input!");
                }
            }
        }
    }

    @Override
    public void add() {
        System.out.println("Only the earliest booking can be created into contract, do you want to continue?\n" +
                "1. Yes\n" +
                "2. No");
        System.out.print("Input here: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                contracts.add(getContractInfo());
                System.out.println("New contract added successfully!");
            case 2:
                break;
            default:
                System.out.println("Invalid input!");
        }
    }

    @Override
    public Contract getContractInfo() {
        System.out.print("Input contract number: ");
        int contractNumber = Integer.parseInt(scanner.nextLine());
        System.out.print("Input deposit: ");
        double deposit = Double.parseDouble(scanner.nextLine());
        System.out.print("Input customer total payment: ");
        double customerTotalPayment = Double.parseDouble(scanner.nextLine());

        Booking bookingToCreateContract = bookingsUseToMakeContracts.remove(bookingsUseToMakeContracts.size() - 1);
        String bookingCode = bookingToCreateContract.getBookingCode();
        String customerId = bookingToCreateContract.getCustomerId();

        return new Contract(contractNumber, bookingCode, deposit, customerTotalPayment, customerId);
    }

    @Override
    public Contract findContractToEdit() {
        System.out.print("Do you want to edit by customer ID or contract number?\n" +
                "1. Customer ID\n" +
                "2. Contract Number\n" +
                "3. Exit\n" +
                "Input here: ");
        int choice = Integer.parseInt(scanner.nextLine());
        Contract contractToEdit = null;
        switch (choice) {
            case 1:
                System.out.print("Input customer ID: ");
                String customerIdToEdit = scanner.nextLine();

                for (Contract x : contracts) {
                    if (customerIdToEdit.equals(x.getCustomerId())) {
                        contractToEdit = x;
                    }
                }
                break;
            case 2:
                System.out.print("Input contract number: ");
                int contractNumberToEdit = Integer.parseInt(scanner.nextLine());

                for (Contract x : contracts) {
                    if (contractNumberToEdit == (x.getContractNumber())) {
                        contractToEdit = x;
                    }
                }
                break;
            case 3:
                contractToEdit = null;
                break;
            default:
                System.out.println("Invalid input!");
        }
        return contractToEdit;
    }
}
