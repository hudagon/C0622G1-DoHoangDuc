package ss3_array_and_method_in_java.exercise.find_sum_of_a_determined_column;

import java.util.Scanner;

public class FindSumOfAColumn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1, n2, n3;


        System.out.print("Input the number of elements you want in arr1: ");
        n1 = Integer.parseInt(scanner.nextLine());

        double[][] arr1 = new double[n1][];
        double sum = 0;

        for (int i = 0; i < arr1.length; i++) {
            System.out.print("Input the number of elements you want in arr[" + i + "]: ");
            n2 = Integer.parseInt(scanner.nextLine());
            arr1[i] = new double[n2];
            for (int j = 0; j < arr1[i].length; j++) {
                System.out.print("Input the " + j + "th elements in array: ");
                arr1[i][j] = Double.parseDouble(scanner.nextLine());
            }
        }

        System.out.print("Input the column index you want to sum: ");
        n3 = Integer.parseInt(scanner.nextLine());

        for (double[] doubles : arr1) {
            sum += doubles[n3];
        }

        System.out.println("Sum is: " + sum);
    }
}
