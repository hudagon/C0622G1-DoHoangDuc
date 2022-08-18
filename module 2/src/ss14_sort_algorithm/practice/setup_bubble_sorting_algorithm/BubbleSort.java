package ss14_sort_algorithm.practice.setup_bubble_sorting_algorithm;


public class BubbleSort {

    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    public static void bubbleSort(int[] list) {
        boolean isNotSwap = true;
        for (int i = 1; i < list.length && isNotSwap; i++) {
            isNotSwap = false;
            for (int j = 0; j < list.length - i; j++) {
                if (list[j] > list[j + 1]) {
                    isNotSwap = true;
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        bubbleSort(list);
        for (int value : list) System.out.print(value + " ");
    }

}


