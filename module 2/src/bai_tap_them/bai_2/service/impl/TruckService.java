package bai_tap_them.bai_2.service.impl;

import bai_tap_them.bai_2.model.Car;
import bai_tap_them.bai_2.model.Manufactor;
import bai_tap_them.bai_2.model.Motorcycle;
import bai_tap_them.bai_2.model.Truck;
import bai_tap_them.bai_2.service.ITruckService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TruckService implements ITruckService {
    static Scanner scanner = new Scanner(System.in);
    static List<Truck> truckes = new ArrayList<>();

    @Override
    public void addTruck() {
        System.out.print("Nhập biển số xe: ");
        String licensePlate = scanner.nextLine();

        System.out.print("Nhập hãng sản xuất (CompanyA, CompanyB, CompanyC): ");
        String manufacturer = scanner.nextLine();
        Manufactor company = null;
        switch (manufacturer) {
            case "CompanyA":
                company = ManufactorService.factories.get(1);
                break;
            case "CompanyB":
                company = ManufactorService.factories.get(2);
                break;
            case "CompanyC":
                company = ManufactorService.factories.get(3);
                break;
        }


        System.out.print("Nhập năm sản xuất: ");
        int yearOfProduction = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập chủ sở hữu: ");
        String onwer = scanner.nextLine();
        System.out.print("Nhập số trọng tải: ");
        double payload = Double.parseDouble(scanner.nextLine());

        truckes.add(new Truck(licensePlate, company, yearOfProduction, onwer, payload));

        VehicleService.vehicleList.add(new Truck(licensePlate, company, yearOfProduction, onwer, payload));

        System.out.println("Thêm mới thành công");
    }

    @Override
    public void display() {
        for (Truck trucke : truckes) {
            System.out.println(trucke.toString());
        }
    }

    public static int findVehicleIndex (String lp) {
        for (int i = 0; i < truckes.size(); i++) {
            if (truckes.get(i).getLicensePlate().equals(lp)) {
                return i;
            }
        }
        return -1;
    }

}
