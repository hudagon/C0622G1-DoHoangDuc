package ss2_loop_in_java.exercise.display_first_20_Prime_number;

public class DisplayFirst20Prime {
    public static void main(String[] args) {
        int count = 0, count1;
        int number = 2;
        int prime;

        while (true) {
            count1 = 0;
            for (int i = 2; i < number ; i++) {
                if (number % i == 0) {
                    count1++;
                }
            }

            if (count1 == 0) {
                prime = number;
                System.out.println(prime);
                count++;
            }
            number++;
            if (count == 20) {
                break;
            }
        }
    }
}
