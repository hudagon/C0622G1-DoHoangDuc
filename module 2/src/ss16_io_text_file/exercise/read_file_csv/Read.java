package ss16_io_text_file.exercise.read_file_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Read {
    public static void readFile(String path) {
        List<Country> countries = new ArrayList<>();

        try {
            File nameFile = new File(path);

            if (!nameFile.exists()) {
                throw new FileNotFoundException();
            }

            FileReader fileReader = new FileReader(nameFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] country = line.split(",");
                countries.add(new Country(Integer.parseInt(country[0]), country[1], country[2]));
            }
            bufferedReader.close();

            for (Country country : countries) {
                System.out.println(country.toString());
            }
        } catch (FileNotFoundException e) {
            System.out.println("404 File Not Found!");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input file's path: ");
        String path = scanner.nextLine();
        readFile(path);
    }
}
