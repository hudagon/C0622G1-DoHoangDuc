package bai_tap_them.bai_2.controller;

import bai_tap_them.bai_2.model.Vehicle;
import bai_tap_them.bai_2.service.impl.CarService;
import bai_tap_them.bai_2.service.impl.MotorcycleService;
import bai_tap_them.bai_2.service.impl.TruckService;
import bai_tap_them.bai_2.service.impl.VehicleService;

import java.util.Scanner;

public class MainController {
    Scanner scanner = new Scanner(System.in);
    CarService carService = new CarService();
    TruckService truckService = new TruckService();
    MotorcycleService motorcycleService = new MotorcycleService();
    VehicleService vehicleService = new VehicleService();

    public void menuManagement() {

        while (true) {
            boolean temp = true;
            System.out.println("-------------------------------------------");
            System.out.println("CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG");
            System.out.print("Chọn chức năng:\n" +
                    "1. Thêm mới phương tiện.\n" +
                    "2. Hiển thị phương tiện\n" +
                    "3. Xóa phương tiện\n" +
                    "4. Tìm kiếm theo biển kiểm soát\n" +
                    "5. Thoát\n" +
                    "Xin mời nhập số ở đây: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    while (temp) {
                        System.out.println("--------------------------------------------");
                        System.out.print("Chọn loại phương tiện bạn muốn thao tác:\n" +
                                "1. Xe tải\n" +
                                "2. Xe ô tô\n" +
                                "3. Xe máy\n" +
                                "4. Thoát\n" +
                                "Xin mời nhập ở đây: ");
                        int choiceAdd = Integer.parseInt(scanner.nextLine());

                        switch (choiceAdd) {
                            case 1:
                                truckService.addTruck();
                                break;
                            case 2:
                                carService.addCar();
                                break;
                            case 3:
                                motorcycleService.addMotorcycle();
                                break;
                            case 4:
                                temp = false;
                                break;
                            default:
                                System.out.println("Số nhập không hợp lệ");
                        }

                    }
                    break;
                case 2:
                    while (temp) {
                        System.out.println("--------------------------------------------");
                        System.out.print("Chọn loại phương tiện bạn muốn thao tác:\n" +
                                "1. Xe tải\n" +
                                "2. Xe ô tô\n" +
                                "3. Xe máy\n" +
                                "4. Thoát\n" +
                                "Xin mời nhập ở đây: ");
                        int choiceDisplay = Integer.parseInt(scanner.nextLine());

                        switch (choiceDisplay) {
                            case 1:
                                truckService.display();
                                break;
                            case 2:
                                carService.display();
                                break;
                            case 3:
                                motorcycleService.display();
                                break;
                            case 4:
                                temp = false;
                                break;
                            default:
                                System.out.println("Số nhập không hợp lệ");
                        }
                    }
                    break;
                case 3:
                    while (temp) {
                        System.out.println("--------------------------------------------");
                        System.out.print("Bạn đang sử dụng dịch vụ xóa phương tiện:\n" +
                                "1. Tiếp tục\n" +
                                "2. Thoát\n" +
                                "Nhập ở đây: ");
                        int choiceDisplay = Integer.parseInt(scanner.nextLine());

                        if (choiceDisplay == 1) {
                            vehicleService.deleteVehicle();
                        } else {
                            temp = false;
                        }
                    }
                    break;
                case 4:
                    while (temp) {
                        System.out.println("--------------------------------------------");
                        System.out.print("Bạn đang sử dụng dịch vụ tìm kiếm phương tiện theo biển số xe:\n" +
                                "1. Tiếp tục\n" +
                                "2. Thoát\n" +
                                "Nhập ở đây: ");
                        int choiceDisplay = Integer.parseInt(scanner.nextLine());
                        if (choiceDisplay == 1) {
                            vehicleService.findVehicleLicensePlate();
                        } else {
                            temp = false;
                        }
                    }
                    break;

            }
        }
    }
}
