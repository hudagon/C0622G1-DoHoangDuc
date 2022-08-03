package ss3_array_and_method_in_java.practice.find_elements_in_array;

import java.util.Scanner;

public class FindElementsInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isExist = false;
        String[] students = {"Adam", "Alan", "Rowan", "Byron", "Elie"};

        System.out.print("Input name here: ");
        String inputName = scanner.nextLine();

        for (int i = 0; i < students.length; i++) {
            if(students[i].equals(inputName)) {
                System.out.println("Position of the student whose name is " + inputName + " is " + i);
                isExist = true;
                break;
            }
        }

        if(!isExist) {
            System.out.println("Can't found this student!");
        }
    }
}
