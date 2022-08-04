package ss4_oop.exercise.build_quadratic_equation_class;

public class QuadraticEquation {
    double a,b,c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminat() {
        return (b * b) - (4 * a * c);
    }

    public double getRoo1() {
        return (-b + Math.sqrt((b * b) - (4 * a * c))) / (2 * a);
    }


    public double getRoo2() {
        return (-b - Math.sqrt((b * b) - (4 * a * c))) / (2 * a);
    }
}
