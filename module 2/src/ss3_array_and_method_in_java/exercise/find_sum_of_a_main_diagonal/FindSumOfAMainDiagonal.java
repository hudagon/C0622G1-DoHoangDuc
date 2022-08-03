package ss3_array_and_method_in_java.exercise.find_sum_of_a_main_diagonal;

import java.util.Scanner;

public class FindSumOfAMainDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1, n2;


        System.out.print("Input the row length: ");
        n1 = Integer.parseInt(scanner.nextLine());
        System.out.print("Input the column length: ");
        n2 = Integer.parseInt(scanner.nextLine());

        while (n2 != n1) {
            System.out.println("the row length and column length must be the same, please input again");
            System.out.print("Input the row length: ");
            n1 = Integer.parseInt(scanner.nextLine());
            System.out.print("Input the column length: ");
            n2 = Integer.parseInt(scanner.nextLine());
        }

        double[][] arr1 = new double[n1][];
        double sum = 0;

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = new double[n2];
            for (int j = 0; j < arr1[i].length; j++) {
                System.out.print("Input the " + (j + i) + "th elements in array: ");
                arr1[i][j] = Double.parseDouble(scanner.nextLine());

                if (i == j) {
                    sum += arr1[i][j];
                }
            }
        }

        System.out.print(" Sum is: " + sum);
    }
}
