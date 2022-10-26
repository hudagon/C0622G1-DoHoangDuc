import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        System.out.println(getRandomNumber());
    }


    public static Integer getRandomNumber() {
        Random r = new Random( System.currentTimeMillis() );
        return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
    }
}
