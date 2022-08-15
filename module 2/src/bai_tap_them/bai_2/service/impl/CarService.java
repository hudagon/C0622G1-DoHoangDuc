package bai_tap_them.bai_2.service.impl;

import bai_tap_them.bai_2.model.Car;
import bai_tap_them.bai_2.model.Manufactor;
import bai_tap_them.bai_2.service.ICarService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarService implements ICarService {
    Scanner scanner = new Scanner(System.in);
    static List<Car> cars = new ArrayList<>();

    @Override
    public void addCar() {
        System.out.print("Nhập biển số xe: ");
        String licensePlate = scanner.nextLine();

        System.out.print("Nhập hãng sản xuất (CompanyA, CompanyB, CompanyC): ");
        String manufacturer = scanner.nextLine();
        Manufactor company;
        if (manufacturer.equals("CompanyA")) {
            company = ManufactorService.factories.get(1);
        } else if (manufacturer.equals("CompanyB")) {
            company = ManufactorService.factories.get(2);
        } else {
            company = ManufactorService.factories.get(3);
        }


        System.out.print("Nhập năm sản xuất: ");
        int yearOfProduction = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập chủ sở hữu: ");
        String onwer = scanner.nextLine();
        System.out.print("Nhập số chỗ ngồi: ");
        int seat = Integer.parseInt(scanner.nextLine());

        cars.add(new Car(licensePlate, company, yearOfProduction, onwer, seat));

        VehicleService.vehicleList.add(new Car(licensePlate, company, yearOfProduction, onwer, seat));

        System.out.println("Thêm mới thành công");
    }

    @Override
    public void display() {
        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }

    public static int findVehicleIndex (String lp) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getLicensePlate().equals(lp)) {
                return i;
            }
        }
        return -1;
    }
    

}
