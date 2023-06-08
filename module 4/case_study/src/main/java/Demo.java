import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {

    }

    public static int calculateAge(LocalDate dob) {
        LocalDate curDate = LocalDate.now();

        if ((dob != null) && (curDate != null)) {
            return Period.between(dob, curDate).getYears();
        } else {
            return 0;
        }
    }
}
