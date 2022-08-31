package services.impl;

import models.things.Facility;
import models.things.House;
import models.things.Room;
import models.things.Villa;
import services.IFacilityService;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class FacilityService implements IFacilityService {
    private static LinkedHashMap<Facility, Integer> facilities = new LinkedHashMap<>();
    private static LinkedHashMap<Facility, Integer> facilityMaintenanceList = new LinkedHashMap<>();

    static {
        facilities.put(new Villa("VILLA001", "Villa màu xanh", 500.0, 100.0, 8, "year", "4 stars", 100, 2), 0);
        facilities.put(new House("HOUSE001", "Nhà vườn", 750.0, 700.0, 10, "months", "4 stars", 2), 0);
        facilities.put(new Room("ROOM001", "Phòng tình yêu", 250.0, 150.0, 2, "days", "None"), 0);
        facilities.put(new Room("ROOM002", "Phòng gia đình", 250.0, 150.0, 2, "days", "None"), 0);
        for (Facility facility : facilities.keySet()) {
            if (facilities.get(facility) >= 5) {
                facilityMaintenanceList.put(facility, facilities.get(facility));
            }
        }
    }

    @Override
    public void display() {
        for (Facility facility : facilities.keySet()) {
            System.out.println(facility + " has been used: " + facilities.get(facility) + " times");
        }
    }

    @Override
    public void add() {
        Facility newFacility = this.getFacilityInfo();
        if (newFacility != null) {
            facilities.put(newFacility, 0);
            System.out.println("New facility added successfully!");
        } else {
            System.out.println("Can't accomplished task successfully!");
        }
    }

    @Override
    public Facility getFacilityInfo() {
        Scanner scanner = new Scanner(System.in);
        boolean temp = true;
        while (temp) {
            System.out.println("1. Get new villa information\n" +
                    "2. Get new house information\n" +
                    "3. Get new room information\n" +
                    "4. Back to menu\n");
            System.out.print("Input your choice here: ");
            int addFacilityChoice = Integer.parseInt(scanner.nextLine());

            switch (addFacilityChoice) {
                case 1:
                    boolean temp1 = true;
                    String villaServiceId = "";
                    while (temp1) {
                        temp1 = false;
                        System.out.print("Input villa id: ");
                        villaServiceId = scanner.nextLine();
                        for (Facility facility : facilities.keySet()) {
                            if (facility.getServiceId().equals(villaServiceId)) {
                                System.out.println("There is a facility with the same Id service, try again.");
                                temp1 = true;
                            }
                        }
                    }


                    System.out.print("Input villa name: ");
                    String villaServiceName = scanner.nextLine();
                    System.out.print("Input using area: ");
                    double villaUsingArea = Double.parseDouble(scanner.nextLine());
                    System.out.print("Input rental costs: ");
                    double villaRentalCosts = Double.parseDouble(scanner.nextLine());
                    System.out.print("Input max capacity: ");
                    int villaMaxCapacity = Integer.parseInt(scanner.nextLine());

                    String villaLeaseOptions = "";
                    while (temp) {
                        System.out.println("--------------------");
                        System.out.print("Choose lease options:\n" +
                                "1. Years\n" +
                                "2. Months\n" +
                                "3. Days\n" +
                                "4. Hours\n");
                        System.out.print("Input your choice here: ");
                        int choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                            case 1:
                                villaLeaseOptions = "Years";
                                temp = false;
                                break;
                            case 2:
                                villaLeaseOptions = "Months";
                                temp = false;
                                break;
                            case 3:
                                villaLeaseOptions = "Days";
                                temp = false;
                                break;
                            case 4:
                                villaLeaseOptions = "Hours";
                                temp = false;
                                break;
                            default:
                                System.out.println("------------------------");
                                System.out.println("Wrong input!, try again");
                        }
                    }

                    System.out.print("Input villa standard: ");
                    String villaStandard = scanner.nextLine();
                    System.out.print("Input swimming pool area: ");
                    double swimmingPoolArea = Double.parseDouble(scanner.nextLine());
                    System.out.print("Input villa's number of floors: ");
                    int villaNumberOfFloors = Integer.parseInt(scanner.nextLine());

                    return new Villa(villaServiceId, villaServiceName, villaUsingArea, villaRentalCosts, villaMaxCapacity, villaLeaseOptions, villaStandard, swimmingPoolArea, villaNumberOfFloors);

                case 2:
                    boolean temp2 = true;
                    String houseServiceId = "";
                    while (temp2) {
                        temp2 = false;
                        System.out.println("Input house id: ");
                        houseServiceId = scanner.nextLine();
                        for (Facility facility : facilities.keySet()) {
                            if (facility.getServiceId().equals(houseServiceId)) {
                                System.out.println("There is a facility with the same Id service, try again.");
                                temp2 = true;
                            }
                        }
                    }
                    System.out.print("Input house name: ");
                    String houseServiceName = scanner.nextLine();
                    System.out.print("Input using area: ");
                    double houseUsingArea = Double.parseDouble(scanner.nextLine());
                    System.out.print("Input rental costs: ");
                    double houseRentalCosts = Double.parseDouble(scanner.nextLine());
                    System.out.print("Input max capacity: ");
                    int houseMaxCapacity = Integer.parseInt(scanner.nextLine());

                    String leaseOptions = "";
                    while (temp) {
                        System.out.println("--------------------");
                        System.out.print("Choose lease options:\n" +
                                "1. Years\n" +
                                "2. Months\n" +
                                "3. Days\n" +
                                "4. Hours\n");
                        System.out.print("Input your choice here: ");
                        int choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                            case 1:
                                leaseOptions = "Years";
                                temp = false;
                                break;
                            case 2:
                                leaseOptions = "Months";
                                temp = false;
                                break;
                            case 3:
                                leaseOptions = "Days";
                                temp = false;
                                break;
                            case 4:
                                leaseOptions = "Hours";
                                temp = false;
                                break;
                            default:
                                System.out.println("------------------------");
                                System.out.println("Wrong input!, try again");
                        }
                    }

                    System.out.print("Input house standard: ");
                    String houseStandard = scanner.nextLine();
                    System.out.print("Input house's number of floors: ");
                    int houseNumberOfFloors = Integer.parseInt(scanner.nextLine());

                    return new House(houseServiceId, houseServiceName, houseUsingArea, houseRentalCosts, houseMaxCapacity, leaseOptions, houseStandard, houseNumberOfFloors);
                case 3:
                    boolean temp3 = true;
                    String roomServiceId = "";
                    while (temp3) {
                        temp3 = false;
                        System.out.println("Input room id: ");
                        roomServiceId = scanner.nextLine();
                        for (Facility facility : facilities.keySet()) {
                            if (facility.getServiceId().equals(roomServiceId)) {
                                System.out.println("There is a facility with the same Id service, try again.");
                                temp3 = true;
                            }
                        }
                    }
                    System.out.print("Input room name: ");
                    String roomServiceName = scanner.nextLine();
                    System.out.print("Input using area: ");
                    double roomUsingArea = Double.parseDouble(scanner.nextLine());
                    System.out.print("Input rental costs: ");
                    double roomRentalCosts = Double.parseDouble(scanner.nextLine());
                    System.out.print("Input max capacity: ");
                    int roomMaxCapacity = Integer.parseInt(scanner.nextLine());

                    String roomLeaseOptions = "";
                    while (temp) {
                        System.out.println("--------------------");
                        System.out.print("Choose lease options:\n" +
                                "1. Years\n" +
                                "2. Months\n" +
                                "3. Days\n" +
                                "4. Hours\n");
                        System.out.print("Input your choice here: ");
                        int choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                            case 1:
                                roomLeaseOptions = "Years";
                                temp = false;
                                break;
                            case 2:
                                roomLeaseOptions = "Months";
                                temp = false;
                                break;
                            case 3:
                                roomLeaseOptions = "Days";
                                temp = false;
                                break;
                            case 4:
                                roomLeaseOptions = "Hours";
                                temp = false;
                                break;
                            default:
                                System.out.println("------------------------");
                                System.out.println("Wrong input!, try again");
                        }
                    }

                    System.out.print("Input room's free services: ");
                    String roomNumberOfFloors = scanner.nextLine();

                    return new Room(roomServiceId, roomServiceName, roomUsingArea, roomRentalCosts, roomMaxCapacity, roomLeaseOptions, roomNumberOfFloors);
                case 4:
                    temp = false;
                default:
                    System.out.println("Wrong input, please try again");
            }
        }
        return null;
    }

    @Override
    public void displayMaintenanceList() {
        for (Facility facility : facilities.keySet()) {
            if (facilities.get(facility) >= 5) {
                facilityMaintenanceList.put(facility, facilities.get(facility));
            }
        }
        for (Facility facility : facilityMaintenanceList.keySet()) {
            System.out.println(facility + " has been used: " + facilityMaintenanceList.get(facility) + " times");
        }
    }

    @Override
    public void addingValueToFacilityService(String serviceName) {
        for (Facility x : facilities.keySet()) {
            if (x.getServiceName().equals(serviceName)) {
                facilities.put(x, facilities.get(x) + 1);
            }
        }
    }

    @Override
    public LinkedHashMap<Facility, Integer> getFacilities() {
        return facilities;
    }

    @Override
    public LinkedHashMap<Facility, Integer> getFacilityMaintenanceList() {
        return facilityMaintenanceList;
    }
}
