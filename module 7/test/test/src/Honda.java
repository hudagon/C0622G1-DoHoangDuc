public class Honda extends Bike implements RePaintable,Containable{
    @Override
    void run() {
        System.out.println("hello");
    }
//    void honk() {
//        System.out.println("world");
//    }
//    void fillGas() {
//        System.out.println("honda fill gas");
//    }
    public static void main(String[] args) {
        Bike bike1 = new Honda();
        bike1.run();
    }

    @Override
    public void contain() {

    }

    @Override
    public void rePaint() {

    }
}
