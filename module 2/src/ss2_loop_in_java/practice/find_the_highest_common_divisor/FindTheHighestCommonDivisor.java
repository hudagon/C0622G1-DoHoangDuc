package ss2_loop_in_java.practice.find_the_highest_common_divisor;

import java.util.Scanner;

public class FindTheHighestCommonDivisor {
    public static void main(String[] args) {
        int a,b;
        Scanner input = new Scanner(System.in);

        System.out.println("Input a: ");
        a = input.nextInt();

        System.out.println("Input b: ");
        b = input.nextInt();

        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0 || b == 0) {
            System.out.println("There is no highest common divisor");
        }

        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }

        System.out.println("Highest common divisor: " + a);
    }
}
