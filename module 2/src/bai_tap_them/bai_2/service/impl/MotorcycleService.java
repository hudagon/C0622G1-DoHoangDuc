package bai_tap_them.bai_2.service.impl;

import bai_tap_them.bai_2.model.Car;
import bai_tap_them.bai_2.model.Manufactor;
import bai_tap_them.bai_2.model.Motorcycle;
import bai_tap_them.bai_2.service.IMotorcycleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MotorcycleService implements IMotorcycleService {
    Scanner scanner = new Scanner(System.in);
    static List<Motorcycle> motorcycles = new ArrayList<>();

    @Override
    public void addMotorcycle() {
        System.out.print("Nhập biển số xe: ");
        String licensePlate = scanner.nextLine();

        System.out.print("Nhập hãng sản xuất (CompanyA, CompanyB, CompanyC): ");
        String manufacturer = scanner.nextLine();
        Manufactor company = null;
        switch (manufacturer) {
            case "CompanyA":
                company = ManufactorService.factories.get(0);
                break;
            case "CompanyB":
                company = ManufactorService.factories.get(1);
                break;
            case "CompanyC":
                company = ManufactorService.factories.get(2);
                break;
        }


        System.out.print("Nhập năm sản xuất: ");
        int yearOfProduction = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập chủ sở hữu: ");
        String onwer = scanner.nextLine();
        System.out.print("Nhập số công suất: ");
        int wattage = Integer.parseInt(scanner.nextLine());

        motorcycles.add(new Motorcycle(licensePlate, company, yearOfProduction, onwer, wattage));

        VehicleService.vehicleList.add(new Motorcycle(licensePlate, company, yearOfProduction, onwer, wattage));

        System.out.println("Thêm mới thành công");
    }

    @Override
    public void display() {
        for (Motorcycle motorcycle : motorcycles) {
            System.out.println(motorcycle.toString());
        }
    }

    public static int findVehicleIndex (String lp) {
        for (int i = 0; i < motorcycles.size(); i++) {
            if (motorcycles.get(i).getLicensePlate().equals(lp)) {
                return i;
            }
        }
        return -1;
    }

}
