package ss14_sort_algorithm.exercise.setup_insertion_sorting_algorithm;

import java.util.Arrays;

public class InsertionSorting {
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

    public static void main(String[] args) {
        int[] list = {5,6,3,11,66,4};
        insertionSorting(list);
        System.out.println(Arrays.toString(list));
    }
}
