package ss16_io_text_file.practice.find_max_and_write_to_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public List<Integer> readFile(String path) {
        List<Integer> numbers = new ArrayList<Integer>();
        try {
            File file = new File(path);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals("")) {
                    continue;
                }

                numbers.add(Integer.parseInt(line));
            }
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }

        return numbers;
    }

    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (Integer number : numbers) {
            if (max < number) {
                max = number;
            }
        }
        return max;
    }

    public void writeFile(String filePath, int max) throws IOException {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
            bufferedWriter.write("Max is: " + max);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("src\\ss16_io_text_file\\numbers.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("src\\ss16_io_text_file\\result.txt", maxValue);
    }
}
