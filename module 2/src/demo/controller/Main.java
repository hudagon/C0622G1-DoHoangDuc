package demo.controller;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {9, 4, -1, 24, 7, -7, 123, 55};

        for (int i = 1; i < numbers.length - 1; i++) {
            int k = numbers[i];

            for (int j = i; j >= 0; j--) {
                numbers[j-1] = numbers[j];
            }

            numbers[i+1] = k;

        }

        for (int number : numbers) {
            System.out.print(number + " ");
        }

    }
}
