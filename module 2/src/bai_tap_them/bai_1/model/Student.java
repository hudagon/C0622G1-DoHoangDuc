package bai_tap_them.bai_1.model;

public class Student extends Person {
    private double point;
    private String className;

    public Student() {
    }

    public Student(double point, String className) {
        this.point = point;
        this.className = className;
    }

    public Student(int id, String name, String birthday, String gender, double point, String className) {
        super(id, name, birthday, gender);
        this.point = point;
        this.className = className;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return  super.toString() + "'," + point + ", " + className;
    }
}
