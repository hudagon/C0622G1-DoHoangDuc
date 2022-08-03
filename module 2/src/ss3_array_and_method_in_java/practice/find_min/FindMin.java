package ss3_array_and_method_in_java.practice.find_min;

public class FindMin {
    public static void main(String[] args) {
        double[] arr1 = {1,2,3,0.2,0.1,4,5,6};
        double index = findMin(arr1);
        System.out.println("The smallest element in the array is: " + index);
    }

    public static double findMin(double[] array) {
        double min = array[0];
        for (int i = 0; i < array.length ; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }
}
