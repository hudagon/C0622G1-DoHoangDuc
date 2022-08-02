package ss2_loop_in_java.practice.check_prime_number;

import java.util.Scanner;

public class CheckPrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        int count = 0;

        System.out.println("Input the number you want to check here: ");
        number = scanner.nextInt();

        if (number < 2) {
            System.out.println("This isn't a Prime number!");
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    count++;
                }
            }

            if (count != 0) {
                System.out.println(number + " is not a Prime number!");
            } else {
                System.out.println(number + " is a Prime number");
            }
        }

    }
}

