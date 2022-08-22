package ss16_io_text_file.exercise.copy_file_text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadAndWrite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input source file's path: ");
        String nameFilePath = scanner.nextLine();
        List<String> names = readNameFile(nameFilePath);

        System.out.print("Input target file's path: ");
        String targetFilePath = scanner.nextLine();
        writeNameFile(targetFilePath, names);
    }


    public static List<String> readNameFile(String path) {
        List<String> names = new ArrayList<>();

        try {
            File nameFile = new File(path);

            if (!nameFile.exists()) {
                throw new FileNotFoundException();
            }

            FileReader fileReader = new FileReader(nameFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.equals("")) {
                    names.add(line);
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("404 File Not Found!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return names;
    }

    public static void writeNameFile(String filePath, List<String> names) {
        try {
            int sum = 0;
            File nameFile = new File(filePath);

            if (nameFile.exists()) {
                throw new Exception();
            }

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));

            for (String name : names) {
                for (int j = 0; j < name.length(); j++) {
                    sum += 1;
                }
                bufferedWriter.write(name);
                bufferedWriter.newLine();
            }
            bufferedWriter.write("There are " + sum + " characters in this text.");
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("File's already existed!");
        }
    }
}
