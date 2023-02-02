package utils.read_write_file.read_write_facility;

import models.things.Facility;
import models.things.House;
import models.things.Room;
import models.things.Villa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedHashMap;

public class ReadFileFacility {
    static public LinkedHashMap<Facility, Integer> readFacilityFile(String housePath, String roomPath, String villaPath) {
        LinkedHashMap<Facility, Integer> facilities = new LinkedHashMap<>();

        try {
            File fileHouse = new File(housePath);
            FileReader fileReaderHouse = new FileReader(fileHouse);
            BufferedReader bufferedReaderHouse = new BufferedReader(fileReaderHouse);

            String line;
            String[] elements;
            while ((line = bufferedReaderHouse.readLine()) != null) {
                elements = line.split(",");
                facilities.put((new House(
                                elements[0],
                                elements[1],
                                Double.parseDouble(elements[2]),
                                Double.parseDouble(elements[3]),
                                Integer.parseInt(elements[4]),
                                elements[5],
                                elements[6],
                                Integer.parseInt(elements[7]))),
                        Integer.parseInt(elements[8]));
            }

            bufferedReaderHouse.close();
        } catch (FileNotFoundException e) {
            System.out.println("404 File Not Found!");
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }

        try {
            File fileRoom = new File(roomPath);
            FileReader fileReaderRoom = new FileReader(fileRoom);
            BufferedReader bufferedReaderRoom = new BufferedReader(fileReaderRoom);

            String line;
            String[] elements;
            while ((line = bufferedReaderRoom.readLine()) != null) {
                elements = line.split(",");
                facilities.put((new Room(
                                elements[0],
                                elements[1],
                                Double.parseDouble(elements[2]),
                                Double.parseDouble(elements[3]),
                                Integer.parseInt(elements[4]),
                                elements[5],
                                elements[6])),
                        Integer.parseInt(elements[7]));
            }

            bufferedReaderRoom.close();
        } catch (FileNotFoundException e) {
            System.out.println("404 File Not Found!");
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }

        try {
            File fileVilla = new File(villaPath);
            FileReader fileReaderVilla = new FileReader(fileVilla);
            BufferedReader bufferedReaderVilla = new BufferedReader(fileReaderVilla);

            String line;
            String[] elements;
            while ((line = bufferedReaderVilla.readLine()) != null) {
                elements = line.split(",");
                facilities.put((new Villa(
                                elements[0],
                                elements[1],
                                Double.parseDouble(elements[2]),
                                Double.parseDouble(elements[3]),
                                Integer.parseInt(elements[4]),
                                elements[5],
                                elements[6],
                                Double.parseDouble(elements[7]),
                                Integer.parseInt(elements[8]))),
                        Integer.parseInt(elements[9]));
            }

            bufferedReaderVilla.close();
        } catch (FileNotFoundException e) {
            System.out.println("404 File Not Found!");
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }

        return facilities;
    }
}
