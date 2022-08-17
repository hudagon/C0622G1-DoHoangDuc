package ss13.search_algorithm.exercise.setup_searching_algorithm_using_binary.controller;

import java.util.Arrays;
import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the number of elements you want to be in the array: ");
        int numElements = Integer.parseInt(scanner.nextLine());
        int[] intArr = new int[numElements];

        for (int i = 0; i < intArr.length; i++) {
            System.out.print("Input the element at index " + i + ": ");
            intArr[i] = Integer.parseInt(scanner.nextLine());
        }

        System.out.print("Input the number you want to find: ");
        int find = Integer.parseInt(scanner.nextLine());

        Arrays.sort(intArr);

        int em = binarySearch(intArr, find, 0, intArr.length - 1);

        if (em == -1) {
            System.out.println("can't found em");
        } else {
            System.out.println("found em in the index of: " + em);
        }
    }

    public static int binarySearch(int[] arr, int k, int left, int right) {
        if (right >= left) {
            int mid = (left + right) / 2;

            if (k == arr[mid]) {
                return mid;
            }

            if (k > arr[mid]) {
                return binarySearch(arr,k,mid + 1,right);
            }

            return binarySearch(arr,k,left,mid -1);
        }
        return -1;
    }
}

