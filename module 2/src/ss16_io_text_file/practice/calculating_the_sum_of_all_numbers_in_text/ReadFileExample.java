package ss16_io_text_file.practice.calculating_the_sum_of_all_numbers_in_text;

import java.io.*;
import java.util.Scanner;

public class ReadFileExample {
    public void readFileText(String filePath) {
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            int sum = 0;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            bufferedReader.close();

            System.out.println("Sum of all the numbers in text file is: " + sum);

        } catch (Exception e) {
            System.out.println("File not found or something went wrong!");
        }
    }

    public static void main(String[] args) {
        System.out.print("Input file's path: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        ReadFileExample readFileExample = new ReadFileExample();
        readFileExample.readFileText(path);

    }
}
