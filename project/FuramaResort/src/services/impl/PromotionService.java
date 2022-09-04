package services.impl;

import models.things.Booking;
import models.things.Voucher;
import services.IPromotionSerivce;

import java.time.LocalDate;
import java.util.*;

public class PromotionService implements IPromotionSerivce {
    BookingService bookingService = new BookingService();
    Scanner scanner = new Scanner(System.in);
    int currentMonth = LocalDate.now().getMonthValue();
    Set<Booking> customersUsedService = bookingService.getBookings();
    Stack<Voucher> vouchers = new Stack();


    @Override
    public void displayCustomersUseService() {
        System.out.print("Input the year you want to display all customers who used services: ");
        int yearToDisplay = Integer.parseInt(scanner.nextLine());

        List<Booking> listToDisplay1 = new LinkedList<>();
        for (Booking x : customersUsedService) {
            if (x.getStartDate().getYear() == yearToDisplay - 1900) {
                listToDisplay1.add(x);
            }
        }

        if (listToDisplay1.size() > 0) {
            for (Booking x : listToDisplay1) {
                System.out.println(x.toString());
            }
        } else {
            System.out.println("Nothing to display");
        }
    }

    @Override
    public void displayCustomersGetVoucher() {
        Stack<Booking> listToDisplay2 = new Stack<>();
        for (Booking x : customersUsedService) {
            if (x.getStartDate().getMonth() == currentMonth - 1) {
                listToDisplay2.add(x);
            }
        }

        boolean temp = true;
        while (temp) {
            temp = false;
            System.out.println("There are " + listToDisplay2.size() + " customers available for getting a vouchers this month.");
            System.out.println("Please input total number vouchers equal to total number of customers.");
            System.out.print("Input numbers of 10% voucher: ");
            int voucher1 = Integer.parseInt(scanner.nextLine());
            System.out.print("Input numbers of 20% voucher: ");
            int voucher2 = Integer.parseInt(scanner.nextLine());
            System.out.print("Input numbers of 50% voucher: ");
            int voucher3 = Integer.parseInt(scanner.nextLine());

            if (voucher1 + voucher2 + voucher3 != listToDisplay2.size()) {
                System.out.println("2 values are not equal!, try again!");
                temp = true;
            } else {
                for (int i = 0; i < voucher3; i++) {
                    vouchers.add(new Voucher("50%"));
                }

                for (int i = 0; i < voucher2; i++) {
                    vouchers.add(new Voucher("20%"));
                }

                for (int i = 0; i < voucher1; i++) {
                    vouchers.add(new Voucher("10%"));
                }
            }
        }

        for (int i = 0; i < listToDisplay2.size(); i++) {
            System.out.println("Customer " + listToDisplay2.pop().getCustomerId() + " is gonna get a " + vouchers.pop().toString());
            i--;
        }
    }
}
