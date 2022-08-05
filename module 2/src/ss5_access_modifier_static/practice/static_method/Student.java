package ss5_access_modifier_static.practice.static_method;

public class Student {
    private int rollno;
    private String name;
    private static String college = "DUE";

    Student(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    static void change() {
        college = "CODEGYM";
    }

    public String display() {
        return name + " is the student number " + rollno + " who studies in " + college;
    }
}
