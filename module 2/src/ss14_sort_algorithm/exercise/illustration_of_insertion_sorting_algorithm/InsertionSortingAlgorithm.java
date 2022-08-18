package ss14_sort_algorithm.exercise.illustration_of_insertion_sorting_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortingAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size: ");
        int size = scanner.nextInt();
        int[] list = new int[size];


        for (int i = 0; i < list.length; i++) {
            System.out.print("Enter " + i + "th values: ");
            list[i] = scanner.nextInt();
        }

        System.out.println("Your input list before sorting: " + Arrays.toString(list));


        insertionSorting(list);
        System.out.println("Your input list after sorting: " + Arrays.toString(list));
    }

    public static void insertionSorting(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int temp = list[i];
            int j;
            for (j = i - 1; j >= 0 && list[j] > temp; j--) {
                list[j + 1] = list[j];
            }
            list[j + 1] = temp;
        }
    }
}
