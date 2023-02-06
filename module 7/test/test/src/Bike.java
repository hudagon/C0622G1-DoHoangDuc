public abstract class Bike {

     abstract void run();
     void honk () {
         System.out.println("bike honk");
     }

     final void fillGas() {
         System.out.println("Bike fill gas");
     }

}
