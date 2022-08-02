package ss2_loop_in_java.exercise.merge_array;

import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1,n2;

        System.out.print("Input the number of elements you want in arr: ");
        n1 = scanner.nextInt();
        System.out.print("Input the number of elements you want in arr1: ");
        n2 = scanner.nextInt();

        int[] arr = new int[n1];
        int[] arr1 = new int[n2];
        int[] arr2 = new int[(n2 + n1)];

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Input the " + i + "th elements in array");
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < arr1.length; i++) {
            System.out.println("Input the " + (i + 5) + "th elements in array");
            arr1[i] = scanner.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
        for (int i = 0; i < arr1.length; i++) {
            arr2[i + arr1.length + 1] = arr1[i];
        }

        for (int i = 0; i < arr2.length - 1; i++) {
            System.out.print(arr2[i] + ",");
        }
        System.out.println(arr2[arr2.length-1]);

    }
}
