package ss3_array_and_method_in_java.exercise.find_min;

public class FindMin {
    public static void main(String[] args) {
        int[] arr1 = {2,3,4,5,5,123,5,6,-1,2};
        int min = arr1[0];

        for (int i = 1; i < arr1.length; i++) {
            if (min > arr1[i]) {
                min = arr1[i];
            }
        }
        System.out.println("Min is: " + min);
    }
}
