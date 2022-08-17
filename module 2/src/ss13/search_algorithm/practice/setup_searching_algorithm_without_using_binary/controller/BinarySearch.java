package ss13.search_algorithm.practice.setup_searching_algorithm_without_using_binary.controller;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(binarySearch(arr,3));
    }


    public static int binarySearch(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (k < arr[mid])
                high = mid - 1;
            else if (k == arr[mid])
                return mid;
            else
                low = mid + 1;
        }
        return -1;
    }

}

