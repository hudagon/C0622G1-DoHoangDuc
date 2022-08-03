package ss3_array_and_method_in_java.exercise.find_max_in_2d_array;

import java.util.Scanner;

public class FindMaxIn2dArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1,n2, x = 0, y = 0;


        System.out.print("Input the number of elements you want in arr1: ");
        n1 = scanner.nextInt();

        double[][] arr1 = new double[n1][];

        for (int i = 0; i < arr1.length; i++) {
            System.out.print("Input the number of elements you want in arr[" + i + "]: ");
            n2 = scanner.nextInt();
            arr1[i] = new double[n2];
            for (int j = 0; j < arr1[i].length; j++) {
                System.out.print("Input the " + j + "th elements in array: ");
                arr1[i][j] = Double.parseDouble(scanner.nextLine());
            }
        }

        double max = arr1[0][0];

        for (int i = 0; i < arr1.length ; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                if (max > arr1[i][j]) {
                    max = arr1[i][j];
                    x = i;
                    y = j;
                }
            }
        }

        System.out.println("The array is here:");
        for (double[] ints : arr1) {
            for (double anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.printf("The Elements that has the highest value is: %10.2f which is located at arr1[%d][%d]", max, x,y);
    }
}
