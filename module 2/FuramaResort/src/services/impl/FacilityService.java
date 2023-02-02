package services.impl;

import models.things.Facility;
import models.things.House;
import models.things.Room;
import models.things.Villa;
import services.IFacilityService;
import utils.exception.*;
import utils.read_write_file.read_write_facility.ReadFileFacility;
import utils.read_write_file.read_write_facility.WriteFileFacility;

import java.util.LinkedHashMap;
import java.util.Scanner;

import static utils.validation.facilities.HouseServiceIdRegex.HOUSE_SERVICE_ID_REGEX;
import static utils.validation.facilities.RoomServiceIdRegex.ROOM_SERVICE_ID_REGEX;
import static utils.validation.facilities.ServiceNameRegex.SERVICE_NAME_REGEX;
import static utils.validation.facilities.VillaServiceIdRegex.VILLA_SERVICE_ID_REGEX;

public class FacilityService implements IFacilityService {
    private static final String HOUSE_PATH = "src\\data\\facility\\house.csv";
    private static final String ROOM_PATH = "src\\data\\facility\\room.csv";
    private static final String VILLA_PATH = "src\\data\\facility\\villa.csv";
    private LinkedHashMap<Facility, Integer> facilities = new LinkedHashMap<>();
    private LinkedHashMap<Facility, Integer> facilityMaintenanceList = new LinkedHashMap<>();

    @Override
    public void display() {
        facilities = ReadFileFacility.readFacilityFile(HOUSE_PATH, ROOM_PATH, VILLA_PATH);
        for (Facility facility : facilities.keySet()) {
            System.out.println(facility + " has been used: " + facilities.get(facility) + " times");
        }
    }

    @Override
    public void add() {
        facilities = ReadFileFacility.readFacilityFile(HOUSE_PATH, ROOM_PATH, VILLA_PATH);
        Facility newFacility = this.getFacilityInfo();

        if (newFacility != null) {
            facilities.put(newFacility, 0);

            if (newFacility instanceof House) {
                WriteFileFacility.writeFacilityFile(HOUSE_PATH, facilities);
            } else if (newFacility instanceof Room) {
                WriteFileFacility.writeFacilityFile(ROOM_PATH, facilities);
            } else {
                WriteFileFacility.writeFacilityFile(VILLA_PATH, facilities);
            }

            System.out.println("New facility added successfully!");
        } else {
            System.out.println("Can't accomplished task successfully!");
        }
    }

    @Override
    public void delete() {

    }

    @Override
    public Facility getFacilityInfo() {
        facilities = ReadFileFacility.readFacilityFile(HOUSE_PATH, ROOM_PATH, VILLA_PATH);
        Scanner scanner = new Scanner(System.in);
        boolean temp = true;
        int choice;
        while (temp) {
            int addFacilityChoice;
            while (true) {
                System.out.println("1. Get new villa information\n" +
                        "2. Get new house information\n" +
                        "3. Get new room information\n" +
                        "4. Back to menu\n");
                System.out.print("Input your choice here: ");

                try {
                    addFacilityChoice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input, try again.");
                } catch (Exception e) {
                    System.out.println("Something went wrong!");
                }
            }

            switch (addFacilityChoice) {
                case 1:
                    String villaServiceId = "";
                    while (true) {
                        System.out.print("Input villa id: ");
                        try {
                            villaServiceId = scanner.nextLine();
                            if (!villaServiceId.matches(VILLA_SERVICE_ID_REGEX)) {
                                throw new InvalidServiceIdException("Wrong input, please enter using the following " +
                                        "format (SVVLXXXX)!");
                            }
                            for (Facility x : facilities.keySet()) {
                                if (x.getServiceId().equals(villaServiceId)) {
                                    throw new DuplicatedIdServiceException("There is a facility with the same " +
                                            "Id service, try again.");
                                }
                            }
                            break;
                        } catch (DuplicatedIdServiceException | InvalidServiceIdException e) {
                            System.out.println(e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Something went wrong!");
                        }
                    }

                    String villaServiceName;
                    while (true) {
                        System.out.print("Input villa name: ");
                        try {
                            villaServiceName = scanner.nextLine();
                            villaServiceName = villaServiceName.trim();
                            if (!villaServiceName.matches(SERVICE_NAME_REGEX)) {
                                throw new InvalidServiceNameException("Service name must start with a uppercase character" +
                                        "and following by lowercase characters");
                            }
                            break;
                        } catch (InvalidServiceNameException e) {
                            System.out.println(e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Something went wrong!");
                        }
                    }

                    double villaUsingArea;
                    while (true) {
                        System.out.print("Input using area: ");
                        try {
                            villaUsingArea = Double.parseDouble(scanner.nextLine());
                            if (villaUsingArea < 30.0) {
                                throw new InvalidUsingAreaException("Using area must be greater than 30m2");
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input, you must enter a number");
                        } catch (InvalidUsingAreaException e) {
                            System.out.println(e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Something went wrong!");
                        }
                    }

                    double villaRentalCosts;
                    while (true) {
                        System.out.print("Input rental costs: ");
                        try {
                            villaRentalCosts = Double.parseDouble(scanner.nextLine());
                            if (villaRentalCosts < 0) {
                                throw new InvalidRentalCostException("Rental costs must be positive");
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input, you must enter a number");
                        } catch (InvalidRentalCostException e) {
                            System.out.println(e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Something went wrong!");
                        }
                    }

                    int villaMaxCapacity = 0;
                    while (true) {
                        System.out.print("Input max capacity: ");
                        try {
                            villaMaxCapacity = Integer.parseInt(scanner.nextLine());
                            if (villaMaxCapacity < 0 || villaMaxCapacity > 20) {
                                throw new InvalidMaxCapacityException("Max capacity must be between 0 and 20");
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input, you must enter a number");
                        } catch (InvalidMaxCapacityException e) {
                            System.out.println(e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Something went wrong!");
                        }
                    }

                    String villaLeaseOptions = "";
                    while (temp) {
                        while (true) {
                            System.out.println("--------------------");
                            System.out.print("Choose lease options:\n" +
                                    "1. Years\n" +
                                    "2. Months\n" +
                                    "3. Days\n" +
                                    "4. Hours\n");
                            System.out.print("Input your choice here: ");
                            try {
                                choice = Integer.parseInt(scanner.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input, you must enter a number");
                            } catch (Exception e) {
                                System.out.println("Something went wrong!");
                            }
                        }

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

                    String villaStandard;
                    while (true) {
                        System.out.print("Input villa standard: ");
                        try {
                            villaStandard = scanner.nextLine();
                            villaStandard = villaStandard.trim();
                            if (!villaStandard.matches(SERVICE_NAME_REGEX)) {
                                throw new InvalidServiceNameException("Villa standard must start with a uppercase character" +
                                        "and following by lowercase characters");
                            }
                            break;
                        } catch (InvalidServiceNameException e) {
                            System.out.println(e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Something went wrong!");
                        }
                    }

                    double swimmingPoolArea;
                    while (true) {
                        System.out.print("Input swimming pool area: ");
                        try {
                            swimmingPoolArea = Double.parseDouble(scanner.nextLine());
                            if (swimmingPoolArea < 30.0) {
                                throw new InvalidSwimmingPoolAreaException("Swinmming pool area must be greater than 30m2");
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input, you must enter a number");
                        } catch (InvalidSwimmingPoolAreaException e) {
                            System.out.println(e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Something went wrong!");
                        }
                    }

                    int villaNumberOfFloors;
                    while (true) {
                        System.out.print("Input villa's number of floors: ");
                        try {
                            villaNumberOfFloors = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input, you must enter a number");
                        } catch (Exception e) {
                            System.out.println("Something went wrong!");
                        }
                    }

                    return new Villa(villaServiceId, villaServiceName, villaUsingArea, villaRentalCosts,
                            villaMaxCapacity, villaLeaseOptions, villaStandard, swimmingPoolArea, villaNumberOfFloors);

                case 2:
                    String houseServiceId = "";
                    while (true) {
                        System.out.print("Input house id: ");
                        try {
                            houseServiceId = scanner.nextLine();
                            if (!houseServiceId.matches(HOUSE_SERVICE_ID_REGEX)) {
                                throw new InvalidServiceIdException("Wrong input, please enter using the following " +
                                        "format (SVHOXXXX)!");
                            }
                            for (Facility x : facilities.keySet()) {
                                if (x.getServiceId().equals(houseServiceId)) {
                                    throw new DuplicatedIdServiceException("There is a facility with the same " +
                                            "Id service, try again.");
                                }
                            }
                            break;
                        } catch (DuplicatedIdServiceException | InvalidServiceIdException e) {
                            System.out.println(e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Something went wrong!");
                        }
                    }

                    String houseServiceName;
                    while (true) {
                        System.out.print("Input house name: ");
                        try {
                            houseServiceName = scanner.nextLine();
                            houseServiceName = houseServiceName.trim();
                            if (!houseServiceName.matches(SERVICE_NAME_REGEX)) {
                                throw new InvalidServiceNameException("Service name must start with a uppercase character" +
                                        "and following by lowercase characters");
                            }
                            break;
                        } catch (InvalidServiceNameException e) {
                            System.out.println(e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Something went wrong!");
                        }
                    }

                    double houseUsingArea;
                    while (true) {
                        System.out.print("Input using area: ");
                        try {
                            houseUsingArea = Double.parseDouble(scanner.nextLine());
                            if (houseUsingArea < 30.0) {
                                throw new InvalidUsingAreaException("Using area must be greater than 30m2");
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input, you must enter a number");
                        } catch (InvalidUsingAreaException e) {
                            System.out.println(e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Something went wrong!");
                        }
                    }

                    double houseRentalCosts;
                    while (true) {
                        System.out.print("Input rental costs: ");
                        try {
                            houseRentalCosts = Double.parseDouble(scanner.nextLine());
                            if (houseRentalCosts < 0) {
                                throw new InvalidRentalCostException("Rental costs must be positive");
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input, you must enter a number");
                        } catch (InvalidRentalCostException e) {
                            System.out.println(e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Something went wrong!");
                        }
                    }

                    int houseMaxCapacity = 0;
                    while (true) {
                        System.out.print("Input max capacity: ");
                        try {
                            houseMaxCapacity = Integer.parseInt(scanner.nextLine());
                            if (houseMaxCapacity < 0 || houseMaxCapacity > 20) {
                                throw new InvalidMaxCapacityException("Max capacity must be between 0 and 20");
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input, you must enter a number");
                        } catch (InvalidMaxCapacityException e) {
                            System.out.println(e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Something went wrong!");
                        }
                    }

                    String leaseOptions = "";
                    while (temp) {
                        while (true) {
                            System.out.println("--------------------");
                            System.out.print("Choose lease options:\n" +
                                    "1. Years\n" +
                                    "2. Months\n" +
                                    "3. Days\n" +
                                    "4. Hours\n");
                            System.out.print("Input your choice here: ");
                            try {
                                choice = Integer.parseInt(scanner.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input, you must enter a number");
                            } catch (Exception e) {
                                System.out.println("Something went wrong!");
                            }
                        }

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

                    String houseStandard;
                    while (true) {
                        System.out.print("Input house standard: ");
                        try {
                            houseStandard = scanner.nextLine();
                            houseStandard = houseStandard.trim();
                            if (!houseStandard.matches(SERVICE_NAME_REGEX)) {
                                throw new InvalidServiceNameException("House standard must start with a uppercase character" +
                                        "and following by lowercase characters");
                            }
                            break;
                        } catch (InvalidServiceNameException e) {
                            System.out.println(e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Something went wrong!");
                        }
                    }

                    int houseNumberOfFloors = 0;
                    while (true) {
                        System.out.print("Input house's number of floors: ");
                        try {
                            houseNumberOfFloors = Integer.parseInt(scanner.nextLine());
                            if (houseNumberOfFloors < 0) {
                                throw new InvalidNumberOfFloorsException("Number of floors must be positive");
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input, you must enter a number");
                        } catch (InvalidNumberOfFloorsException e) {
                            System.out.println(e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Something went wrong!");
                        }
                    }

                    return new House(houseServiceId, houseServiceName, houseUsingArea, houseRentalCosts,
                            houseMaxCapacity, leaseOptions, houseStandard, houseNumberOfFloors);

                case 3:
                    String roomServiceId = "";
                    while (true) {
                        System.out.print("Input room id: ");
                        try {
                            roomServiceId = scanner.nextLine();
                            if (!roomServiceId.matches(ROOM_SERVICE_ID_REGEX)) {
                                throw new InvalidServiceIdException("Wrong input, please enter using the following " +
                                        "format (SVROXXXX)!");
                            }
                            for (Facility x : facilities.keySet()) {
                                if (x.getServiceId().equals(roomServiceId)) {
                                    throw new DuplicatedIdServiceException("There is a facility with the same " +
                                            "Id service, try again.");
                                }
                            }
                            break;
                        } catch (DuplicatedIdServiceException | InvalidServiceIdException e) {
                            System.out.println(e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Something went wrong!");
                        }
                    }

                    String roomServiceName;
                    while (true) {
                        System.out.print("Input room name: ");
                        try {
                            roomServiceName = scanner.nextLine();
                            roomServiceName = roomServiceName.trim();
                            if (!roomServiceName.matches(SERVICE_NAME_REGEX)) {
                                throw new InvalidServiceNameException("Service name must start with a uppercase character" +
                                        "and following by lowercase characters");
                            }
                            break;
                        } catch (InvalidServiceNameException e) {
                            System.out.println(e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Something went wrong!");
                        }
                    }

                    double roomUsingArea;
                    while (true) {
                        System.out.print("Input using area: ");
                        try {
                            roomUsingArea = Double.parseDouble(scanner.nextLine());
                            if (roomUsingArea < 30.0) {
                                throw new InvalidUsingAreaException("Using area must be greater than 30m2");
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input, you must enter a number");
                        } catch (InvalidUsingAreaException e) {
                            System.out.println(e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Something went wrong!");
                        }
                    }

                    double roomRentalCosts;
                    while (true) {
                        System.out.print("Input rental costs: ");
                        try {
                            roomRentalCosts = Double.parseDouble(scanner.nextLine());
                            if (roomRentalCosts < 0) {
                                throw new InvalidRentalCostException("Rental costs must be positive");
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input, you must enter a number");
                        } catch (InvalidRentalCostException e) {
                            System.out.println(e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Something went wrong!");
                        }
                    }

                    int roomMaxCapacity = 0;
                    while (true) {
                        System.out.print("Input max capacity: ");
                        try {
                            roomMaxCapacity = Integer.parseInt(scanner.nextLine());
                            if (roomMaxCapacity < 0 || roomMaxCapacity > 20) {
                                throw new InvalidMaxCapacityException("Max capacity must be between 0 and 20");
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input, you must enter a number");
                        } catch (InvalidMaxCapacityException e) {
                            System.out.println(e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Something went wrong!");
                        }
                    }

                    String roomLeaseOptions = "";
                    while (temp) {
                        while (true) {
                            System.out.println("--------------------");
                            System.out.print("Choose lease options:\n" +
                                    "1. Years\n" +
                                    "2. Months\n" +
                                    "3. Days\n" +
                                    "4. Hours\n");
                            System.out.print("Input your choice here: ");
                            try {
                                choice = Integer.parseInt(scanner.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input, you must enter a number");
                            } catch (Exception e) {
                                System.out.println("Something went wrong!");
                            }
                        }

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

                    String roomFreeServices = "";
                    while (true) {
                        System.out.print("Input room's free services: ");
                        try {
                            roomFreeServices = scanner.nextLine();
                            if (!roomFreeServices.matches(SERVICE_NAME_REGEX)) {
                                throw new InvalidServiceNameException("Free services must start with a uppercase character" +
                                        "and following by lowercase characters");
                            }
                            break;
                        } catch (InvalidServiceNameException e) {
                            System.out.println(e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Something went wrong!");
                        }
                    }

                    return new Room(roomServiceId, roomServiceName, roomUsingArea, roomRentalCosts, roomMaxCapacity,
                            roomLeaseOptions, roomFreeServices);
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
        facilities = ReadFileFacility.readFacilityFile(HOUSE_PATH, ROOM_PATH, VILLA_PATH);
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
                if (x instanceof House) {
                    WriteFileFacility.writeFacilityFile(HOUSE_PATH, facilities);
                } else if (x instanceof Room) {
                    WriteFileFacility.writeFacilityFile(ROOM_PATH, facilities);
                } else {
                    WriteFileFacility.writeFacilityFile(VILLA_PATH, facilities);
                }
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

    @Override
    public void setFacilityMaintenanceList(LinkedHashMap<Facility, Integer> facilityMaintenanceList) {
        this.facilityMaintenanceList = facilityMaintenanceList;
    }
}
