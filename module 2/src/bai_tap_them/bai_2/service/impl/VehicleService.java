package bai_tap_them.bai_2.service.impl;

import bai_tap_them.bai_2.model.Vehicle;
import bai_tap_them.bai_2.service.IVehicleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static bai_tap_them.bai_2.service.impl.MotorcycleService.motorcycles;
import static bai_tap_them.bai_2.service.impl.TruckService.truckes;
import static bai_tap_them.bai_2.service.impl.CarService.cars;

public class VehicleService implements IVehicleService {
    Scanner scanner = new Scanner(System.in);
    static List<Vehicle> vehicleList = new ArrayList<>();


    @Override
    public void deleteVehicle() {
        Vehicle vehicleDelete = this.findVehicle();
        if (vehicleDelete == null) {
            System.out.println("Không tìm thấy biển số xe!");
        } else {
            System.out.print("Bạn có chắc chắn muốn xóa không? 1. Có 2. Không: ");
            int choiceDelete = Integer.parseInt(scanner.nextLine());

            if (choiceDelete == 1) {
                vehicleList.remove(vehicleDelete);
                int truckDeleteIndex = TruckService.findVehicleIndex(vehicleDelete.getLicensePlate());
                int motorcycleDeleteIndex = TruckService.findVehicleIndex(vehicleDelete.getLicensePlate());
                int carDeleteIndex = TruckService.findVehicleIndex(vehicleDelete.getLicensePlate());

                if (truckDeleteIndex > -1) {
                    truckes.remove(truckDeleteIndex);
                }
                if (motorcycleDeleteIndex > -1) {
                    motorcycles.remove(motorcycleDeleteIndex);
                }
                if (carDeleteIndex > -1) {
                    cars.remove(carDeleteIndex);
                }

                System.out.println("Xóa thành công");
            }
        }
    }

    public Vehicle findVehicle() {
        System.out.print("Nhập biển số xe của phương tiện bạn muốn thao tác: ");
        String idFind = scanner.nextLine();

        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getLicensePlate().equals(idFind)) {
                return vehicle;
            }
        }
        return null;
    }

    @Override
    public void findVehicleLicensePlate() {
        System.out.print("Xin mời nhập biển số xe phương tiện bạn muốn tìm kiếm: ");
        String licensePlateFind = scanner.nextLine();

        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getLicensePlate().contains(licensePlateFind)) {
                System.out.println(vehicle.toString());
            }
        }
    }
}
