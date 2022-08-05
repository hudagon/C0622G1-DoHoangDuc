package ss5_access_modifier_static.exercise.access_modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle(10);

        System.out.println("This circle has the radius of: " + circle.getRadius());
        System.out.println("This circle has the area of: " + circle.getArea());
    }
}
