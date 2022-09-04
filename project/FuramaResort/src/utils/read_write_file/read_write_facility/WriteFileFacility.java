package utils.read_write_file.read_write_facility;

import models.things.Facility;
import models.things.House;
import models.things.Room;
import models.things.Villa;
import services.impl.FacilityService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class WriteFileFacility {
    static FacilityService facilityService = new FacilityService();
    static LinkedHashMap<Facility, Integer> facilityMaintenanceList = new LinkedHashMap<>();
    public static final String HOUSE_PATH = "src\\data\\facility\\house.csv";
    public static final String ROOM_PATH = "src\\data\\facility\\room.csv";
    public static final String VILLA_PATH = "src\\data\\facility\\villa.csv";

    public static void writeFacilityFile(String path, LinkedHashMap<Facility, Integer> facilities) {
        switch (path) {
            case HOUSE_PATH:
                try {
                    LinkedHashMap<House, Integer> listHouses = new LinkedHashMap<>();
                    for (Facility x : facilities.keySet()) {
                        if (x instanceof House) {
                            listHouses.put((House) x, facilities.get(x));
                        }
                    }

                    File fileHouse = new File(path);
                    FileWriter houseWriter = new FileWriter(fileHouse);
                    BufferedWriter bufferedHouseWriter = new BufferedWriter(houseWriter);

                    List<String> result = listHouseConvertedToListString(listHouses);

                    for (String house : result) {
                        bufferedHouseWriter.write(house);
                        bufferedHouseWriter.newLine();
                    }

                    bufferedHouseWriter.close();
                } catch (IOException e) {
                    System.out.println("Something went wrong!");
                }
                for (Facility facility : facilities.keySet()) {
                    if (facilities.get(facility) >= 5) {
                        facilityMaintenanceList.put(facility, facilities.get(facility));
                    }
                }
                facilityService.setFacilityMaintenanceList(facilityMaintenanceList);
                break;
            case ROOM_PATH:
                try {
                    LinkedHashMap<Room, Integer> listRooms = new LinkedHashMap<>();
                    for (Facility x : facilities.keySet()) {
                        if (x instanceof Room) {
                            listRooms.put((Room) x, facilities.get(x));
                        }
                    }

                    File fileRoom = new File(path);
                    FileWriter roomWriter = new FileWriter(fileRoom);
                    BufferedWriter bufferedRoomWriter = new BufferedWriter(roomWriter);

                    List<String> result = listRoomConvertedToListString(listRooms);

                    for (String room : result) {
                        bufferedRoomWriter.write(room);
                        bufferedRoomWriter.newLine();
                    }

                    bufferedRoomWriter.close();
                } catch (IOException e) {
                    System.out.println("Something went wrong!");
                }
                for (Facility facility : facilities.keySet()) {
                    if (facilities.get(facility) >= 5) {
                        facilityMaintenanceList.put(facility, facilities.get(facility));
                    }
                }
                facilityService.setFacilityMaintenanceList(facilityMaintenanceList);
                break;
            case VILLA_PATH:
                try {
                    LinkedHashMap<Villa, Integer> listVillas = new LinkedHashMap<>();
                    for (Facility x : facilities.keySet()) {
                        if (x instanceof Villa) {
                            listVillas.put((Villa) x, facilities.get(x));
                        }
                    }

                    File fileVilla = new File(path);
                    FileWriter villaWriter = new FileWriter(fileVilla);
                    BufferedWriter bufferedVillaWriter = new BufferedWriter(villaWriter);

                    List<String> result = listVillaConvertedToListString(listVillas);

                    for (String villa : result) {
                        bufferedVillaWriter.write(villa);
                        bufferedVillaWriter.newLine();
                    }

                    bufferedVillaWriter.close();
                } catch (IOException e) {
                    System.out.println("Something went wrong!");
                }
                for (Facility facility : facilities.keySet()) {
                    if (facilities.get(facility) >= 5) {
                        facilityMaintenanceList.put(facility, facilities.get(facility));
                    }
                }
                facilityService.setFacilityMaintenanceList(facilityMaintenanceList);
                break;
            default:
                System.out.println("Can't Found path!");
        }
    }

    public static List<String> listHouseConvertedToListString(LinkedHashMap<House, Integer> listHouses) {
        List<String> result = new ArrayList<>();
        for (House x : listHouses.keySet()) {
            result.add(convertHouseToStringInRightFormat(x) + "," + listHouses.get(x));
        }
        return result;
    }
    public static List<String> listRoomConvertedToListString(LinkedHashMap<Room, Integer> listRooms) {
        List<String> result = new ArrayList<>();
        for (Room x : listRooms.keySet()) {
            result.add(convertRoomToStringInRightFormat(x) + "," + listRooms.get(x));
        }
        return result;
    }
    public static List<String> listVillaConvertedToListString(LinkedHashMap<Villa, Integer> listVillas) {
        List<String> result = new ArrayList<>();
        for (Villa x : listVillas.keySet()) {
            result.add(convertVillaToStringInRightFormat(x) + "," + listVillas.get(x));
        }
        return result;
    }

    public static String convertHouseToStringInRightFormat(House house) {
        return house.getServiceId() + "," +
                house.getServiceName() + "," +
                house.getUsingArea() + "," +
                house.getRentalCosts() + "," +
                house.getMaxCapacity() + "," +
                house.getLeaseOptions() + "," +
                house.getHouseStandard() + "," +
                house.getNumberOfFloors();
    }
    public static String convertRoomToStringInRightFormat(Room room) {
        return room.getServiceId() + "," +
                room.getServiceName() + "," +
                room.getUsingArea() + "," +
                room.getRentalCosts() + "," +
                room.getMaxCapacity() + "," +
                room.getLeaseOptions() + "," +
                room.getFreeServiceIncluded();
    }
    public static String convertVillaToStringInRightFormat(Villa villa) {
        return villa.getServiceId() + "," +
                villa.getServiceName() + "," +
                villa.getUsingArea() + "," +
                villa.getRentalCosts() + "," +
                villa.getMaxCapacity() + "," +
                villa.getLeaseOptions() + "," +
                villa.getVillaStandard() + "," +
                villa.getSwimmingPoolArea() + "," +
                villa.getNumberOfFloors();
    }
}
