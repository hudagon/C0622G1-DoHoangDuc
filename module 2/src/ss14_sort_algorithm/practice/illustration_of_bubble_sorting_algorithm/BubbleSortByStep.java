package ss14_sort_algorithm.practice.illustration_of_bubble_sorting_algorithm;

import java.util.Scanner;

public class BubbleSortByStep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size:");
        int size = scanner.nextInt();
        int[] list = new int[size];

        System.out.println("Enter " + list.length + " values:");
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }

        System.out.print("Your input list before sorting: ");
        for (int value : list) {
            System.out.print(value + " ");
        }

        bubbleSortByStep(list);
        System.out.print("Your input list after sorting: ");
        for (int value : list) {
            System.out.print(value + " ");
        }
    }

    public static void bubbleSortByStep(int[] list) {
        boolean isSwap = true;
        for (int i = 1; i < list.length && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < list.length - i; j++) {
                if (list[j + 1] < list[j]) {
                    isSwap = true;
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }
}
