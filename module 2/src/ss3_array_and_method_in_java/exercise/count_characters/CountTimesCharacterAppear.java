package ss3_array_and_method_in_java.exercise.count_characters;

import java.util.Scanner;

public class CountTimesCharacterAppear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        String str1 = "Hello World";

        System.out.print("Input the character you want to check: ");
        char charact = scanner.nextLine().charAt(0);
        System.out.println(charact);

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == charact) {
                count++;
            }
        }

        System.out.println("Times the character you input appears are: " + count);
    }
}
