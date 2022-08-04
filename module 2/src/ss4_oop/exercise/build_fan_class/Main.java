package ss4_oop.exercise.build_fan_class;

public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();

        fan1.setSpeed(fan1.getFAST());
        fan1.setOn(true);
        fan1.setColor("yellow");
        fan1.setRadius(10);

        fan2.setSpeed(fan2.getMEDIUM());
        fan2.setOn(false);
        fan2.setColor("blue");
        fan2.setRadius(5);

        System.out.println(fan1.toString());
        System.out.println(fan2.toString());

    }
}
