package ss2_loop_in_java.exercise.display_Prime_number_less_than_100;

public class DisplayPrimeLess100 {
    public static void main(String[] args) {
        int number = 2;
        int prime = 0;

        while (true) {
            int count = 0;
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    count++;
                }
            }

            if (count == 0) {
                prime = number;
                System.out.println(prime);
            }

            number ++;
            if (number == 100) {
                break;
            }
        }
    }
}
